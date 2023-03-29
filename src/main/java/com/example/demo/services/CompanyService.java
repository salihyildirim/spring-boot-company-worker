package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Company;
import com.example.demo.repo.CompanyRepos;

@Service
public class CompanyService {

	private CompanyRepos companyRepos;

	
	
	public CompanyService(CompanyRepos companyRepos) {
		this.companyRepos = companyRepos;
	}


	public List<Company> getAllCompanies() {
		return companyRepos.findAll();
	}


	public Company saveOneCompany(Company newCompany) {
		return companyRepos.save(newCompany);
	}


	public Company getOneCompany(Long companyId) {	
		return companyRepos.findById(companyId).orElse(null);
		
	}


	public Company updateOneCompany(Long companyId, Company newCompany) {
		Optional<Company> nowCompany=companyRepos.findById(companyId);
		if(nowCompany.isPresent()) {
			Company foundCompany=nowCompany.get();
			foundCompany.setName(newCompany.getName());
			companyRepos.save(foundCompany);
			return foundCompany;
		}
		else return null;
	}


	public void deleteCompanyById(Long companyId) {
	companyRepos.deleteById(companyId);
		
	}
	
	
	
	
	
	
	
	
	
}
