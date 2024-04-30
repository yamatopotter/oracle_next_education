package br.com.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private Integer anoDeLancamento;
    private Boolean incluidoNoPlano;
    private double avaliacao;
    private int totalDeAvaliacoes;
    private Integer duracaoEmMinutos;

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime());
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(Boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void exibeFichaTecnica(){
        System.out.println(String.format("""
                Nome: %s
                Ano de lançamento: %d
                Média de avaliacao: %.2f
                Incluso no plano: %s
                Duração: %dmin
                """, nome, anoDeLancamento, pegaMedia(), incluidoNoPlano, duracaoEmMinutos));
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public void avalia(double nota){
        avaliacao += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return avaliacao / totalDeAvaliacoes;
    }
}
