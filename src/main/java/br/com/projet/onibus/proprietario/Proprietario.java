package br.com.projet.onibus.proprietario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import proprietario.DadosAtualizaProprietario;

@Entity (name = "proprietarios")
@Table (name = "proprietarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = "id")
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

    public Proprietario(DadosCadastroProprietario dados) {

        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = dados.endereco();
    }


    public void atualizarInformacoes(DadosAtualizaProprietario dados) {

        if ( dados.nome()  != null) {

            this.nome = dados.nome();

        }

        if (dados.cpf() != null) {

            this.cpf = dados.cpf();

        }

        if ( dados.telefone() != null ){

            this.telefone = dados.telefone();

        }


    }
}
