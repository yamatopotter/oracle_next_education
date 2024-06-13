package org.example.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteAgenda {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("Sem Singleton");
        reservaDia("Sexta");
        reservaDia("Sábado");

        System.out.println("Singleton Eager");
        reservaDiaEager("Sexta");
        reservaDiaEager("Sábado");

        System.out.println("Singleton Lazy");
        reservaDiaLazy("Sexta");
        reservaDiaLazy("Sábado");

//        Reflection no método lazy
        System.out.println("Teste de reflection - Lazy");
        Constructor<AgendaSingletonLazy> constructor = AgendaSingletonLazy.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        AgendaSingletonLazy agenda11 = constructor.newInstance();
        AgendaSingletonLazy agenda12 = constructor.newInstance();
        System.out.println(agenda11);
        System.out.println(agenda12);

        System.out.println("Singleton ENUM");
        reservaDiaEnum("Sexta");
        reservaDiaEnum("Domingo");
        System.out.println("Teste de reflection - ENUM");

        Constructor<AgendaSingletonLazy> constructorEnum = AgendaSingletonLazy.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        AgendaSingletonLazy agenda13 = constructor.newInstance();
        AgendaSingletonLazy agenda14 = constructor.newInstance();
        System.out.println(agenda13);
        System.out.println(agenda14);
    }

//    Sem singleton
    public static void reservaDia(String dia) {
        Agenda agenda = new Agenda();
        agenda.ocupa(dia);
        System.out.println(agenda.getDias());
    }

    public static void reservaDiaEager(String dia) {
        AgendaSingletonEager agenda = AgendaSingletonEager.getInstance();
        agenda.ocupa(dia);
        System.out.println(agenda.getDias());
    }

    public static void reservaDiaLazy(String dia) {
        AgendaSingletonLazy agenda = AgendaSingletonLazy.getInstance();
        agenda.ocupa(dia);
        System.out.println(agenda.getDias());
    }

    public static void reservaDiaEnum(String dia) {
        AgendaSingletonENUM agenda = AgendaSingletonENUM.getInstance();
        agenda.ocupa(dia);
        System.out.println(agenda.getDias());
    }
}
