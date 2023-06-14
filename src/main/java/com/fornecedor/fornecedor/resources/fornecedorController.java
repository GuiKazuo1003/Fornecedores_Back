package com.fornecedor.fornecedor.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fornecedor.fornecedor.entities.fornecedor;
import com.fornecedor.fornecedor.services.FornecedorService;

@RequestMapping("fornecedor")
@RestController
@CrossOrigin
public class fornecedorController {

    @Autowired
    private FornecedorService fornecedorService;


    @GetMapping("{id}")
    public ResponseEntity<fornecedor> getFornecedor(@PathVariable int id) {
        fornecedor Fornecedor = fornecedorService.getFornecedorByID(id);
        return ResponseEntity.ok().body(Fornecedor);
    }
    @GetMapping

    public ResponseEntity <List<fornecedor>> getClients() {
        
        List<fornecedor> clients = fornecedorService.getFornecedor();
        return ResponseEntity.ok().body(clients);
    }
    @DeleteMapping("{id}")
    public ResponseEntity <Void> deleteFornecedor(@PathVariable int id) {
        fornecedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> editClient(@PathVariable int id ,@RequestBody fornecedor Fornecedor) {
        fornecedorService.uptade(id, Fornecedor);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<fornecedor> saveClient(@RequestBody fornecedor Fornecedor) {
        fornecedor newClient = fornecedorService.save(Fornecedor);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(Fornecedor.getId())
        .toUri();

        return ResponseEntity.created(location).body(newClient);
    }
}
