package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import com.example.demo.entities.Worker; 

public interface WorkerRepos extends JpaRepository<Worker, Long> {

	List<Worker> findByCompanyId(Long companyId);

	

}
