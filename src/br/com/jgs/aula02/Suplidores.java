package br.com.jgs.aula02;

import java.util.function.Supplier;

public class Suplidores {

    public static void main(String[] args){
        Supplier<Pessoa> instaciaPessoa = () -> new Pessoa();
        System.out.println(instaciaPessoa.get());

        //OU
        Supplier<Pessoa> instaciaPessoa2 = Pessoa::new;
        System.out.println(instaciaPessoa2.get());

    }

}

class Pessoa{
    private String nome;
    private Integer idade;

    public Pessoa(){
        nome = "José";
        idade = 30;
    }

    public String toString() {
        return String.format("Nome: %s, Idade: %d", nome, idade);
    }

}
