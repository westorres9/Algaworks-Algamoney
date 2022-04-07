package com.algaworks.algamoney.resources;

import com.algaworks.algamoney.DTO.ReleasesDTO;
import com.algaworks.algamoney.services.ReleasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/releases")
public class ReleasesResource {

    @Autowired
    private ReleasesService service;

    @GetMapping
    public ResponseEntity<Page<ReleasesDTO>> findAll(Pageable pageable) {
        Page<ReleasesDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReleasesDTO> findById(@PathVariable Long id) {
        ReleasesDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ReleasesDTO> insert(@RequestBody ReleasesDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
