package org.example.builder;

//Vantagens do builder: Alterar ordem de inserção dos parametros de criação,
//facilidade na visualização das informações

public class PessoaBuilder {
    private String nome;
    private String sobrenome;
    private String documento;
    private String email;
    private String apelido;
    private String dataNascimento;

    public PessoaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder sobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public PessoaBuilder documento(String documento) {
        this.documento = documento;
        return this;
    }

    public PessoaBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PessoaBuilder apelido(String apelido) {
        this.apelido = apelido;
        return this;
    }

    public PessoaBuilder dataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

//    public Pessoa criaPessoa(){
//        return new Pessoa(nome, sobrenome, documento, email, apelido, dataNascimento);
//    }
}
