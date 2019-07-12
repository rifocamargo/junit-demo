package br.com.lecom.junitdemo.usecase;

import br.com.lecom.junitdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lecom.junitdemo.service.PersonService;

/**
 *
 * @author ricardo.camargo
 */
@Component
public class SavePersonUseCase {
    
    @Autowired
    private PersonService personService;
    
    public Person execute(final Person person) {
        return personService.save(person);
    }
}