package br.com.projet.onibus.viewController;

import br.com.projet.onibus.empresa.DadosDetalhamentoEmpresa;
import br.com.projet.onibus.proprietario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("viewproprietarios")
public class ViewControllerProprietario {

    @Autowired
    private IProprietarioRepository repository;

    @GetMapping("/formulario_cadastro")
    public String carregaPaginaFormulario(Long id, Model model) {

        if (id != null) {

            var proprietario = repository.getReferenceById(id);
            model.addAttribute("proprietario", proprietario);

        }
        return "viewproprietarios/formulario_cadastro";

    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "viewproprietarios/listagem.html";
    }

    @PostMapping
    @Transactional
    public String cadastrarProprietario(DadosCadastrarProprietario dados) {

        var proprietario = new Proprietario(dados);

        repository.save(proprietario);

        return "redirect:/viewproprietarios";
    }

    @PutMapping
    @Transactional
    public String alterarProprietario(DadosAtualizaProprietario dados) {
        var proprietario = repository.getReferenceById(dados.id());
        proprietario.atualizarInformacoes(dados);
        return "redirect:/viewproprietarios";

    }

    @DeleteMapping
    @Transactional
    public String removerProprietario(Long id){

        repository.deleteById(id);
        return "redirect:/viewproprietarios";

    }
}
