package br.com.projet.onibus.rota;

public record DadosCadastroRota(
        String linha,
        String cidade,

        String caixa,

        String valor_passagem,

        Origem origem,

        Origem destino,

        int quantidade_passageiros) {
}
