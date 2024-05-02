package br.com.apolloit.screenmatch.principal;

import br.com.apolloit.screenmatch.model.DadosEpisodio;
import br.com.apolloit.screenmatch.model.DadosSerie;
import br.com.apolloit.screenmatch.model.DadosTemporada;
import br.com.apolloit.screenmatch.model.Episodio;
import br.com.apolloit.screenmatch.service.ConsumoApi;
import br.com.apolloit.screenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final static String BASE_URL = "https://omdbapi.com/?t=";
    private final static String API_KEY = "&apiKey=3c315f41";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para buscar: ");
        var nomeSerie = leitura.nextLine();
        var url = BASE_URL + nomeSerie.replace(" ", "+") + API_KEY;
        var json = consumoApi.obterDados(url);

        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            json = consumoApi.obterDados(BASE_URL + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }

        temporadas.forEach(System.out::println);

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(temporada -> temporada.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("Top 5 Episódios");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(e -> new Episodio(t.temporada(), e))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("A partir de que ano você deseja ver os episódios");
        var ano = leitura.nextInt();
        leitura.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> {
                    System.out.println(
                            "Temporada: "+e.getTemporada()+
                                    "Episódio: "+e.getTitulo()+
                                    "Data de Lançamento"+e.getDataLancamento().format(formatter)
                    );
                });
    }
}
