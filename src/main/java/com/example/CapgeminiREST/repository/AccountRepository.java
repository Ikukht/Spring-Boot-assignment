package com.example.CapgeminiREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CapgeminiREST.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
