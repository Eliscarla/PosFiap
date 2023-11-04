package com.fiap.paquimetro.dto;

import com.fiap.paquimetro.entities.Registro;


import java.time.Instant;

public class RegistroDto {
    private Long id;


    private Instant entrada;

    private Instant saida;
    private Double total;
    private String permanecia;

    public RegistroDto(Registro registro) {
        this.entrada = registro.getEntrada();
        this.saida = registro.getSaida();
    }

    public RegistroDto() {
    }

    public Long getId() {
        return id;
    }

    public Instant getEntntrada() {
        return entrada;
    }

    public void setEntntrada(Instant entntrada) {
        this.entrada = entntrada;
    }

    public Instant getSaida() {
        return saida;
    }

    public void setSaida(Instant saida) {
        this.saida = saida;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPermanecia() {
        return permanecia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getEntrada() {
        return entrada;
    }

    public void setEntrada(Instant entrada) {
        this.entrada = entrada;
    }

}
