package br.com.projet.onibus.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        String logradouro,

        String bairro,

        String cep,

        String uf,

        String numero,
        String complemento,

        String cidade
) {
}
