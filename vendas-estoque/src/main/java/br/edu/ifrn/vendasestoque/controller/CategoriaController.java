package br.edu.ifrn.vendasestoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifrn.vendasestoque.domain.categoria.Categoria;
import br.edu.ifrn.vendasestoque.repository.CategoriaRepository;

@RestController
@RequestMapping("categorias")

public class CategoriaController {
    
    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public String teste(){
        return "Teste";
    }

    @PostMapping
    public ResponseEntity cadastrarCategoria(@RequestBody Categoria categoria, UriComponentsBuilder uriComponentsBuilder){
        Categoria categoriaLocal = repository.save(categoria);
        var uri = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoriaLocal.getId()).toUri();

        return ResponseEntity.created(uri).build();
        
    }
}
