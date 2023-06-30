package br.com.projet.onibus.viewController;

import br.com.projet.onibus.empresa.DadosAtualizacaoEmpresa;
import br.com.projet.onibus.empresa.DadosCadastroEmpresa;
import br.com.projet.onibus.empresa.DadosDetalhamentoEmpresa;
import br.com.projet.onibus.empresa.Empresa;
import br.com.projet.onibus.empresa.IEmpresaRepository;
import br.com.projet.onibus.proprietario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("viewempresas")

public class ViewControllerEmpresa {

    @Autowired
    private IEmpresaRepository repository;

    @GetMapping
    public String carregaListagemEmpresas(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "viewempresas/listagem.html";
    }

    @GetMapping("/formulario_cadastro")
    public String carregaPaginaEmpresa(Long id, Model model) {

        if (id != null) {

            var empresa = repository.getReferenceById(id);
            model.addAttribute("empresa", empresa);

        }
        return "viewempresas/formulario_cadastro";

    }

    @PostMapping
    @Transactional
    public String cadastrarEmpresa(DadosCadastroEmpresa dados) {

        var empresas = new Empresa(dados);
        repository.save(empresas);
        return "redirect:/viewempresas";
    }

    @PutMapping
    @Transactional
    public String alteraEmpresas(DadosAtualizacaoEmpresa dados) {
        var empresa = repository.getReferenceById(dados.id());
        empresa.atualizarInformacoes(dados);
        return "redirect:/viewempresas";

    }

    @DeleteMapping
    @Transactional
    public String removerEmpresas(Long id) {

        repository.deleteById(id);
        return "redirect:/viewempresas";

    }

}
