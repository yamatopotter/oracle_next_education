package com.matheus.fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDetalhesModelo(
        @JsonAlias("Valor") Double valor,
        @JsonAlias("Marca")String marca,
        @JsonAlias("Modelo")String modelo,
        @JsonAlias("AnoModelo") String anoModelo,
        @JsonAlias("Valor")String combustivel
) {
}
