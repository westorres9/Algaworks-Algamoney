package com.algaworks.algamoney.DTO;

import java.io.Serializable;

import com.algaworks.algamoney.entities.Category;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;

	public CategoryDTO() {

    }

	public CategoryDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public CategoryDTO(Long id, String name) {

        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
