package org.example.chainOfResponsability.solucao;

import org.example.chainOfResponsability.Carro;
import org.example.chainOfResponsability.Marca;

import java.math.BigDecimal;

public class DescontoCarroFord extends DescontoCarro{

    public DescontoCarroFord(DescontoCarro proximoDesconto){
        super(proximoDesconto);
    }

    @Override
    public BigDecimal aplcaDesconto(Carro carro) {
        BigDecimal valorVenda = carro.getPreco();

        if(Marca.FORD.equals(carro.getMarca())){
            return valorVenda.subtract(new BigDecimal(2000));
        }

        return proximoDesconto.aplcaDesconto(carro);
    }
}
