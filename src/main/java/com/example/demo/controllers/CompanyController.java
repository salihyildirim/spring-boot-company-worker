package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Company;
import com.example.demo.repo.CompanyRepos;
import com.example.demo.services.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	private CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		this.companyService=companyService;
	}
	
	@GetMapping
	public List<Company> getAllCompany(){
		return companyService.getAllCompanies();
		
	}
	
	@PostMapping
	public Company createCompany(@RequestBody Company newCompany) {
		return companyService.saveOneCompany(newCompany);
	}
	
	@GetMapping("/{companyId}")
	public Company getOneCompany(@PathVariable Long companyId) {
		return companyService.getOneCompany(companyId);
	}
	
	@PutMapping("/{companyId}")
	public Company updateCompany(@PathVariable Long companyId, @RequestBody Company newCompany) {
		return companyService.updateOneCompany(companyId,newCompany);
	}
	
	@DeleteMapping("/{companyId}")
	public void deleteOneCompany(@PathVariable Long companyId) {
		companyService.deleteCompanyById(companyId);
	}
	

}
