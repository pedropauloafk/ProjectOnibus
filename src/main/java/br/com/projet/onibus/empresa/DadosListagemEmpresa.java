package br.com.projet.onibus.empresa;

public record DadosListagemEmpresa(Long id, String cnpj, String nome_fantasia) {
    public DadosListagemEmpresa(Empresa empresa){
        this(empresa.getId(), empresa.getCnpj(), empresa.getNome_fantasia());
    }
}
