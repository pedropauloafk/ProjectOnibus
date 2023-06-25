package br.com.projet.onibus.rota;

import br.com.projet.onibus.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoRota(@NotNull Long id, int quantidade_passageiros) {

}
