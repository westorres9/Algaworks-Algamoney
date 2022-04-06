package com.algaworks.algamoney.resources;

import com.algaworks.algamoney.DTO.CategoryDTO;
import com.algaworks.algamoney.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAllPaged(Pageable pageable){
        Page<CategoryDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }
}
