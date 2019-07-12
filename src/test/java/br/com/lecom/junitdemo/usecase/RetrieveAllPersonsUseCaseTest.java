/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lecom.junitdemo.usecase;

import br.com.lecom.junitdemo.model.Person;
import br.com.lecom.junitdemo.service.PersonService;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
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
public class RetrieveAllPersonsUseCaseTest {
    
    @InjectMocks
    private RetrieveAllPersonsUseCase retrieveAllPersonsUseCase;
    
    @Mock
    private PersonService personService;
    
    /**
     * Test of execute method, of class RetrieveAllPersonsUseCase.
     */
    @Test
    public void testExecute() {
        final List<Person> persons = Arrays.asList(new Person("Nome 1"), new Person("Nome 2"), new Person("Nome 3"));
        
       //mock
        Mockito.when(personService.retrieveAll()).thenReturn(persons);
        
        //execução
        final List<Person> personsResult = retrieveAllPersonsUseCase.execute();
        
        //verificação
        Mockito.verify(personService, Mockito.times(1)).retrieveAll();
        Assert.assertNotNull(personsResult);
        Assert.assertFalse(personsResult.isEmpty());
        Assert.assertSame(persons, personsResult);
        
    }
    
}
