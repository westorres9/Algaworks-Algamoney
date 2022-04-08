package com.algaworks.algamoney.services;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algamoney.DTO.PersonDTO;
import com.algaworks.algamoney.entities.Person;
import com.algaworks.algamoney.repositories.PersonRepository;
import com.algaworks.algamoney.services.exceptions.DatabaseException;
import com.algaworks.algamoney.services.exceptions.ResourceNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@Transactional(readOnly = true)
	public Page<PersonDTO> findAll(Pageable pageable) {
		Page<Person> list = repository.findAll(pageable);
		return list.map(x -> new PersonDTO(x));
	}

	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) {
		try {
			Person entity = repository.getOne(id);
			return new PersonDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found ");
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found Exception");
		}
	}

	@Transactional
	public PersonDTO insert(PersonDTO dto) {
		Person entity = new Person();
		entity.setName(dto.getName());
		entity.setActive(dto.isActive());
		entity.setAddress(dto.getAddress());
		entity = repository.save(entity);
		return new PersonDTO(entity);
	}

	@Transactional
	public PersonDTO update(Long id, PersonDTO dto) {
		try {
			Person entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setActive(dto.isActive());
			entity.setAddress(dto.getAddress());
			entity = repository.save(entity);
			return new PersonDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found ");
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found Exception");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		} catch (IllegalArgumentException e) {
			throw new DatabaseException("The given id must not be null!");
		} catch (ConstraintViolationException e) {
			throw new DatabaseException(
					"the fields entered are not valid, please check the fields entered and try again");
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found ");
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found Exception");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		} catch (IllegalArgumentException e) {
			throw new DatabaseException("The given id must not be null!");
		} catch (ConstraintViolationException e) {
			throw new DatabaseException(
					"the fields entered are not valid, please check the fields entered and try again");
		}
	}

}
