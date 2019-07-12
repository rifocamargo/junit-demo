package br.com.lecom.junitdemo.controller;

import br.com.lecom.junitdemo.model.Person;
import br.com.lecom.junitdemo.usecase.RetrieveAllPersonsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lecom.junitdemo.usecase.SavePersonUseCase;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    @Autowired
    private SavePersonUseCase savePersonUseCase;
    
    @Autowired
    private RetrieveAllPersonsUseCase retrieveAllPersonsUseCase;

    @PostMapping
    public ResponseEntity<Person> save(final @RequestBody Person person) throws URISyntaxException {
        final Person result = savePersonUseCase.execute(person);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Person>> retrieveAll() throws URISyntaxException {
        final List<Person> persons = retrieveAllPersonsUseCase.execute();
        return ResponseEntity.ok(persons);
    }
}
