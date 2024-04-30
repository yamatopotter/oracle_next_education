public class Main {
    public static void main(String[] args) {
        double temperaturaCelsius = 32.4;
        double temperaturaFahrenheit = (temperaturaCelsius *1.8) +32;

        String mensagem = String.format("A temperatura Celsius %.2f em Fahrenheit corresponde a %.2f", temperaturaCelsius, temperaturaFahrenheit);
        System.out.println(mensagem);
    }
}