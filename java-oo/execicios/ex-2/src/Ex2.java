public class Ex2 {
    public static void main(String[] args) {
        double temperaturaCelsius = 32.4;
        double temperaturaFahrenheit = (temperaturaCelsius *1.8) +32;

        String mensagem = String.format("A temperatura Celsius %.2f em Fahrenheit corresponde a %.2f", temperaturaCelsius, temperaturaFahrenheit);
        System.out.println(mensagem);
    }
}

class Media{
    public static void main(String[] args) {
        int valor1 = 5;
        int valor2 = 8;
        System.out.println((valor1+valor2)/2);
    }
}

class CastingTypes{
    public static void main(String[] args) {
        double valor1 = 8.6;
        int valor2 = (int) valor1;

        System.out.println(valor2);
    }
}

class ConcatenarString{
    public static void main(String[] args) {
        char letra = 'O';
        String palavra = "i eu sou um texto";

        System.out.println(String.format("%s%s", letra, palavra));
    }
}

class CalcularPrecoProduto{
    public static void main(String[] args) {
        int qnt = 6;
        double precoProduto = 2.34;

        System.out.println(precoProduto*qnt);
    }
}

class ConversaoDeMoeda{
    public static void main(String[] args) {
        double realParaDolar = 4.94;
        double valorParaDolares = 70 * realParaDolar;

        System.out.println(valorParaDolares);
    }
}

class CalculoDeDesconto {
    public static void main(String[] args) {
        double precoOriginal = 80.75;
        double percentualDesconto = 25.5;

        double precoComDesconto = precoOriginal - (precoOriginal * (percentualDesconto/100));

        System.out.println(precoComDesconto);
    }
}
