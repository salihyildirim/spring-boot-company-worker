package com.example.demo.repo;

import org.springframework.data.jpa.repository.*;

import com.example.demo.entities.Company;

public interface CompanyRepos extends JpaRepository<Company, Long> {

}
