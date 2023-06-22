package br.com.projet.onibus.controller;


import br.com.projet.onibus.proprietario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proprietarios")
public class ProprietarioController {

    @Autowired
    private IProprietarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarEmpresa(@RequestBody CadastrarProprietario dados){
        repository.save(new Proprietario(dados));

    }

    @GetMapping
     public List<DadosListagemProprietario> listar (){
        return repository.findAll().stream().map(DadosListagemProprietario::new).toList();
    }




    @PutMapping
    @Transactional
    public void atualizarDados(@RequestBody @Valid DadosAtualizaProprietario dados) {

        var proprietario = repository.getReferenceById(dados.id());
        proprietario.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){

        var proprietario = repository.getReferenceById(id);
        proprietario.excluir();

    }


}


