package org.example.builder;

public class testePessoa {
    public static void main(String[] args) {
//        Pessoa pessoa1 = new Pessoa("Matheus"
//                , "Bareto"
//                , "3213213"
//                , "teste@teste.com"
//                , "potter"
//                , "13/02/1995");
//
//        System.out.println(pessoa1);

        Pessoa pessoa2 = new Pessoa.PessoaBuilder()
                .nome("Matheus")
                .sobrenome("Pereira")
                .documento("3213213")
                .email("teste@teste.com")
                .apelido("potter")
                .dataNascimento("13/02/1995")
                .build();

        System.out.println(pessoa2);

        Animal animal = Animal.builder()
                .nome("Rex")
                .raca("Pastor Alemão")
                .dono("Anderson")
                .build();

        System.out.println(animal);
    }
}
