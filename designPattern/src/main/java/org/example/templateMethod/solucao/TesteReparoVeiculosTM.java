package org.example.templateMethod.solucao;

import org.example.templateMethod.ReparaVeiculoComumService;
import org.example.templateMethod.ReparaVeiculoLuxoService;
import org.example.templateMethod.VeiculoParaReparo;

public class TesteReparoVeiculosTM {
    public static void main(String[] args) {
        System.out.println("----------LUXO---------------");
        VeiculoParaReparo veiculoDeLuxo = new VeiculoParaReparo();
        veiculoDeLuxo.setPorcentagemDano(51);

        ReparaVeiculoLuxoServiceTM rpl = new ReparaVeiculoLuxoServiceTM(veiculoDeLuxo);
        rpl.reparaVeiculo();
        System.out.println("-----------COMUM--------------");

        VeiculoParaReparo veiculoComum = new VeiculoParaReparo();
        veiculoComum.setPorcentagemDano(69);

        ReparaVeiculoComumServiceTM rpc = new ReparaVeiculoComumServiceTM(veiculoComum);
        rpc.reparaVeiculo();

    }
}
