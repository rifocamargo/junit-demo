package br.com.lecom.junitdemo.service;

import br.com.lecom.junitdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.lecom.junitdemo.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author ricardo.camargo
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(final Person person) {
        return personRepository.save(person);
    }

    public Person retrieve(long id) {
        return personRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public List<Person> retrieveAll() {
        return personRepository.findAll();
    }

    public Person update(final long id, final Person person) {
        final Person personById = personRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        BeanUtils.copyProperties(person, personById, "id");
        return personRepository.save(personById);
    }

    public void delete(final long id) {
        personRepository.deleteById(id);
    }
}
