package br.com.projet.onibus.controller;

import br.com.projet.onibus.rota.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("rotas")
public class RotaController {

    @Autowired
    private IRotaRepository iRotaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity insertRota(@RequestBody DadosCadastroRota dados, UriComponentsBuilder uriBuilder){
        var rota = new Rota(dados);
        iRotaRepository.save(rota);
        var uri = uriBuilder.path("/rotas/{id}").buildAndExpand(rota.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoRota(rota));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemRota>> getAllRotas(@PageableDefault(size = 10, sort = {"linha"})Pageable paginacao){
        var page = iRotaRepository.findAllByViagemTrue(paginacao).map(DadosListagemRota::new);
        return ResponseEntity.ok(page);
    }


    @PutMapping
    public ResponseEntity updateRota(@RequestBody DadosAtualizacaoRota dados){
        var rota = iRotaRepository.getReferenceById(dados.id());
        rota.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoRota(rota));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteRota(@PathVariable Long id){
        var  rota = iRotaRepository.getReferenceById(id);
        rota.delete();
        return ResponseEntity.noContent().build();
    }
}
