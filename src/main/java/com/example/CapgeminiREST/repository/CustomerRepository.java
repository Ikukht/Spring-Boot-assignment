package com.example.CapgeminiREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CapgeminiREST.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
