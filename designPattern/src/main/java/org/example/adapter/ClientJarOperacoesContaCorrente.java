package org.example.adapter;

import java.math.BigDecimal;

public class ClientJarOperacoesContaCorrente {
    private JarOperacoesContaCorrente jocc;

    public ClientJarOperacoesContaCorrente(JarOperacoesContaCorrente jooc){
        this.jocc = jooc;
    }

    public boolean validaSaldo(BigDecimal valorPretendidoSaque) {
        return jocc.validaSaldo(valorPretendidoSaque);
    }

    public void saca(BigDecimal valorPretendido){
        jocc.saca(valorPretendido);
    }

    public void deposita(BigDecimal valor){
        jocc.deposita(valor);
    }
}
