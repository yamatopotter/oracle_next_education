package org.example.chainOfResponsability.solucao;

import org.example.chainOfResponsability.Carro;
import org.example.chainOfResponsability.Marca;

import java.math.BigDecimal;

public class VendaCarroServiceCOR {
    public BigDecimal calculaValorVenda(Carro carro){
        DescontoCarro desconto = new DescontoCarroFiat(
                new DescontoCarroFord(
                        new DescontoCarroValorMaiorQueCemMil(
                                new SemDireitoADesconto(null)
                        )
                )
        );

        return desconto.aplcaDesconto(carro);
    }
}
