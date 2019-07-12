/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lecom.junitdemo.service;

import br.com.lecom.junitdemo.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.lecom.junitdemo.repository.PersonRepository;

/**
 *
 * @author ricardo.camargo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of doiIt method, of class ServiceA.
     */
    @Test
    public void testSave() {
        //mock
        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(new Person("Nome Teste"));

        //execução
        final Person person = personService.save(new Person("Nome Teste"));
        
        //verificação
        Mockito.verify(personRepository, Mockito.times(1)).save(Mockito.any(Person.class));
        Assert.assertNotNull(person);
        Assert.assertEquals("Nome Teste", person.getName());
    }

}
