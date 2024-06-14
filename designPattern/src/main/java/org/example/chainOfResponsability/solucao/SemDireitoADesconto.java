package org.example.chainOfResponsability.solucao;

import org.example.chainOfResponsability.Carro;
import org.example.chainOfResponsability.Marca;

import java.math.BigDecimal;

public class SemDireitoADesconto extends DescontoCarro{

    public SemDireitoADesconto(DescontoCarro proximoDesconto){
        super(proximoDesconto);
    }

    @Override
    public BigDecimal aplcaDesconto(Carro carro) {
        return BigDecimal.ZERO;
    }
}
