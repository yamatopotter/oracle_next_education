package org.example.chainOfResponsability.solucao;

import org.example.chainOfResponsability.Carro;
import org.example.chainOfResponsability.Marca;

import java.math.BigDecimal;

public class DescontoCarroFiat extends DescontoCarro{

    public DescontoCarroFiat(DescontoCarro proximoDesconto){
        super(proximoDesconto);
    }

    @Override
    public BigDecimal aplcaDesconto(Carro carro) {
        BigDecimal valorVenda = carro.getPreco();

        if(Marca.FIAT.equals(carro.getMarca())){
            return valorVenda.subtract(new BigDecimal(1000));
        }

        return proximoDesconto.aplcaDesconto(carro);
    }
}
