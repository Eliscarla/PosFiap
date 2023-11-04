package com.fiap.paquimetro.dto;

import com.fiap.paquimetro.entities.Condutor;
import jakarta.validation.constraints.NotBlank;

public class CondutorDto {
    private Long id;

    @NotBlank(message = "Campo requerido")
    private String CPF;

    @NotBlank(message = "Campo requerido")
    private String nome;

    @NotBlank(message = "Campo requerido")
    private String telefone;

    public CondutorDto() {
    }

    public CondutorDto(Condutor condutor) {
        this.id = condutor.getId();
        this.CPF = condutor.getCPF();
        this.nome = condutor.getNome();
        this.telefone = condutor.getTelefone();
    }

    public CondutorDto(String CPF, String nome, String telefone) {
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
    }

    public void setId(Long id) {
        this.id = id;
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
}
