package com.fiap.paquimetro.entities;

import com.fiap.paquimetro.dto.TabelaPrecoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Time;

@Entity
public class TabelaPreco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time tempoMinimo;
    private Double valorHora;

    public TabelaPreco(){
    }
    public TabelaPreco(Time tempoMinimo, Double valorHora) {
        this.tempoMinimo = tempoMinimo;
        this.valorHora = valorHora;
    }

    public Long getId() {
        return id;
    }

    public Time getTempoMinimo() {
        return tempoMinimo;
    }

    public void setTempoMinimo(Time tempoMinimo) {
        this.tempoMinimo = tempoMinimo;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }
}
