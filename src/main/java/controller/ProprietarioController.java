package controller;

import br.com.projet.onibus.proprietario.DadosCadastroProprietario;
import br.com.projet.onibus.proprietario.IProprietarioRepository;
import br.com.projet.onibus.proprietario.Proprietario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import br.com.projet.onibus.proprietario.DadosListagemProprietario;
import proprietario.DadosAtualizaProprietario;
@RestController
@RequestMapping("/proprietarios")

public class ProprietarioController {



    @Autowired
    private IProprietarioRepository repository;


    @PostMapping
    @Transactional

    public void cadastrar(@RequestBody @Valid DadosCadastroProprietario dados){
        repository.save(new Proprietario(dados));
    }



    @GetMapping
     public Page<DadosListagemProprietario> listar (@PageableDefault(size= 10, page = 0, sort = {"nome"}) Pageable paginacao ){
        return repository.findAll(paginacao).map(DadosListagemProprietario::new);
    }

    public void atualizarDados(@RequestBody @Valid DadosAtualizaProprietario dados) {

        var proprietario = repository.getReferenceById(dados.id());
        proprietario.atualizarInformacoes(dados);

    }

}
