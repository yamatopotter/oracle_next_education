package br.com.alura.aluramusic.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private TipoArtista tipoArtista;

    public Artista() {
    }

    public Artista(String nome, String tipoArtista) {
        this.nome = nome;
        this.tipoArtista = TipoArtista.fromString(tipoArtista.toUpperCase());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusica(Musica musica){
        musica.setArtista(this);
        this.musicas.add(musica);
    }

    public void setMusicas(List<Musica> musicas) {
        musicas.forEach(e->e.setArtista(this));
        this.musicas = musicas;
    }

    public TipoArtista getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(TipoArtista tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    @Override
    public String toString() {
        return "Artista: " +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", musicas=" + musicas +
                ", tipoArtista=" + tipoArtista;
    }
}
