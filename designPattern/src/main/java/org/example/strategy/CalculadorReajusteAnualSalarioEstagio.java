package org.example.strategy;

import java.math.BigDecimal;

public class CalculadorReajusteAnualSalarioEstagio implements CalculadorReajusteAnualSalario{
    @Override
    public void calcularReajusteAnual(Funcionario funcionario) {
        BigDecimal salario = funcionario.getSalario();
        funcionario.setSalario(salario.add(salario.multiply(new BigDecimal(0.02))));
    }
}
