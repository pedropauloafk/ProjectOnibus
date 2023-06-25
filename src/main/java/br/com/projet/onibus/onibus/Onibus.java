package br.com.projet.onibus.onibus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="onibus")
@Table(name="onibus")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Onibus {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String renavam;
    private String placa;
    private String fabricante;
    private String ano;
    private int capacidade;

    private boolean viagem;


    public Onibus(DadosCadastroOnibus dados) {
        this.modelo = dados.modelo();;
        this.renavam = dados.renavam();
        this.placa = dados.placa();
        this.fabricante = dados.fabricante();
        this.ano = dados.ano();
        this.capacidade = dados.capacidade();
    }
}
