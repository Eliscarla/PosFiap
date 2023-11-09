package com.fiap.paquimetro.entities;

import com.fiap.paquimetro.dto.RegistroDto;
import jakarta.persistence.*;
import java.time.Duration;
import java.time.Instant;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant entrada;
    private Instant saida;
    private Double total;
    private Long permanecia;

    @ManyToOne
    @JoinColumn(name = "tabela_preco_id")
    private TabelaPreco tabelaPreco;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "condutor_id")
    private Condutor condutor;
    public Registro() {

    }

    public Registro(Instant entrada, Instant saida) {
        this.entrada = entrada;
        this.saida = saida;
    }

    public Registro(RegistroDto registroDto) {
        this.entrada = registroDto.getEntrada();
        this.saida = registroDto.getSaida();
    }

    public Long getId() {
        return id;
    }

    public Instant getEntrada() {
        return entrada;
    }

    public void setEtrada(Instant entrada) {
        this.entrada = entrada;
    }

    public Instant getSaida() {
        return saida;
    }

    public void setSaida(Instant saida) {
        this.saida = saida;
    }

    public void calcularPermanencia() {
        Duration d = Duration.between(this.entrada, this.saida);
        this.permanecia = d.toHours();
        this.total = d.toHours() * tabelaPreco.getValorHora();
    }

    public Instant getEntntrada() {
        return entrada;
    }

    public void setEntntrada(Instant entntrada) {
        this.entrada = entntrada;
    }

    public TabelaPreco getTabelaPreco() {
        return tabelaPreco;
    }

    public void setTabelaPreco(TabelaPreco tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }
}
