package br.com.alura.aluramusic.main;

import br.com.alura.aluramusic.model.Artista;
import br.com.alura.aluramusic.model.Musica;
import br.com.alura.aluramusic.repository.ArtistaRepository;
import br.com.alura.aluramusic.repository.MusicaRepository;
import br.com.alura.aluramusic.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepository artistaRepository;
    private MusicaRepository musicaRepository;

    public Principal(ArtistaRepository artistaRepository, MusicaRepository musicaRepository){
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
    }

    public void exibeMenu(){
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    1 - Cadastrar artista
                    2 - Cadastrar música
                    3 - Listar artistas
                    4 - Listar músicas
                    5 - Listar músicas de um artista
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    addArtista();
                    break;
                case 2:
                    addMusicaToArtist();
                    break;
                case 3:
                    listArtistas();
                    break;
                case 4:
                    listMusicas();
                    break;
                case 5:
                    listMusicasDeArtista();
                    break;
                case 6:
                    searchSobreArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }

    private void searchSobreArtista() {
        System.out.println("Digite o nome do artista");
        var nomeArtista = leitura.nextLine();

        ConsultaChatGPT.obterInformacaoArtista(nomeArtista);
    }

    private void listMusicasDeArtista() {
        System.out.println("Digite o artista que deseja listar as músicas");
        var nomeArtista = leitura.nextLine();

        Optional<Artista> artista = artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);
        List<Musica> listMusicas = artista.get().getMusicas();

        System.out.println("Aqui estão as músicas do "+artista.get().getNome()+": ");
        listMusicas.forEach(System.out::println);
    }

    private void listMusicas() {
        System.out.println("Músicas registradas no sistema: ");
        List<Musica> listMusicas = musicaRepository.findAll();

        listMusicas.forEach(System.out::println);
    }

    private void listArtistas() {
        System.out.println("Artistas registrados na base de dados:");
        List<Artista> artistas = artistaRepository.findAll();
        artistas.forEach(System.out::println);
    }

    private void addMusicaToArtist() {
        System.out.println("Digite o artista da música");
        var nomeArtista = leitura.nextLine();

        Optional<Artista> artista = artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);

        if(artista.isPresent()){
            System.out.println("Digite o nome da música");
            var nomeMusica = leitura.nextLine();
            System.out.println("Digite o nome do álbum:");
            var nomeAlbum = leitura.nextLine();
            Musica musica = new Musica(nomeMusica, nomeAlbum);
            Artista newArtista = artista.get();
            newArtista.setMusica(musica);

            artistaRepository.save(newArtista);
            System.out.println("Deseja inserir outra música? S/N");
            var opcao = leitura.nextLine();

            if(opcao.equalsIgnoreCase("s")){
                addMusicaToArtist();
            }

        }else{
            System.out.println("Ops, não encontramos o artista na base de dados. Deseja cadastrar o artista? S/N");
            addArtista(nomeArtista);
            addMusicaToArtist();
        }
    }

    private void addArtista() {
        System.out.println("Digite o nome do artista:");
        var nomeArtista = leitura.nextLine();
        System.out.println("Digite o tipo de partipação do artista (solo/dupla/banda):");
        var tipoArtista = leitura.nextLine();

        Artista artista = new Artista(nomeArtista, tipoArtista);
        artistaRepository.save(artista);

        System.out.println("Deseja adicionar mais um artista? S/N");
        var opcao = leitura.nextLine();

        if(opcao.equalsIgnoreCase("s")){
            addArtista();
        }
    }

    private void addArtista(String nomeArtista){
        System.out.println("Digite o tipo de partipação do artista (solo/dupla/banda):");
        var tipoArtista = leitura.nextLine();

        Artista artista = new Artista(nomeArtista, tipoArtista);
        artistaRepository.save(artista);

        System.out.println("Deseja adicionar mais um artista? S/N");
        var opcao = leitura.nextLine();
    }
}
