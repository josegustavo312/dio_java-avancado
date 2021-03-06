package br.com.jgs.aula02;

import java.util.function.Function;

public class Funcoes {

    public static void main(String[] args){
        Function<String, String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        Function<String, Integer> converterStringParaInteiroECalcularODobro = string -> Integer.valueOf(string) * 2;

        System.out.println(retornarNomeAoContrario.apply("josé"));
        System.out.println(converterStringParaInteiroECalcularODobro.apply("20"));

    }

}
