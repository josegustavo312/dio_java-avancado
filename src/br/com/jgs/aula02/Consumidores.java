package br.com.jgs.aula02;

import java.util.function.Consumer;

public class Consumidores {

    public static void main(String[] args){
        Consumer<String> imprimirUmaFrase = System.out::println;
        //OU
        Consumer<String> imprimirUmaFrase2 = frase -> System.out.println(frase);

        imprimirUmaFrase.accept("Olá Mundo!");
    }

}
