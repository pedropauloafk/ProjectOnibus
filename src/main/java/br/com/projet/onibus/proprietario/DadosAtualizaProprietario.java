package br.com.projet.onibus.proprietario;

import br.com.projet.onibus.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaProprietario(

        @NotNull
        Long id,

        String nome,

        String cpf,

        String telefone
        ) {
}
