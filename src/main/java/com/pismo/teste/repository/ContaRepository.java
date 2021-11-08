package com.pismo.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pismo.teste.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
	
}
