package com.fiap.paquimetro.entities;

import com.fiap.paquimetro.dto.VeiculoDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "veiculo")
    private List<Registro> registros = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "condutor_id")
    private Condutor condutor;

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

    public List<Registro> getRegistros() {
        return registros;
    }

    public void addRegistros(Registro registro) {
        this.registros.add(registro);
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }
}
