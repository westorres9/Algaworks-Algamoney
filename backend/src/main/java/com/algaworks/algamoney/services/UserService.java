package com.algaworks.algamoney.services;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algamoney.DTO.RoleDTO;
import com.algaworks.algamoney.DTO.UserDTO;
import com.algaworks.algamoney.DTO.UserInsertDTO;
import com.algaworks.algamoney.entities.Role;
import com.algaworks.algamoney.entities.User;
import com.algaworks.algamoney.repositories.RoleRepository;
import com.algaworks.algamoney.repositories.UserRepository;
import com.algaworks.algamoney.services.exceptions.DatabaseException;
import com.algaworks.algamoney.services.exceptions.ResourceNotFoundException;
import com.algaworks.algamoney.services.exceptions.ValidationException;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found Exception");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<User> list = repository.findAll(pageable);
		return list.map(x -> new UserDTO(x));
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		try {
			User entity = repository.getOne(id);
			return new UserDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found ");
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found Exception");
		}
	}

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		try {
			User entity = new User();
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.getRoles().clear();
			for (RoleDTO roleDto : dto.getRoles()) {
				Role role = roleRepository.getOne(roleDto.getId());
				entity.getRoles().add(role);
			}
			entity.setPassword(passwordEncoder.encode(dto.getPassword()));
			entity = repository.save(entity);
			return new UserDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found ");
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found Exception");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		} catch (IllegalArgumentException e) {
			throw new DatabaseException("The given id must not be null!");
		} catch (ConstraintViolationException e) {
			throw new ValidationException("Validation error");
		}
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.getRoles().clear();
			for (RoleDTO roleDto : dto.getRoles()) {
				Role role = roleRepository.getOne(roleDto.getId());
				entity.getRoles().add(role);
			}
			entity = repository.save(entity);
			return new UserDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found Exception");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		} catch (IllegalArgumentException e) {
			throw new DatabaseException("The given id must not be null!");
		} catch (ConstraintViolationException e) {
			throw new ValidationException("Validation error");
		}
	}
}
