package com.internship_Management.internship.repository;

import model.Company;


import org.springframework.data.jpa.repository.JpaRepository;
public interface companyRepo extends JpaRepository<Company, Integer>  {

    
    
}
