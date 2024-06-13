package org.example.adapter;

import java.math.BigDecimal;

public class JarOperacoesContaCorrenteAdapter {
    private JarOperacoesContaCorrente jarConta;

    public JarOperacoesContaCorrenteAdapter(JarOperacoesContaCorrente jarConta) {
        this.jarConta = jarConta;
    }

    public void saca(BigDecimal valorPretendido){
        if(jarConta.validaSaldo(valorPretendido)){
        jarConta.saca(valorPretendido);
        System.out.println("Sacando...");
        }
        else{
            throw new IllegalArgumentException("Valor para saque não permitido");
        }
    }

    public void deposita(BigDecimal valor){
        jarConta.deposita(valor);
    }


}
