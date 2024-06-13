package org.example.strategy;

import java.math.BigDecimal;

public class ReajusteAnualSalarioStrategy {
    public void calculaReajusteAnual(Funcionario funcionario, CalculadorReajusteAnualSalario calculador){
        calculador.calcularReajusteAnual(funcionario);
    }
}
