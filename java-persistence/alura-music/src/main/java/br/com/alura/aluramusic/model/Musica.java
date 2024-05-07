package br.com.alura.aluramusic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "musica")
public class Musica {
    private String nome;

}
