package br.com.lecom.junitdemo.usecase;

import br.com.lecom.junitdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lecom.junitdemo.service.PersonService;
import java.util.List;

/**
 *
 * @author ricardo.camargo
 */
@Component
public class RetrieveAllPersonsUseCase {
    
    @Autowired
    private PersonService personService;
    
    public List<Person> execute() {
        return personService.retrieveAll();
    }
}