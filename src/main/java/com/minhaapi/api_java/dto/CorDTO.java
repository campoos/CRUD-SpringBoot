package com.minhaapi.api_java.dto;

public class CorDTO {

    private String nome;

    public CorDTO() {}

    public CorDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
