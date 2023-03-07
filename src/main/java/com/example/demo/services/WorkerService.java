package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Company;
import com.example.demo.entities.Worker;
import com.example.demo.repo.WorkerRepos;
import com.example.demo.requests.PostCreateRequest;
import com.example.demo.requests.PostUpdateRequest;

@Service
public class WorkerService {

private WorkerRepos workerRepos;
private CompanyService companyService;

public WorkerService(WorkerRepos workerRepos,CompanyService companyService) {
	this.workerRepos = workerRepos;
	this.companyService=companyService;
}

public List<Worker> getAllWorkers(Optional<Long> companyId) {
	if(companyId.isPresent()) {
		return workerRepos.findByCompanyId(companyId.get());
	}
	return workerRepos.findAll();
}

public Worker getOneWorker(Long workerId) {
	return workerRepos.findById(workerId).orElse(null);
}

public Worker createOneWorker(PostCreateRequest postRequest) {

	Company company=companyService.getOneWorker(postRequest.getCompanyId());
	if(company==null) 
		return null;
	else {
	Worker toSave= new Worker();
	toSave.setId(postRequest.getId());
	toSave.setName(postRequest.getName());
	toSave.setCompany(company); 
	return workerRepos.save(toSave);
	}
}

public Worker updateWorker(Long workerId, PostUpdateRequest updateRequest) {	 
	 
	Optional<Worker> worker= workerRepos.findById(workerId);	
	if(worker.isPresent()) {
		Worker newWorker=worker.get();
		newWorker.setName(updateRequest.getName());
		workerRepos.save(newWorker);
		return newWorker;
	}
	
	return null;
}

public void deleteWorker(Long workerId) {
	workerRepos.deleteById(workerId);
}
	



}
