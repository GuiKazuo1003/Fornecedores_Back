package com.fornecedor.fornecedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fornecedor.fornecedor.entities.fornecedor;

public interface FornecedorRepository extends JpaRepository <fornecedor, Integer> {
    
}
