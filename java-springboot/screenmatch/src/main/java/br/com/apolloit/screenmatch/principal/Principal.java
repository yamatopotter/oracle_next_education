package br.com.apolloit.screenmatch.principal;

import br.com.apolloit.screenmatch.model.DadosEpisodio;
import br.com.apolloit.screenmatch.model.DadosSerie;
import br.com.apolloit.screenmatch.model.DadosTemporada;
import br.com.apolloit.screenmatch.service.ConsumoApi;
import br.com.apolloit.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

//        for(int i=0; i< dadosSerie.totalTemporadas(); i++){
//            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//
//            for(int j=0; j<episodiosTemporada.size(); j++){
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }

        temporadas.forEach(t -> t.episodios().forEach( e -> System.out.println(e.titulo())));
    }
}
