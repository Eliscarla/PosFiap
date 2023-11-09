package com.fiap.paquimetro.dto;

import com.fiap.paquimetro.entities.Registro;


import java.time.Instant;

public class RegistroDto {
    private Long id;


    private Instant entrada;

    private Instant saida;
    private Double total;
    private Long permanecia;

    public RegistroDto(Registro registro) {
        this.entrada = registro.getEntrada();
        this.saida = registro.getSaida();
    }

    public RegistroDto() {
    }

    public Long getId() {
        return id;
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

    public Instant getEntrada() {
        return entrada;
    }

    public void setEntrada(Instant entrada) {
        this.entrada = entrada;
    }

}
