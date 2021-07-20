package br.com.jgs.aula01;

import java.util.HashMap;
import java.util.Map;

public class FatorialMemoization {

    static Map<Integer,Integer> MAPA_FATORIAL = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(">>Fatorial Memoization<<");
        long I = System.nanoTime(); // Tempo inicial em nanossegundos
        System.out.println("1º Fatorial de 30: " + fatorialComMemoization(30));
        long F = System.nanoTime(); // Tempo final em nanossegundos
        System.out.println("Tempo em nanossegundos do 1º Fatorial: " + (F-I));
        System.out.println("");

        I = System.nanoTime();
        System.out.println("2º Fatorial de 30: " + fatorialComMemoization(30));
        F = System.nanoTime();
        System.out.println("Tempo em nanossegundos do 2º Fatorial: " + (F-I));
    }

    public static Integer fatorialComMemoization(Integer value) {
        if (value == 1) {
            return value;
        } else {
            if (MAPA_FATORIAL.containsKey(value)) {
                return MAPA_FATORIAL.get(value);
            } else {
                Integer resultado = value * fatorialComMemoization(value - 1);
                MAPA_FATORIAL.put(value, resultado);
                return resultado;
            }
        }
    }

}
