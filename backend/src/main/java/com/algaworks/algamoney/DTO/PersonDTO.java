package com.algaworks.algamoney.DTO;

import com.algaworks.algamoney.entities.Address;
import com.algaworks.algamoney.entities.Person;

import java.io.Serializable;

public class PersonDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private boolean active;
    private Address address;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
