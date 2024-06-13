package org.example.adapter;

import java.math.BigDecimal;

public class ClientJarOperacoesContaCorrenteAdapter {
    private JarOperacoesContaCorrenteAdapter jocca;

    public ClientJarOperacoesContaCorrenteAdapter(JarOperacoesContaCorrenteAdapter jocca){
        this.jocca = jocca;
    }

    public void saca(BigDecimal valorPretendido){
        jocca.saca(valorPretendido);
    }

    public void deposita(BigDecimal valor){
        jocca.deposita(valor);
    }
}
