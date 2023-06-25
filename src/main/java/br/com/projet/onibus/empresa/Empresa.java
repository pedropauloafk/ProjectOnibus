package br.com.projet.onibus.empresa;


import br.com.projet.onibus.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="empresas")
@Table(name = "empresas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Empresa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_fantasia;
    private String email;
    private String cnpj;
    private String telefone;

    @Embedded
    private Endereco endereco;

    //Depois fazer com a migration
    private boolean ativo;

    public Empresa(DadosCadastroEmpresa dados){
        this.nome_fantasia = dados.nome_fantasia();;
        this.email = dados.email();
        this.cnpj = dados.cnpj();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoEmpresa dados) {
        //String nome_fantasia, String telefone, String cnpj
        this.nome_fantasia = dados.nome_fantasia() != null ? dados.nome_fantasia() : getNome_fantasia();
        this.telefone = dados.telefone() != null ? dados.telefone() : getTelefone();
        this.cnpj = dados.cnpj() != null ? dados.cnpj() : getCnpj();
    }


    public void delete() {
        this.ativo = false;
    }
}
