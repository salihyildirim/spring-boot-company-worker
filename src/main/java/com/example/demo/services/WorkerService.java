package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Company;
import com.example.demo.entities.Worker;
import com.example.demo.repo.WorkerRepos;
import com.example.demo.requests.PostCreateRequest;
import com.example.demo.requests.PostUpdateRequest;
import com.example.demo.responses.WorkerResponse;

@Service
public class WorkerService {

private WorkerRepos workerRepos;
private CompanyService companyService;

public WorkerService(WorkerRepos workerRepos,CompanyService companyService) {
	this.workerRepos = workerRepos;
	this.companyService=companyService;
}

public List<WorkerResponse> getAllWorkers(Optional<Long> companyId) {
	
	 List<Worker> workersList;
	 
		if(companyId.isPresent()) {
			workersList= workerRepos.findByCompanyId(companyId.get());
		}
		else {
			workersList=workerRepos.findAll();
		}
		return workersList.stream().map(p -> new WorkerResponse(p)).collect(Collectors.toList()); // *********
}

public Worker getOneWorker(Long workerId) {
	return workerRepos.findById(workerId).orElse(null);
}

public Worker createOneWorker(PostCreateRequest postRequest) throws Exception {

	Company company=companyService.getOneCompany(postRequest.getCompanyId());
	
	if((workerRepos.findById(postRequest.getId()).isPresent()))
	{
		throw new Exception("Eklemek istediğiniz Id ile zaten bir calisan mevcut");
	}
	
	else if(company==null) 
		{throw new Exception("Kaydedilmek istenen companyId bulunamadi !");}
	
	
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
	Company company= companyService.getOneCompany(updateRequest.getCompany_id()); 
	if(worker.isPresent()) {
		if(company==null)
			return null;
		else {
		Worker newWorker=worker.get();
		newWorker.setName(updateRequest.getName());
		newWorker.setCompany(company); 
		workerRepos.save(newWorker);
		return newWorker;
		}
	}
	
	return null;
}

public void deleteWorker(Long workerId) throws Exception {
	
	if(workerRepos.findById(workerId).isPresent())
	workerRepos.deleteById(workerId);
	else
	throw new Exception("silinecek calisan id'si bulunamadi");
}
	



}
