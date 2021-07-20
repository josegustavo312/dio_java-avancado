package br.com.jgs.aula04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class Inferencia {

    public static void main(String[] args) throws IOException {
        connectAndPrintURLJavaOracle(); // Imprimi o HTML da página
        printarNomeCompleto("José", "Gustavo");
        printarSoma(5,4,3,2,1);
    }

    private static void connectAndPrintURLJavaOracle() throws IOException {
        var url = new URL("https://docs.oracle.com/javase/10/language/");
        var urlConnection = url.openConnection();
        var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">",">\n"));
    }

    public static void printarNomeCompleto(String nome, String sobrenome){
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println("Nome: " + nomeCompleto);
    }

    public static void printarSoma(int... numeros){
        int soma;
        if(numeros.length > 0){
            soma = 0;
            for (var numero : numeros){
                soma+=numero;
            }
            System.out.println("Soma: " + soma);
        }
    }

    /* A variável do tipo var não pode ser utilizada:
        - Em nível de classe;
        - Como parâmetro;
        - Em variáveis locais não inicializadas. */

}
