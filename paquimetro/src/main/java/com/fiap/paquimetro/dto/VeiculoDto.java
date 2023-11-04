package com.fiap.paquimetro.dto;

import com.fiap.paquimetro.entities.Veiculo;
import jakarta.validation.constraints.NotBlank;

public class VeiculoDto {
    private Long id;

    @NotBlank(message = "Campo requerido")
    private String placa;
    @NotBlank(message = "Campo requerido")
    private String modelo;
    @NotBlank(message = "Campo requerido")
    private String ano;

    public VeiculoDto(){
    };

    public VeiculoDto(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
    }

    public VeiculoDto(String placa, String modelo, String ano) {
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

    public void setId(Long id) {
        this.id = id;
    }
}
