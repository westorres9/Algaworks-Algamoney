package com.algaworks.algamoney.DTO;

import com.algaworks.algamoney.entities.Role;

public class RoleDTO {
	
	private Long id;
	private String Authority;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return Authority;
	}

	public void setAuthority(String authority) {
		Authority = authority;
	}
	
	
	
	
	
	

}
