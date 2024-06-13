package org.example.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//Eager - carregamento imediato da instancia da classe
public enum AgendaSingletonENUM {
    INSTANCE;

    private Map<String, Boolean> diasDisponiveis = new HashMap<>();

    private AgendaSingletonENUM(){
        diasDisponiveis.put("Domingo", Boolean.TRUE);
        diasDisponiveis.put("Segunda", Boolean.TRUE);
        diasDisponiveis.put("Terća", Boolean.TRUE);
        diasDisponiveis.put("Quarta", Boolean.TRUE);
        diasDisponiveis.put("Quinta", Boolean.TRUE);
        diasDisponiveis.put("Sexta", Boolean.TRUE);
        diasDisponiveis.put("Sábado", Boolean.TRUE);
    }

    public static AgendaSingletonENUM getInstance(){
        return INSTANCE;
    }

    public Map<String, Boolean> getDias(){return diasDisponiveis;}

    public void ocupa(String dia){
        diasDisponiveis.replace(dia, Boolean.FALSE);
    }
}
