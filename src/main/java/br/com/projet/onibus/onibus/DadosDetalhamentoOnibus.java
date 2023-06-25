package br.com.projet.onibus.onibus;

public record DadosDetalhamentoOnibus(Long id, String modelo, String fabricante, String ano, int capacidade) {

    public DadosDetalhamentoOnibus(Onibus onibus){
        this(onibus.getId(), onibus.getModelo(), onibus.getFabricante(), onibus.getAno(), onibus.getCapacidade());
    }
}
