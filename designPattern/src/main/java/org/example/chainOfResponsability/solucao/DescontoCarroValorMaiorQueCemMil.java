package org.example.chainOfResponsability.solucao;

import org.example.chainOfResponsability.Carro;
import org.example.chainOfResponsability.Marca;

import java.math.BigDecimal;

public class DescontoCarroValorMaiorQueCemMil extends DescontoCarro{

    public DescontoCarroValorMaiorQueCemMil(DescontoCarro proximoDesconto){
        super(proximoDesconto);
    }

    @Override
    public BigDecimal aplcaDesconto(Carro carro) {
        BigDecimal valorVenda = carro.getPreco();

        if(carro.getPreco().compareTo(new BigDecimal(100000.00)) > 0){
            return valorVenda.subtract(new BigDecimal(10000));
        }

        return proximoDesconto.aplcaDesconto(carro);
    }
}
