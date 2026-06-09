package estruturaDeControle;

import java.util.Scanner;

public class IfElseIf {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.println("Informe seu nome:");
        var name = scanner.next();
        System.out.println("Informe sua idade:");
        var age = scanner.nextInt();
        System.out.println("Você e emancipado? (s/n)");
        var isEmancipado = scanner.next().equalsIgnoreCase("s");

        if (age >= 18) {
            System.out.printf("%s você tem %s anos, e pode dirigir \n", name, age);

        } else if (age >= 16 && isEmancipado) {
            System.out.printf("%s, apesar de você ter %s anos, você e emancipado e pode dirigir \n", name, age);

        } else {
            System.out.printf("%s, você não pode dirigir \n", name);
        }
        System.out.println("Fim da execussão!");
    }
}
