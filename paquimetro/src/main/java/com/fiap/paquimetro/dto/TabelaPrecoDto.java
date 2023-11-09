package com.fiap.paquimetro.dto;

import com.fiap.paquimetro.entities.TabelaPreco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.sql.Time;

public class TabelaPrecoDto {
    private Long id;

    private Long tempoMinimo;

    @Positive(message = "Valor inválido")
    private Double valorHora;

    public TabelaPrecoDto(){
    }

    public TabelaPrecoDto(TabelaPreco tabelaPreco) {
        this.tempoMinimo = tabelaPreco.getTempoMinimo();
        this.valorHora = tabelaPreco.getValorHora();
    }
    public TabelaPrecoDto(Long tempoMinimo, Double valorHora) {
        this.tempoMinimo = tempoMinimo;
        this.valorHora = valorHora;
    }

    public Long getId() {
        return id;
    }

    public Long getTempoMinimo() {
        return tempoMinimo;
    }

    public void setTempoMinimo(Long tempoMinimo) {
        this.tempoMinimo = tempoMinimo;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
