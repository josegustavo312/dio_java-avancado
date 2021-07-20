package br.com.jgs.aula03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PararelStreamExemplo {

    public static void main(String[] args){
        List<String> nomes = Arrays.asList("José","Gustavo","Silva","Mota");
        nomes.parallelStream().forEach(System.out::println);

        long inicio = System.currentTimeMillis();
        IntStream.range(1,100000).forEach(num -> fatorial(num)); //Serial
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Serial: " + (fim-inicio));

        inicio = System.currentTimeMillis();
        IntStream.range(1,100000).parallel().forEach(num -> fatorial(num)); //Parallel
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Parallel: " + (fim-inicio));
    }

    public static long fatorial(long num){
        long fat = 1;

        for(long i=2; i<=num; i++){
            fat*=i;
        }

        return fat;
    }

}
