package br.com.projet.onibus.controller;


import br.com.projet.onibus.empresa.DadosDetalhamentoEmpresa;
import br.com.projet.onibus.proprietario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("proprietarios")
public class ProprietarioController {

    @Autowired
    private IProprietarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity insertProprietario(@RequestBody DadosCadastrarProprietario dados, UriComponentsBuilder uriBuilder){
        var proprietario = new Proprietario(dados);
        repository.save(proprietario);
        var uri = uriBuilder.path("/proprietarios/{id}").buildAndExpand(proprietario.getId()).toUri();
        repository.save(new Proprietario(dados));
        return ResponseEntity.created(uri).body(new DadosDetalhamentoProprietario(proprietario));


    }

    @GetMapping
     public List<DadosListagemProprietario> getAllProprietarios (){
        return repository.findAll().stream().map(DadosListagemProprietario::new).toList();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProprietario(@RequestBody @Valid DadosAtualizaProprietario dados) {
        var proprietario = repository.getReferenceById(dados.id());
        proprietario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoProprietario(proprietario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProprietario(@PathVariable Long id){
        var proprietario = repository.getReferenceById(id);
        proprietario.excluir();
        return ResponseEntity.noContent().build();

    }
}


