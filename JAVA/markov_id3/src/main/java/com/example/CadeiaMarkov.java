package com.example;

import java.util.HashMap;
import java.util.Map;

public class CadeiaMarkov {
    private Map<String, Map<String, Double>> transicoes;

    public CadeiaMarkov() {
        transicoes = new HashMap<>();

        // Definindo as probabilidades de transição
        Map<String, Double> ensolarado = new HashMap<>();
        ensolarado.put("Ensolarado", 0.7);
        ensolarado.put("Nublado", 0.2);
        ensolarado.put("Chuvoso", 0.1);
        transicoes.put("Ensolarado", ensolarado);

        Map<String, Double> nublado = new HashMap<>();
        nublado.put("Ensolarado", 0.3);
        nublado.put("Nublado", 0.4);
        nublado.put("Chuvoso", 0.3);
        transicoes.put("Nublado", nublado);

        Map<String, Double> chuvoso = new HashMap<>();
        chuvoso.put("Ensolarado", 0.2);
        chuvoso.put("Nublado", 0.3);
        chuvoso.put("Chuvoso", 0.5);
        transicoes.put("Chuvoso", chuvoso);
    }

    // Método para pegar a probabilidade de transição de um estado para outro
    public double getProbabilidade(String estadoAtual, String proximoEstado) {
        return transicoes.get(estadoAtual).getOrDefault(proximoEstado, 0.0);
    }
}
