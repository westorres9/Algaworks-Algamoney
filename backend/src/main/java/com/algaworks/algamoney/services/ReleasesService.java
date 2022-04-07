package com.algaworks.algamoney.services;

import com.algaworks.algamoney.DTO.ReleasesDTO;
import com.algaworks.algamoney.entities.Releases;
import com.algaworks.algamoney.repository.ReleasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

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
        Releases entity = repository.getById(id);
        return new ReleasesDTO(entity);
    }

    @Transactional
    public ReleasesDTO insert(@RequestBody ReleasesDTO dto){
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

}
