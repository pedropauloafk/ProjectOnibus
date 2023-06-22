package br.com.projet.onibus.proprietario;

public record DadosListagemProprietario(Long id, String nome,  String cpf ){

    public DadosListagemProprietario (Proprietario proprietario) {
        this(proprietario.getId(), proprietario.getNome(), proprietario.getCpf());


    }

}




