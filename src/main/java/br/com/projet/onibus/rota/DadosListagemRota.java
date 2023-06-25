package br.com.projet.onibus.rota;

public record DadosListagemRota(Long id, String linha, Origem origem, Origem destino) {

    public DadosListagemRota(Rota rota) {
        this(rota.getId(), rota.getLinha(), rota.getOrigem(), rota.getDestino());
    }
}