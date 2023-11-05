package com.fiap.paquimetro.entities;

import com.fiap.paquimetro.dto.CondutorDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Condutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CPF;
    private String nome;
    private String telefone;

    @OneToMany(mappedBy = "condutor")
    private List<Registro> registros = new ArrayList<>();


    @OneToMany(mappedBy = "condutor")
    private List<Veiculo> veiculos = new ArrayList<>();

    public Condutor() {
    }

    public Condutor(String CPF, String nome, String telefone) {
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public List<Registro> getRegistros() {
        return registros;
    }

    public void addRegistro(Registro registro) {
        this.registros.add(registro);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void addVeiculos(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }
}
