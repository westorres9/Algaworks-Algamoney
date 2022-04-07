package com.algaworks.algamoney.services;

import com.algaworks.algamoney.DTO.PersonDTO;
import com.algaworks.algamoney.entities.Person;
import com.algaworks.algamoney.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Transactional(readOnly = true)
    public Page<PersonDTO> findAll(Pageable pageable){
        Page<Person> list = repository.findAll(pageable);
        return list.map(x -> new PersonDTO(x));
    }

    @Transactional(readOnly = true)
    public PersonDTO findById(Long id) {
        Person entity = repository.getById(id);
        return new PersonDTO(entity);
    }

   



}
