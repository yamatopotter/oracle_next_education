package org.example.proxy;

import org.example.builder.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        PessoaService pessoaService = new PessoaService(new NovoPessoaRepositoryProxy());

        Pessoa pessoa = new Pessoa.PessoaBuilder()
                .sobrenome("Barreto")
                .dataNascimento("01/01/1993")
                .nome("Matheus")
                .apelido("Potter")
                .documento("063543216")
                .build();

        pessoaService.save(pessoa);
        Pessoa pessoaRetornada = pessoaService.findById(1L);
        System.out.println(pessoaRetornada);
    }
}
