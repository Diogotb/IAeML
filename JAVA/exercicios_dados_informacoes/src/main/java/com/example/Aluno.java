package com.example;

class Aluno {
    private String nome;
    private double media;

    public Aluno(String nome, double media) {
        this.nome = nome;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public double getMedia() {
        return media;
    }
}
