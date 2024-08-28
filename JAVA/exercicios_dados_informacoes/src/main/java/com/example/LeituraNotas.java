package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraNotas {

    public void app() {
        // Arquivos de entrada e saída
        String inputFile = "alunos_notas.txt";
        String outputFile = "resultados.txt";

        // Lista para armazenar os alunos e suas médias
        List<Aluno> alunos = new ArrayList<>();
        double somaTotalNotas = 0; // Soma total das médias de todos os alunos
        int totalAlunos = 0; // Contador de alunos

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String linha;
            // Lê o arquivo linha por linha
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                // Verifica se a linha tem o formato correto
                if (partes.length < 2) {
                    System.out.println("Linha com formato incorreto: " + linha);
                    continue; // Pula para a próxima linha
                }

                String nome = partes[0]; // Nome do aluno
                double somaNotas = 0; // Soma das notas do aluno
                int numeroNotas = 0; // Contador de notas

                try {
                    // Converte as notas de String para double e soma
                    for (int i = 1; i < partes.length; i++) {
                        somaNotas += Double.parseDouble(partes[i]);
                        numeroNotas++;
                    }
                } catch (NumberFormatException e) {
                    // Tratamento de erro caso alguma nota não seja um número válido
                    System.out.println("Erro ao converter nota em número na linha: " + linha);
                    continue; // Pula para a próxima linha
                }

                double media = somaNotas / numeroNotas; // Calcula a média do aluno
                alunos.add(new Aluno(nome, media)); // Adiciona o aluno à lista

                somaTotalNotas += media; // Soma a média do aluno à soma total
                totalAlunos++; // Incrementa o contador de alunos
            }
        } catch (IOException e) {
            e.printStackTrace(); // Tratamento de exceções para leitura de arquivo
        }

        // Verifica se há alunos na lista para processar
        if (!alunos.isEmpty()) {
            Aluno alunoMaiorNota = alunos.get(0); // Inicializa com o primeiro aluno
            Aluno alunoMenorNota = alunos.get(0); // Inicializa com o primeiro aluno

            // Percorre a lista de alunos para encontrar o de maior e menor média
            for (Aluno aluno : alunos) {
                if (aluno.getMedia() > alunoMaiorNota.getMedia()) {
                    alunoMaiorNota = aluno; // Atualiza o aluno com maior média
                }
                if (aluno.getMedia() < alunoMenorNota.getMedia()) {
                    alunoMenorNota = aluno; // Atualiza o aluno com menor média
                }
            }

            double mediaGeralTurma = somaTotalNotas / totalAlunos; // Calcula a média geral da turma

            // Exibe os resultados no console
            System.out.println("");
            System.out.println("Aluno com a maior nota: " + alunoMaiorNota.getNome() + " - Média: " + alunoMaiorNota.getMedia());
            System.out.println("Aluno com a menor nota: " + alunoMenorNota.getNome() + " - Média: " + alunoMenorNota.getMedia());
            System.out.println("Média geral da turma: " + mediaGeralTurma);

            // Escreve os resultados em um arquivo de saída
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                bw.write("Aluno com a maior nota: " + alunoMaiorNota.getNome() + " - Média: " + alunoMaiorNota.getMedia());
                bw.newLine();
                bw.write("Aluno com a menor nota: " + alunoMenorNota.getNome() + " - Média: " + alunoMenorNota.getMedia());
                bw.newLine();
                bw.write("Média geral da turma: " + mediaGeralTurma);
            } catch (IOException e) {
                e.printStackTrace(); // Tratamento de exceções para escrita de arquivo
            }
        } else {
            // Mensagem de erro caso nenhum dado válido tenha sido encontrado
            System.out.println("Nenhum dado válido foi encontrado no arquivo.");
        }
    }
}
