package br.com.projet.onibus.proprietario;

import br.com.projet.onibus.endereco.DadosEndereco;

public record DadosCadastroProprietario(String nome, String cpf, String email, String telefone, DadosEndereco endereco) {
}
