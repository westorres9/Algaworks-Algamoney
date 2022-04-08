package com.algaworks.algamoney.services;

import com.algaworks.algamoney.DTO.ReleasesDTO;
import com.algaworks.algamoney.entities.Person;
import com.algaworks.algamoney.entities.Releases;
import com.algaworks.algamoney.repository.PersonRepository;
import com.algaworks.algamoney.repository.ReleasesRepository;
import com.algaworks.algamoney.services.exceptions.DatabaseException;
import com.algaworks.algamoney.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ReleasesService {

    @Autowired
    private ReleasesRepository repository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional(readOnly = true)
    public Page<ReleasesDTO> findAll(Pageable pageable){
        Page<Releases> list = repository.findAll(pageable);
        return list.map(x -> new ReleasesDTO(x));
    }

    @Transactional(readOnly = true)
    public ReleasesDTO findById(Long id) {
        Releases entity = repository.getOne(id);
        return new ReleasesDTO(entity);
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
        } catch (EmptyResultDataAccessException e) {
        throw new ResourceNotFoundException("Resource not found Exception");
    } catch (DataIntegrityViolationException e) {
        throw new DatabaseException("Integrity violation");
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
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
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
