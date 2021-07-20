package br.com.jgs.aula02;

public class FuncaoAltaOrdem {

    public static void main(String[] args){
        Calculo SOMA = (a,b) -> a+b;
        Calculo SUBTRACAO = (a,b) -> a-b;
        Calculo DIVISAO = (a,b) -> a/b;
        Calculo MULT = (a,b) -> a*b;

        System.out.println("Soma: " + executarOperacao(SOMA, 10, 5));
        System.out.println("Subtração: " + executarOperacao(SUBTRACAO, 10, 5));
        System.out.println("Divisão: " + executarOperacao(DIVISAO, 10, 5));
        System.out.println("Multiplicação: " + executarOperacao(MULT, 10, 5));
    }

    public static int executarOperacao(Calculo calculo, int a, int b){
        return calculo.calcular(a,b);
    }

}

@FunctionalInterface
interface Calculo {
    public int calcular(int a, int b);
}
