package com.algaworks.algamoney.repositories;

import com.algaworks.algamoney.entities.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
