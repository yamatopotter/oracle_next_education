package br.com.alura.aluramusic.model;

import jakarta.persistence.*;

@Entity
@Table(name="artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

}
