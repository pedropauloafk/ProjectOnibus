package br.com.projet.onibus.proprietario;

public record DadosDetalhamentoProprietario(Long id, String nome,String cpf, String email, String telefone) {

    public DadosDetalhamentoProprietario(Proprietario proprietario){
        this(proprietario.getId(), proprietario.getNome(), proprietario.getCpf(), proprietario.getEmail(), proprietario.getTelefone());
    }
}
