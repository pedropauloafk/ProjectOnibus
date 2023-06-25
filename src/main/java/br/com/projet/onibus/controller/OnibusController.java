package br.com.projet.onibus.controller;

import br.com.projet.onibus.onibus.DadosCadastroOnibus;
import br.com.projet.onibus.onibus.DadosListagemOnibus;
import br.com.projet.onibus.onibus.IOnibusRepository;
import br.com.projet.onibus.onibus.Onibus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("onibus")
public class OnibusController {


    @Autowired
    private IOnibusRepository iOnibusRepository;


    @PostMapping
    @Transactional
    public void insertOnibus(@RequestBody DadosCadastroOnibus dados){
        iOnibusRepository.save(new Onibus(dados));

    }

    @GetMapping
    public List<DadosListagemOnibus> gerAllOnibus(){
        return iOnibusRepository.findAll().stream().map(DadosListagemOnibus::new).toList();
    }
}
