package com.algaworks.algamoney.DTO;

import com.algaworks.algamoney.entities.Role;

public class RoleDTO {
	
	private String Authority;
	private Long id;
	
	public RoleDTO() {
	}

	public RoleDTO(Long id, String authority) {
		this.id = id;
		Authority = authority;
	}
	
	public RoleDTO(Role role) {
		this.id = role.getId();
		Authority = role.getAuthority();
	}

	public String getAuthority() {
		return Authority;
	}

	public Long getId() {
		return id;
	}

	public void setAuthority(String authority) {
		Authority = authority;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	

}
