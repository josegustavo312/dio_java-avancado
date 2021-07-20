package br.com.jgs.aula01;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

public class ParadigmaFuncional {

    public static void main(String[] args) {
        paradigma();
        composicaoDeFuncoes();
        funcoesPuras();
        imultabilidade();
        funcaoComLambda();
        fatorialRecursivo();
        fatorialTailCall();
    }

    public static void paradigma(){
        // Paradigma Imperativo
        int valorI = 10;
        int resultado = valorI * 3;
        System.out.println(">> Paradigma Imperativo <<");
        System.out.println("O resultado é: " + resultado);
        System.out.println("");

        // Paradigma Funcional
        UnaryOperator<Integer> calcularValorVezes3 = valor -> valor*3;
        System.out.println(">> Paradigma Funcional <<");
        System.out.println("O resultado é: " + calcularValorVezes3.apply(10));
        System.out.println("");
    }

    public static void composicaoDeFuncoes(){
        System.out.println(">>Composição de Funções - Multiplicar números pares<<");

        int[] valores = {1,2,3,4};
        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 2)
                .forEach(numero -> System.out.println(numero));

        System.out.println("");
    }

    public static void funcoesPuras(){
        System.out.println(">>Funções Puras - Comparar valores<<");

        BiPredicate<Integer,Integer> verificarSeEMaior =
                (parametro, valorComparacao) -> parametro > valorComparacao;

        System.out.println(verificarSeEMaior.test(13, 12));
        System.out.println(verificarSeEMaior.test(13, 12));

        System.out.println("");
    }

    public static void imultabilidade(){
        System.out.println(">>Imultabilidade - Retornar o dobro<<");

        int valor = 20;
        UnaryOperator<Integer> retornarDobro = v -> v * 2;
        System.out.println(retornarDobro.apply(valor)); // Retorna o dobro do valor
        System.out.println(valor); // Valor não será alterado

        System.out.println("");
    }

    public static void funcaoComLambda(){
        System.out.println(">>Função com Lambda - Prefixo<<");

        // Lambda com mais de uma lógica
        Funcao colocarPrefixoSenhorNaString = valor -> {
            String valorComprefixo = "Sr. " + valor;
            String valorComPrefixoEPontoFinal = valorComprefixo+".";
            return valorComPrefixoEPontoFinal;
        };

        System.out.println(colocarPrefixoSenhorNaString.gerar("José"));

        System.out.println("");
    }

    public static void fatorialRecursivo(){
        System.out.println(">> Fatorial Recursivo <<");
        System.out.println("Fatorial de 5: " + fatorial(5));
        System.out.println("");
    }

    public static int fatorial (int value) {
        if(value == 1) {
            return value;
        }else{
            return value * fatorial((value -1));
        }
    }

    public static void fatorialTailCall(){
        System.out.println(">> Fatorial Tail Call <<");
        System.out.println("Fatorial de 5: " + fatorialA(5));
        System.out.println("");
    }

    public static double fatorialA(double valor) {
        return fatorialComTailCall(valor, 1);
    }

    public static double fatorialComTailCall(double valor, double numero){
        if (valor == 0){
            return numero;
        }
        return fatorialComTailCall(valor-1, numero*valor);
    }

}
