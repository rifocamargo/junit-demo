/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lecom.junitdemo.usecase;

import br.com.lecom.junitdemo.model.Person;
import br.com.lecom.junitdemo.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ricardo.camargo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SavePersonUseCaseTest {
    
    @InjectMocks
    private SavePersonUseCase savePeopleUseCase;
    
    @Mock
    private PersonService personService;
    
    /**
     * Test of execute method, of class UseCaseA.
     */
    @Test
    public void testExecute() {
        //mock
        Mockito.when(personService.save(Mockito.any(Person.class))).thenReturn(new Person("Nome Teste"));
        
        //execução
        final Person person = savePeopleUseCase.execute(new Person("Nome Teste"));
        
        //verificação
        Mockito.verify(personService, Mockito.times(1)).save(Mockito.any(Person.class));
        Assert.assertNotNull(person);
        Assert.assertEquals("Nome Teste", person.getName());
    }
    
}
