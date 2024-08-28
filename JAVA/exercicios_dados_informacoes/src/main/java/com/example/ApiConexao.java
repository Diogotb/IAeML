package com.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConexao {

    public void app() {
        String apiUrl = "http://localhost:3000/usuarios"; // Substitua pela URL real da API
        try {
            // Conecta-se à API
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            // Verifica o código de resposta da conexão
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // código 200 OK
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();

                // Lê a resposta da API linha por linha
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                // Fecha a conexão de leitura
                in.close();

                // Converte a resposta para JSONArray
                JSONArray usuariosArray = new JSONArray(content.toString());

                int totalUsuarios = usuariosArray.length();
                int somaIdades = 0;

                // Exibe as informações dos usuários e soma as idades
                for (int i = 0; i < usuariosArray.length(); i++) {
                    JSONObject usuario = usuariosArray.getJSONObject(i);
                    String nome = usuario.getString("nome");
                    int idade = usuario.getInt("idade");
                    String cidade = usuario.getString("cidade");

                    System.out.println("Nome: " + nome + ", Idade: " + idade + ", Cidade: " + cidade);
                    somaIdades += idade;
                }

                // Calcula a média de idade
                double mediaIdade = (double) somaIdades / totalUsuarios;

                System.out.println("Número total de usuários: " + totalUsuarios);
                System.out.println("Média de idade dos usuários: " + mediaIdade);

                // Filtragem por cidade específica
                String cidadeFiltro = "São Paulo"; // Altere conforme necessário
                System.out.println("\nUsuários que moram em " + cidadeFiltro + ":");
                for (int i = 0; i < usuariosArray.length(); i++) {
                    JSONObject usuario = usuariosArray.getJSONObject(i);
                    if (usuario.getString("cidade").equalsIgnoreCase(cidadeFiltro)) {
                        System.out.println("Nome: " + usuario.getString("nome") + ", Idade: " + usuario.getInt("idade"));
                    }
                }

            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
