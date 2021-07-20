package br.com.jgs.aula02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

    public static void main(String[] args) {
        String[] nomes = {"José", "Gustavo", "Silva", "Engenheiro", "Software"};
        Integer[] numeros = {1,2,3,4,5};

        imprimirNomesFiltrados(nomes);
        imprimirTodosNomes(nomes);
        imprimirDobro(numeros);
        pesquisarString();
    }

    public static void imprimirNomesFiltrados(String... nomes){
        System.out.println(">> Imprimir Nomes Filtrados <<");

        //Com for
        String nomesParaImprimir = "";
        for (int i=0; i<nomes.length; i++){
            if(nomes[i].equals("José")){
                nomesParaImprimir += "" + nomes[i];
            }
        }

        System.out.println("Nomes do for: " + nomesParaImprimir);

        //Com Stream
        String nomesParaImprimriDaStream = Stream.of(nomes)
                .filter(nome -> nome.equals("José"))
                .collect(Collectors.joining()); //String

        System.out.println("Nomes do stream: " + nomesParaImprimriDaStream);

        System.out.println("");

    }

    public static void imprimirTodosNomes(String... nomes){
        System.out.println(">> Imprimir Todos Nomes <<");

        for (String nome : nomes){
            System.out.println("Imprimindo pelo for: " + nome);
        }

        Stream.of(nomes)
                .forEach(nome -> System.out.println("Imprimindo pelo forEach: " + nome));

        System.out.println("");

    }

    public static void imprimirDobro(Integer... numeros){
        System.out.println(">> Imprimir Dobro <<");

        System.out.println("Com For");
        for (Integer numero : numeros){
            System.out.println(numero*2);
        }

        System.out.println("");

        System.out.println("Com forEach");
        Stream.of(numeros).map(numero -> numero*2)
                .forEach(System.out::println);

        System.out.println("");

    }

    public static void pesquisarString(){
        System.out.println(">> Pesquisar String <<");

        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor");
        profissoes.add("Testador");
        profissoes.add("Gerente de projeto");
        profissoes.add("Gerente de qualidade");

        profissoes.stream()
                .filter(profissao -> profissao.startsWith("Gerente"))
                .forEach(System.out::println);

        System.out.println("");
    }

}
