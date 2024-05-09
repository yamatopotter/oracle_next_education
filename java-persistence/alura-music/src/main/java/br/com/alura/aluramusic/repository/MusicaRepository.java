package br.com.alura.aluramusic.repository;

import br.com.alura.aluramusic.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
