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

import com.algaworks.algamoney.DTO.CategoryDTO;
import com.algaworks.algamoney.entities.Category;
import com.algaworks.algamoney.repositories.CategoryRepository;
import com.algaworks.algamoney.services.exceptions.DatabaseException;
import com.algaworks.algamoney.services.exceptions.FieldNotValidException;
import com.algaworks.algamoney.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable) {
        Page<Category> list = repository.findAll(pageable);
        return list.map(x -> new CategoryDTO(x));
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id){
    	try {
        Category entity = repository.getOne(id);
        return new CategoryDTO(entity);
    	} catch (EntityNotFoundException e) {
    		throw new ResourceNotFoundException("Id not found ");
    	} catch (EmptyResultDataAccessException e) {
    		throw new ResourceNotFoundException("Resource not found Exception");
    	}
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try{
            Category entity = repository.getOne(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);
        
    } catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException("Id not found ");
	} catch (EmptyResultDataAccessException e) {
		throw new ResourceNotFoundException("Resource not found Exception");
	} catch (DataIntegrityViolationException e) {
		throw new DatabaseException("Integrity violation");
	} catch (IllegalArgumentException e) {
		throw new DatabaseException("The given id must not be null!");
	} catch (ConstraintViolationException e) {
		throw new FieldNotValidException(
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
			throw new FieldNotValidException(
					"the fields entered are not valid, please check the fields entered and try again");
		}
    }

}
