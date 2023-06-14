package com.fornecedor.fornecedor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fornecedor.fornecedor.entities.fornecedor;
import com.fornecedor.fornecedor.repositories.FornecedorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public fornecedor getFornecedorByID(int id){
        return fornecedorRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Fornecedor não encontrado")
        );
    }
    public List<fornecedor> getFornecedor() {
        return fornecedorRepository.findAll();
    }

    public void deleteById(int id) {
        fornecedor Fornecedor = getFornecedorByID(id);
        fornecedorRepository.delete(Fornecedor);
    }
   
    public fornecedor save(fornecedor Fornecedor) {
        return fornecedorRepository.save(Fornecedor);
    }

    public void uptade(int id, fornecedor Fornecedor) {
        getFornecedorByID(id);
        fornecedorRepository.save(Fornecedor);
    }

    
}
