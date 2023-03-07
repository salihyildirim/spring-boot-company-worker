package com.example.demo.requests;

import lombok.Data;

@Data
public class PostUpdateRequest {

	String name;
	Long company_id;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}
	
	
}
