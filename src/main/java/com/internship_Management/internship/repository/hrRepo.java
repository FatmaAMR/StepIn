package com.internship_Management.internship.repository;

import org.springframework.stereotype.Repository;

import model.Hr;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface hrRepo extends JpaRepository<Hr, Integer> {
    
}
