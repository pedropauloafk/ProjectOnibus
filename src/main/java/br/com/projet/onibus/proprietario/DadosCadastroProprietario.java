package br.com.projet.onibus.proprietario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProprietario(
        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        String cpf,

        String telefone,


        String endereco) {
}
