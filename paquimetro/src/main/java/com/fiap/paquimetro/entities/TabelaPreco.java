package com.fiap.paquimetro.entities;

import com.fiap.paquimetro.dto.TabelaPrecoDto;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TabelaPreco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tempoMinimo;
    private Double valorHora;

    @OneToMany(mappedBy = "tabelaPreco")
    private List<Registro> registros = new ArrayList<>();

    public TabelaPreco(){
    }
    public TabelaPreco(Long tempoMinimo, Double valorHora) {
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

    public List<Registro> getRegistros() {
        return registros;
    }

    public void addRegistros(Registro registro) {
        this.registros.add(registro);
    }
}
