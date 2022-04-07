package com.algaworks.algamoney.services;

import com.algaworks.algamoney.DTO.PersonDTO;
import com.algaworks.algamoney.entities.Address;
import com.algaworks.algamoney.entities.Person;
import com.algaworks.algamoney.repository.PersonRepository;
import com.algaworks.algamoney.services.exceptions.DatabaseException;
import com.algaworks.algamoney.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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

    @Transactional
    public PersonDTO insert(PersonDTO dto){
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setActive(dto.isActive());
        entity.setAddress(dto.getAddress());
        entity = repository.save(entity);
        return new PersonDTO(entity);
    }

    @Transactional
    public PersonDTO update(Long id, PersonDTO dto){
        try {
            Person entity = repository.getById(id);
            entity.setName(dto.getName());
            entity.setActive(dto.isActive());
            entity.setAddress(dto.getAddress());
            entity = repository.save(entity);
            return new PersonDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }

    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource not found Exception");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }





}
