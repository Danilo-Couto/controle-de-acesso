package com.trybe.acc.java.controledeacesso;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;

        int qntPeople = 0;
        int minors = 0;
        int adults = 0;
        int elderies = 0;

        do {
            System.out.println("Entre com o número correspondente à opção desejada \n1 - Acessar o estabelecimento\n2 - Finalizar sistema e mostrar relatório");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Entre com a idade:");
                    int age = scanner.nextInt();

                    String message;

                    qntPeople +=1;

                    if (age < 18) {
                        message = "Pessoa cliente menor de idade, catraca liberada!";
                        minors ++;
                    } else if (age >= 18 && age <= 49) {
                        message = "Pessoa adulta, catraca liberada!";
                        adults ++;
                    } else {
                        message = "Pessoa adulta a partir de 50, catraca liberada!";
                        elderies ++;
                    }
                    System.out.println(message);
                    break;

                case 2:
                    double minorsPercentage = ((double) minors / qntPeople) * 100;
                    double adultsPercentage = ((double) adults / qntPeople) * 100;
                    double elderiesPercentage = ((double) elderies / qntPeople) * 100;

                    DecimalFormat df = new DecimalFormat("0.00");

                    System.out.println("");
                    System.out.println(
                            "----- Quantidade -----\n" +
                            "menores:" + minors + "\n" +
                            "adultas:" + adults + "\n" +
                            "a partir de 50:" + elderies + "\n"
                    );
                    System.out.println("----- Percentual -----");
                    System.out.println("menores: " + df.format(minorsPercentage) + "%");
                    System.out.println("adultas: " + df.format(adultsPercentage) + "%");
                    System.out.println("a partir de 50: " + df.format(elderiesPercentage) + "%");
                    System.out.println("\nTOTAL: " + qntPeople);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 2);
    }
}