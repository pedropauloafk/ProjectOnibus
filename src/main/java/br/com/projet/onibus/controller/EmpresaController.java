package br.com.projet.onibus.controller;

import br.com.projet.onibus.empresa.*;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {

    @Autowired
    private IEmpresaRepository iEmpresaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity insertEmpresa(@RequestBody @Valid DadosCadastroEmpresa dados, UriComponentsBuilder uriBuilder){
        var empresa = new Empresa(dados);
        iEmpresaRepository.save(empresa);
        var uri = uriBuilder.path("/empresas/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEmpresa(empresa));
    }

    @GetMapping()
    public List<DadosListagemEmpresa> getAllEmpresa(){
        return iEmpresaRepository.findAll().stream().map(DadosListagemEmpresa::new).toList();
    }

    @PutMapping()
    @Transactional
    public ResponseEntity updateEmpresa(@RequestBody @Valid DadosAtualizacaoEmpresa dados){
        var empresa = iEmpresaRepository.getReferenceById(dados.id());
        empresa.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoEmpresa(empresa)) ;
    }

    @DeleteMapping("/{idEmpresa}")
    @Transactional
    public ResponseEntity deleteEmpresa(@PathVariable Long idEmpresa){
        var empresa = iEmpresaRepository.getReferenceById(idEmpresa);
        empresa.delete();
        return ResponseEntity.noContent().build();
    }
}
