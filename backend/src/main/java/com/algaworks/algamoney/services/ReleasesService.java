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
import org.springframework.web.bind.annotation.RequestBody;

import com.algaworks.algamoney.DTO.ReleasesDTO;
import com.algaworks.algamoney.entities.Releases;
import com.algaworks.algamoney.repositories.ReleasesRepository;
import com.algaworks.algamoney.services.exceptions.DatabaseException;
import com.algaworks.algamoney.services.exceptions.ResourceNotFoundException;
import com.algaworks.algamoney.services.exceptions.ValidationException;

@Service
public class ReleasesService {

    @Autowired
    private ReleasesRepository repository;

    @Transactional(readOnly = true)
    public Page<ReleasesDTO> findAll(Pageable pageable){
        Page<Releases> list = repository.findAll(pageable);
        return list.map(x -> new ReleasesDTO(x));
    }

    @Transactional(readOnly = true)
    public ReleasesDTO findById(Long id) {
    	try {
        Releases entity = repository.getOne(id);
        return new ReleasesDTO(entity);
    	} catch (EntityNotFoundException e) {
    		throw new ResourceNotFoundException("Id not found ");
    	} catch (EmptyResultDataAccessException e) {
    		throw new ResourceNotFoundException("Resource not found Exception");
    	}
    }

    @Transactional
    public ReleasesDTO insert(@RequestBody ReleasesDTO dto){
        try {
            Releases entity = new Releases();
            entity.setDescription(dto.getDescription());
            entity.setDueDate(dto.getDueDate());
            entity.setPaymentDate(dto.getPaymentDate());
            entity.setValue(dto.getValue());
            entity.setNote(dto.getNote());
            entity.setType(dto.getType());
            entity.setCategory(dto.getCategory());
            entity.setPerson(dto.getPerson());
            entity = repository.save(entity);
            return new ReleasesDTO(entity);
        }
    	catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found ");
        } 
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource not found Exception");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    	 catch (IllegalArgumentException e) {
             throw new DatabaseException("The given id must not be null!");
         } catch (ConstraintViolationException e) {
 			throw new ValidationException("Validation error");
 		}
    }

    @Transactional
    public ReleasesDTO update(Long id, ReleasesDTO dto) {
        try {
            Releases entity = repository.getOne(id);
            entity.setDescription(dto.getDescription());
            entity.setDueDate(dto.getDueDate());
            entity.setPaymentDate(dto.getPaymentDate());
            entity.setValue(dto.getValue());
            entity.setNote(dto.getNote());
            entity.setType(dto.getType());
            entity.setCategory(dto.getCategory());
            entity.setPerson(dto.getPerson());
            entity = repository.save(entity);
            return new ReleasesDTO(entity);
        }
    	catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found ");
        } 
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource not found Exception");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    	 catch (IllegalArgumentException e) {
             throw new DatabaseException("The given id must not be null!");
         } catch (ConstraintViolationException e) {
 			throw new ValidationException("Validation error");
 		}
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource not found Exception");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
