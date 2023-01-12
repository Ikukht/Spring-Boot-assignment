package com.example.CapgeminiREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CapgeminiREST.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
