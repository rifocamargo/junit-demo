package br.com.lecom.junitdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lecom.junitdemo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}