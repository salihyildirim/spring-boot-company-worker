package com.example.demo.responses;

import com.example.demo.entities.Worker;

public class WorkerResponse {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public WorkerResponse(Worker worker) { // constructor mapping
		this.name=worker.getName();
	}
	
}
