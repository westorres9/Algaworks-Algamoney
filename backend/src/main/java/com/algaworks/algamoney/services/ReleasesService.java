package com.algaworks.algamoney.services;

import com.algaworks.algamoney.DTO.ReleasesDTO;
import com.algaworks.algamoney.entities.Releases;
import com.algaworks.algamoney.repository.ReleasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
