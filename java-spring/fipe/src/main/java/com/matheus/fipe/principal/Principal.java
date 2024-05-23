package com.matheus.fipe.principal;

import com.matheus.fipe.model.DadosApi;
import com.matheus.fipe.model.DadosDetalhesModelo;
import com.matheus.fipe.model.DadosModelos;
import com.matheus.fipe.service.ConsumoApi;
import com.matheus.fipe.service.ConverteDados;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final static String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        Boolean loopEscolha = true;
        String url = "";
        String opcao = "";
        Integer codigo = 0;

        System.out.println("Bem vindo ao consultor de preços da tabela FIPE");
        System.out.println("Digite sua opção para consulta: ");
        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhões");

        while (loopEscolha) {
            opcao = leitura.nextLine().toLowerCase();

            if (opcao.contains("car")) {
                loopEscolha = false;
                url = BASE_URL + "carros/marcas";
            } else if (opcao.contains("mot")) {
                loopEscolha = false;
                url = BASE_URL + "motos/marcas";
            } else if (opcao.contains("cam")) {
                loopEscolha = false;
                url = BASE_URL + "caminhoes/marcas";
            } else {
                System.out.println("Opção inválida, digite o tipo de veículo que deseja pesquisar.");
            }
        }

//      Obtenção de todos as marcas do veiculo selecionados
        var json = consumoApi.obterDados(url);

        List<DadosApi> marcas = converteDados.obterLista(json, DadosApi.class);
        marcas.stream()
                .forEach(marca -> System.out.println("Código: " + marca.codigo() + " | Marca: " + marca.nome()));

        System.out.println("Escolha a marca desejada pelo código: ");
        codigo = leitura.nextInt();
        leitura.nextLine();

//      Obtenção dos modelos da marca selecionada
        url += "/" + codigo + "/modelos";
        json = consumoApi.obterDados(url);

        DadosModelos modelos = converteDados.obterDados(json, DadosModelos.class);
        List<DadosApi> listaModelos = modelos.modelos();
        listaModelos.stream()
                .forEach(modelo -> System.out.println("Código: " + modelo.codigo() + " | Modelo: " + modelo.nome()));

        System.out.println("Escolha o modelo desejado digitando parte dele: ");
        opcao = leitura.nextLine();

        final String ModeloCarroDigitado = opcao;

        Optional<DadosApi> modelo = listaModelos.parallelStream().filter(e -> e.nome().toUpperCase().contains(ModeloCarroDigitado.toUpperCase())).findFirst();

        if (modelo.isPresent()) {
            String codigoModelo = modelo.get().codigo();
            url += "/" + codigoModelo + "/anos";

//          Obtenção de todos os anos do modelo do veiculo selecionado
            json = consumoApi.obterDados(url);
            List<DadosApi> listaAnosModelo = converteDados.obterLista(json, DadosApi.class);

            final String finalUrl = url;

            listaAnosModelo.stream().forEach(ano -> {
                        String urlModeloAnos = finalUrl + "/" + ano.codigo();
                        String apiResponse = consumoApi.obterDados(urlModeloAnos);
                        DadosDetalhesModelo detalheModelo = converteDados.obterDados(apiResponse, DadosDetalhesModelo.class);
                        System.out.println(detalheModelo.modelo()
                                + " ano: " + detalheModelo.anoModelo()
                                + " valor: " + detalheModelo.valor()
                                + "combustível: " + detalheModelo.combustivel());
                    }
            );
        }
        else{
            System.out.println("Não foi encontrado nenhum modelo com o texto fornecido.");
        }
    }
}
