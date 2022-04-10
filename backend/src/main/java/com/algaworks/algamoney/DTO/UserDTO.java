package com.algaworks.algamoney.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.algaworks.algamoney.entities.User;

public class UserDTO implements Serializable{
private static final long serialVersionUID = 1L;
		
	private String email;
	private Long id;
	private String name;
	
	Set<RoleDTO> roles = new HashSet<>();

	 
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email) {
	
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	 
	 

}
