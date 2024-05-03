package com.matheus.fipe.principal;

import com.matheus.fipe.model.DadosMarcas;
import com.matheus.fipe.service.ConsumoApi;
import com.matheus.fipe.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final static String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
        Boolean loopEscolha = true;
        String url = "";
        String opcao = "";

        System.out.println("Bem vindo ao consultor de preços da tabela FIPE");
        System.out.println("Digite sua opção para consulta: ");
        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhões");

        while (loopEscolha){
            opcao = leitura.nextLine().toLowerCase();

            if(opcao.contains("car")){
                loopEscolha = false;
                url = BASE_URL + "carros/marcas";
            }
            else if(opcao.contains("mot")){
                loopEscolha = false;
                url = BASE_URL + "motos/marcas";
            } else if (opcao.contains("cam")) {
                loopEscolha = false;
                url = BASE_URL + "caminhoes/marcas";
            }
            else{
                System.out.println("Opção inválida, digite o tipo de veículo que deseja pesquisar.");
            }
        }

        var json = consumoApi.obterDados(url);

        List<DadosMarcas> marcas = converteDados.obterLista(json, DadosMarcas.class);
        marcas.stream()
                .forEach(System.out::println);

    }
}
