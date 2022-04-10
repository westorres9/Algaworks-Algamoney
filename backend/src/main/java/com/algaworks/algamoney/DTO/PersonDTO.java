package com.algaworks.algamoney.DTO;

import java.io.Serializable;

import com.algaworks.algamoney.entities.Address;
import com.algaworks.algamoney.entities.Person;

public class PersonDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean active;
    private Address address;
    private Long id;
    private String name;

    public PersonDTO(){
    }

    public PersonDTO(Long id, String name, boolean active, Address address) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.address = address;
    }

    public PersonDTO(Person entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.active = entity.isActive();
        this.address = entity.getAddress();
    }

    public Address getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
