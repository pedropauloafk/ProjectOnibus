package br.com.projet.onibus.rota;

public record DadosDetalhamentoRota(Long id, String linha, Origem origem, Origem destino, int quantidade_passageiros) {

    public DadosDetalhamentoRota(Rota rota){
        this(rota.getId(), rota.getLinha(), rota.getOrigem(), rota.getDestino(), rota.getQuantidade_passageiros());
    }
}
