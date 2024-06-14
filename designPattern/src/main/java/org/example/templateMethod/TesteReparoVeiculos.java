package org.example.templateMethod;

public class TesteReparoVeiculos {
    public static void main(String[] args) {
        System.out.println("----------LUXO---------------");
        VeiculoParaReparo veiculoDeLuxo = new VeiculoParaReparo();
        veiculoDeLuxo.setPorcentagemDano(49);

        ReparaVeiculoLuxoService rpl = new ReparaVeiculoLuxoService(veiculoDeLuxo);
        rpl.reparaVeiculo();
        System.out.println("-----------COMUM--------------");

        VeiculoParaReparo veiculoComum = new VeiculoParaReparo();
        veiculoComum.setPorcentagemDano(71);

        ReparaVeiculoComumService rpc = new ReparaVeiculoComumService(veiculoComum);
        rpc.reparaVeiculo();

    }
}
