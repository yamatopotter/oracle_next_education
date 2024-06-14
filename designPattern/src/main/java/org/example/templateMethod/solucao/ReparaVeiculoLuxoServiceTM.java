package org.example.templateMethod.solucao;

import org.example.templateMethod.VeiculoParaReparo;

public class ReparaVeiculoLuxoServiceTM extends ReparoVeiculoService {
    private VeiculoParaReparo veiculoParaReparo;

    public ReparaVeiculoLuxoServiceTM(VeiculoParaReparo veiculoParaReparo){
        this.veiculoParaReparo = veiculoParaReparo;
    }

    @Override
    protected boolean veiculoParaReparo() {
        return veiculoParaReparo.getPorcentagemDano() <= 50;
    }
}
