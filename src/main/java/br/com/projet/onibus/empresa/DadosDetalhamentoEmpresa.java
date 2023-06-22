package br.com.projet.onibus.empresa;

public record DadosDetalhamentoEmpresa(Long id, String nome_fantasia, String cpnj) {

    public DadosDetalhamentoEmpresa(Empresa empresa){
        this(empresa.getId(), empresa.getNome_fantasia(), empresa.getCnpj());

    }
}
