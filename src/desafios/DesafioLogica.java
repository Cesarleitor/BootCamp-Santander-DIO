package desafios;

import java.util.Scanner;

public class DesafioLogica {

    public static void main(String[] args) {
        // lê os valores de entrada:
        Scanner leitorDeEntrada = new Scanner(System.in);
        float valorSalario = leitorDeEntrada.nextFloat();
        float valorBeneficios = leitorDeEntrada.nextFloat();

        float valorImposto = 0;
        if ( valorSalario >= 0 && valorSalario <= 1100) {
            // Atribui a alíquota de 5% mediante salário:
            valorImposto = 0.05f * valorSalario;
        }
        else if ( valorSalario >= 1100.01 && valorSalario <= 2500.00) {
            // Atribui a alíquota de 10% mediante salário:
            valorImposto = 0.10f * valorSalario;
        }
        else {
            // Atribui a alíquota de 15% mediante salário:
            valorImposto = 0.15f * valorSalario;
        }






        // Calcula e imprime a saída (com 2 casas decimais):
        float saida = valorSalario - valorImposto + valorBeneficios;
        System.out.println(String.format("%.2f", saida));
    }
}
