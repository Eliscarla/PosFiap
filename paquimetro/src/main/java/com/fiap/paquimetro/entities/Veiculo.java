package com.fiap.paquimetro.entities;

import com.fiap.paquimetro.dto.VeiculoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private String ano;

    public Veiculo(){
    };

    public Veiculo(VeiculoDto veiculoDto) {
        this.placa = veiculoDto.getPlaca();
        this.modelo = veiculoDto.getModelo();
        this.ano = veiculoDto.getAno();
    }

    public Veiculo(String placa, String modelo, String ano) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
