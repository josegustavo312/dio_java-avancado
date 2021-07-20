package br.com.jgs.aula05;

import java.util.Collection;
import java.util.Set;

public class CollectionExemplo {

    public static void main(String[] args) {
        Collection<String> nomes = Set.of("Jose", "Gustavo", "Silva"); // Set.of não permite elemento duplicado
        System.out.println(nomes);
    }

}
