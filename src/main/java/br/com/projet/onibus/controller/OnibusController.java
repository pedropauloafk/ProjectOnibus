package br.com.projet.onibus.controller;

import br.com.projet.onibus.onibus.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("onibus")
public class OnibusController {


    @Autowired
    private IOnibusRepository iOnibusRepository;


    @PostMapping
    @Transactional
    public ResponseEntity insertOnibus(@RequestBody DadosCadastroOnibus dados, UriComponentsBuilder uriBuilder){
        var onibus =  new Onibus(dados);
        iOnibusRepository.save(onibus);
        var uri = uriBuilder.path("/onibus/{id}").buildAndExpand(onibus.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoOnibus(onibus));

    }

    @GetMapping
    public List<DadosListagemOnibus> gerAllOnibus(){
        return iOnibusRepository.findAll().stream().map(DadosListagemOnibus::new).toList();
    }
}
