package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; //orm
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.Data; 


@Entity 
@Table(name="company")
@Data
public class Company {
	
	@Id
	private Long id;
    private String name;
    
    
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

	
    
}
