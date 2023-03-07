package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.SecondLevelCacheLogger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Worker;
import com.example.demo.requests.PostCreateRequest;
import com.example.demo.requests.PostUpdateRequest;
import com.example.demo.services.WorkerService;

@RestController
@RequestMapping("/workers") 
public class WorkerController {

	private WorkerService workerService;

	public WorkerController(WorkerService workerService) {
		this.workerService = workerService;
	}
	@GetMapping
	public List<Worker> getAllWorkers(@RequestParam Optional<Long> companyId){
		
		return workerService.getAllWorkers(companyId);
	}
	
	@GetMapping("/{workerId}")
	public Worker getOneWorker(@PathVariable Long workerId) {
		return workerService.getOneWorker(workerId);
	}
	
	@PostMapping
	public Worker createOneWorker(@RequestBody PostCreateRequest postRequest) {
		return workerService.createOneWorker(postRequest);
	}
	
	@PutMapping("/{workerId}")
	public Worker updateWorker(@PathVariable Long workerId,@RequestBody PostUpdateRequest updateRequest) {
		return workerService.updateWorker(workerId,updateRequest);
	}
	
	@DeleteMapping("/{workerId}")
	public void deleteWorker(@PathVariable Long workerId) {
		workerService.deleteWorker(workerId);
	}
	
}









