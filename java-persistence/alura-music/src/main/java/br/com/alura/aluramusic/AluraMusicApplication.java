package br.com.alura.aluramusic;

import br.com.alura.aluramusic.main.Principal;
import br.com.alura.aluramusic.model.Musica;
import br.com.alura.aluramusic.repository.ArtistaRepository;
import br.com.alura.aluramusic.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraMusicApplication implements CommandLineRunner {
	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private MusicaRepository musicaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AluraMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistaRepository, musicaRepository);
		principal.exibeMenu();
	}

}
