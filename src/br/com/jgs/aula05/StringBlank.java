package br.com.jgs.aula05;

public class StringBlank {

    public static void main(String[] args) {
        String espaco = "";

        //Antes da versão do Java 11
        System.out.println(espaco == null || espaco.length() == 0 || espaco.chars().allMatch(c -> c == ' '));

        //Versão do Java 11
        System.out.println(espaco.isBlank());

    }

}
