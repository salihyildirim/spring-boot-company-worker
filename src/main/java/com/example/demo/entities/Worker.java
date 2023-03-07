package com.example.demo.entities;

import java.util.Optional;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity // tabloya maplenecek orm
@Table(name="worker")
@Data //oto getter setter
public class Worker {
	    @Id
		private Long id;
	    
	    @ManyToOne
	    @JoinColumn(name = "company_id",nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE) // company silindiğinde workerlarını sil
		private
	    Company company;
	    
	    private String name;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) { 	
			this.company = company;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	    
	    

}
