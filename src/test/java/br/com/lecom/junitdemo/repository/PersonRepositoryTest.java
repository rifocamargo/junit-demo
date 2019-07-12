/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lecom.junitdemo.repository;

import br.com.lecom.junitdemo.model.Person;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ricardo.camargo
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts = "/person.sql")
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void saveTest() {
        //execução
        final Person person = personRepository.save(new Person("Nome Teste"));

        //verificação
        Assert.assertNotNull(person);
        Assert.assertNotNull(person.getId());
        Assert.assertEquals("Nome Teste", person.getName());
    }
    
    @Test
    public void retrieveTest() {
        //mock
        final Person person = personRepository.save(new Person("Nome Teste"));
        
        //execução
        final Optional<Person> personById = personRepository.findById(person.getId());

        //verificação
        Assert.assertTrue(personById.isPresent());
        Assert.assertEquals(personById.get().getName(), person.getName());
    }
    
    @Test
    public void retrieveAllTest() {
        //mock
        for (int i = 0; i < 10; i++) {
           personRepository.save(new Person("Nome Teste"+i));
        }
        
        //execução
        final List<Person> allPersons = personRepository.findAll();

        //verificação
        Assert.assertFalse(allPersons.isEmpty());
        Assert.assertEquals(10, allPersons.size());
    }
    
    public void updateTest() {
        final Person person = personRepository.save(new Person("Nome Teste"));
        
        person.setName("Nome Teste update");
        
        Person newPerson = personRepository.save(person);
        
        Assert.assertNotNull(newPerson);
        Assert.assertEquals(person.getId(), newPerson.getId());
        Assert.assertEquals(person.getName(), newPerson.getName());
    }
}
