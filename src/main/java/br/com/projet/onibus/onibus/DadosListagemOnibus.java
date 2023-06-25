package br.com.projet.onibus.onibus;
public record DadosListagemOnibus(Long id, String modelo, String fabricante, String ano, int capacidade) {

    public DadosListagemOnibus(Onibus onibus){
        this(onibus.getId(), onibus.getModelo(), onibus.getFabricante(), onibus.getAno(), onibus.getCapacidade());
    }

}
