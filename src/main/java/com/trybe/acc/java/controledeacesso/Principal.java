package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Controla acesso.
 */
public class Principal {

  /**
   * Classe principal.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int option;

    int qntPeople = 0, minors = 0, adults = 0, elderies = 0;

    do {
      System.out.println("""
              Entre com o número correspondente à opção desejada\s
              1 - Acessar o estabelecimento
              2 - Finalizar sistema e mostrar relatório""");

      option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Entre com a idade:");
                int age = scanner.nextInt();
                String message;
                qntPeople += 1;
                if (age < 18) {
                    message = "Pessoa cliente menor de idade, catraca liberada!";
                    minors++;
                } else if (age <= 49) {
                    message = "Pessoa adulta, catraca liberada!";
                    adults++;
                } else {
                    message = "Pessoa adulta a partir de 50, catraca liberada!";
                    elderies++;
                }
                System.out.println(message);
            }
            case 2 -> {
                double minorsPercentage = ((double) minors / qntPeople) * 100;
                double adultsPercentage = ((double) adults / qntPeople) * 100;
                double elderiesPercentage = ((double) elderies / qntPeople) * 100;
                DecimalFormat df = new DecimalFormat("0.00");
                System.out.println();
                System.out.println("----- Quantidade -----\n"
                        + "menores:" + minors + "\n"
                        + "adultas:" + adults + "\n"
                        + "a partir de 50:"
                        + elderies + "\n");
                System.out.println("----- Percentual -----");
                System.out.println("menores: " + df.format(minorsPercentage) + "%");
                System.out.println("adultas: " + df.format(adultsPercentage) + "%");
                System.out.println("a partir de 50: " + df.format(elderiesPercentage) + "%");
                System.out.println("\nTOTAL: " + qntPeople);
            }
            default -> System.out.println("Entre com uma opção válida.");
        }
    } while (option != 2);
  }
}