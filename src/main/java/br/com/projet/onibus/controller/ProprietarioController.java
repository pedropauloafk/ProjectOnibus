package br.com.projet.onibus.controller;


import br.com.projet.onibus.proprietario.DadosCadastroProprietario;
import br.com.projet.onibus.proprietario.IProprietarioRepository;
import br.com.projet.onibus.proprietario.Proprietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proprietarios")
public class ProprietarioController {

    @Autowired
    private IProprietarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarEmpresa(@RequestBody DadosCadastroProprietario dados){
        repository.save(new Proprietario(dados));

    }
}
