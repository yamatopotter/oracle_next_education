package org.example.chainOfResponsability.solucao;

import org.example.chainOfResponsability.Carro;

import java.math.BigDecimal;

public abstract class DescontoCarro {

    protected DescontoCarro proximoDesconto;

    public DescontoCarro(DescontoCarro proximoDesconto) {
        this.proximoDesconto = proximoDesconto;
    }

    public abstract BigDecimal aplcaDesconto(Carro carro);
}
