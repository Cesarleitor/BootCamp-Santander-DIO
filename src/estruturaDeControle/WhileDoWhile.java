package estruturaDeControle;

import java.util.Scanner;

public class WhileDoWhile {

    public static void main(String[] args) {

        // =========================================
        // FOR
        // Executa enquanto a condição for verdadeira
        // =========================================
        System.out.println("FOR:");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Contador: " + i);
        }

        // =========================================
        // WHILE
        // Verifica a condição antes de executar
        // =========================================
        System.out.println("\nWHILE:");

        int contadorWhile = 1;

        while (contadorWhile <= 5) {
            System.out.println("Contador: " + contadorWhile);
            contadorWhile++;
        }

        // =========================================
        // DO-WHILE
        // Executa pelo menos uma vez
        // =========================================
        System.out.println("\nDO-WHILE:");

        int contadorDoWhile = 1;

        do {
            System.out.println("Contador: " + contadorDoWhile);
            contadorDoWhile++;
        } while (contadorDoWhile <= 5);

        }
}
