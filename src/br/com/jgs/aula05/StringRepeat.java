package br.com.jgs.aula05;

public class StringRepeat {

    public static void main(String[] args) {
        String nome = "Gustavo ";

        //Versão do Java 11
        System.out.println("Repeate nome: " + nome.repeat(10));

        //Antes da versão do Java 11
        String nomeAux = "";
        for (int i=0; i<10; i++){
            nomeAux += nome;
        }

        System.out.println("For nome: " + nomeAux);

    }

}
