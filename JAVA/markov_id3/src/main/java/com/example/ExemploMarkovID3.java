package com.example;

import java.util.*;

public class ExemploMarkovID3 {

    public static void main(String[] args) {
        // Exemplo de dados observacionais (sequência de estados climáticos)
        List<Map<String, String>> exemplos = new ArrayList<>();
        exemplos.add(Map.of("DiaAnterior", "Ensolarado", "DiaAtual", "Nublado"));
        exemplos.add(Map.of("DiaAnterior", "Nublado", "DiaAtual", "Chuvoso"));
        exemplos.add(Map.of("DiaAnterior", "Chuvoso", "DiaAtual", "Ensolarado"));
        exemplos.add(Map.of("DiaAnterior", "Ensolarado", "DiaAtual", "Ensolarado"));

        List<String> classes = Arrays.asList("Nublado", "Chuvoso", "Ensolarado", "Ensolarado");

        // Definindo atributos e aplicando o algoritmo ID3
        List<String> atributos = Arrays.asList("DiaAnterior");

        No arvoreDecisao = ID3.construirArvore(atributos, exemplos, classes);
        System.out.println("Árvore de decisão criada com sucesso!");
    }
}
