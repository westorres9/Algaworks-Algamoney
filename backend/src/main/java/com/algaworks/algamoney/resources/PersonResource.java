package com.algaworks.algamoney.resources;

import com.algaworks.algamoney.DTO.PersonDTO;
import com.algaworks.algamoney.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<Page<PersonDTO>> findAll(Pageable pageable){
        Page<PersonDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }
}
