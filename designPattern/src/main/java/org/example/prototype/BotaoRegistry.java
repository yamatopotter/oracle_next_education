package org.example.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BotaoRegistry {
    private static BotaoRegistry botaoRegistry;
    private static Map<String, Botao> REGISTRY = new HashMap<>();

    static {
        var botaoAmarelo = new Botao();
        botaoAmarelo.setCor("Amarelo");
        botaoAmarelo.setAltura(40);
        botaoAmarelo.setLargura(100);
        botaoAmarelo.setTipoBorda(TipoBordaEnum.GROSSA);
        var botaoVermelho = new Botao();
        botaoVermelho.setCor("Vermelho");
        botaoVermelho.setAltura(30);
        botaoVermelho.setLargura(100);
        botaoVermelho.setTipoBorda(TipoBordaEnum.FINA);
        var botaoAzul = new Botao();
        botaoAzul.setCor("Azul");
        botaoAzul.setAltura(35);
        botaoAzul.setLargura(125);
        botaoAzul.setTipoBorda(TipoBordaEnum.TRACEJADA);

        REGISTRY.put("BOTAO_AMARELO", botaoAmarelo);
        REGISTRY.put("BOTAO_VERMELHO", botaoVermelho);
        REGISTRY.put("BOTAO_AZUL", botaoAzul);
    }

    public static Botao getBotao(String chave){
        return BotaoFactory.getInstance(REGISTRY.get(chave));
    }

    public static void addRegistry(String chave, Botao botao) {
        REGISTRY.put(chave, botao);
    }
}
