import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        int numero = new Random().nextInt(100);
        int numeroDigitado = 0;
        int tentativas = 0;

        while(tentativas>=0){
            System.out.println("Adivinhe o numero que gerei");
            numeroDigitado = leitura.nextInt();
            tentativas++;

            if(numeroDigitado > numero){
                System.out.println("Um pouco menos");
            } else if (numeroDigitado < numero) {
                System.out.println("Um pouco mais");
            }
            else{
                System.out.println("Ahh, você adivinhou :(");
                System.out.println("Numero de tentativas: "+tentativas);
                break;
            }
        }

    }
}

class ex1{
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int numeroDigitado = 0;

        System.out.println("Digite um numero:");
        numeroDigitado = leitura.nextInt();

        if(numeroDigitado >= 0){
            System.out.println("Numero positivo");
        }
        else{
            System.out.println("Numero negativo");
        }
    }
}

class ex2{
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;

        System.out.println("Digite um numero:");
        n1 = leitura.nextInt();

        System.out.println("Digite outro numero:");
        n2 = leitura.nextInt();

        if(n1 == n2){
            System.out.println("Os numeros são iguais");
        }
        else{
            System.out.println("Os números são diferentes");

            if(n1>n2){
                System.out.println("O primeiro numero é maior");
            }
            else{
                System.out.println("O segundo numero é maior");
            }
        }
    }
}

class ex3{
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int menuOp = 0;

        while(menuOp<3){
            System.out.println("Digite uma opção:");
            System.out.println("1 - Calcular área do quadrado");
            System.out.println("2 - Calcular área do circulo");
            System.out.println("3 - Sair");
            menuOp = leitura.nextInt();

            switch (menuOp){
                case 1:
                    System.out.println("Calculando área do quadrado.");
                    System.out.println("Digite a medida de um dos lados");
                    double lado = leitura.nextDouble();
                    System.out.println("A área do quadrado é: " + lado*lado);
                    break;
                case 2:
                    System.out.println("Calculando área do circulo.");
                    System.out.println("Digite o raio do circulo:");
                    double raio = leitura.nextDouble();
                    System.out.println("A área do círculo é:" + (Math.PI * (raio*raio)));
                    break;
                default:
                    System.out.println("Até a proxima");
                    menuOp = 3;
                    break;
            }
        }

    }
}