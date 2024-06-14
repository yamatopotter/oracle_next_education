package org.example.templateMethod.solucao;

import org.example.templateMethod.VeiculoParaReparo;

public class ReparaVeiculoComumServiceTM extends ReparoVeiculoService {
    private VeiculoParaReparo veiculoParaReparo;

    public ReparaVeiculoComumServiceTM(VeiculoParaReparo veiculoParaReparo){
        this.veiculoParaReparo = veiculoParaReparo;
    }

    @Override
    protected boolean veiculoParaReparo() {
        return veiculoParaReparo.getPorcentagemDano() <= 70;
    }
}
