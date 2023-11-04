package com.fiap.paquimetro.entities;

import com.fiap.paquimetro.dto.RegistroDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;


@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant entntrada;
    private Instant saida;
    private Double total;
    private String permanecia;

    public Registro() {

    }

    public Registro(Instant entntrada, Instant saida, String permanecia) {
        this.entntrada = entntrada;
        this.saida = saida;
        this.permanecia = permanecia;
    }

    public Registro(RegistroDto registroDto) {
        this.entntrada = registroDto.getEntntrada();
        this.saida = registroDto.getSaida();
        this.permanecia = registroDto.getPermanecia();
    }


    public Long getId() {
        return id;
    }

    public Instant getEntrada() {
        return entntrada;
    }

    public void setEtrada(Instant entrada) {
        this.entntrada = entrada;
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

    public String getPermanecia() {
        return calcularPermanencia();
    }

    private String calcularPermanencia() {
        Duration d = Duration.between(this.entntrada, this.saida);
        String result = String.format("%02d:%02d", d.toHoursPart(), d.toMinutesPart());
        return result;

    }
}
