
public class OperadorBitwise {

    public static void main(String[] args) {

        // =========================================
// DEFINIÇÃO DO PRIMEIRO VALOR
// =========================================
        var value1 = 9;

// Converte o número para representação binária
        var binary1 = Integer.toBinaryString(value1);

// Exibe o valor decimal e binário
        System.out.printf(
                "Primeiro número da operação %s (representação binária %s)\n",
                value1,
                binary1
        );

/*
=================================================
OPERADOR OR (|)
=================================================

Compara cada bit dos dois números.
Se pelo menos um dos bits for 1, o resultado será 1.

Exemplo:
9  = 1001
5  = 0101
--------------
OR = 1101 (13)

var value2 = 5;
var binary2 = Integer.toBinaryString(value2);

System.out.printf(
        "Segundo número da operação %s (representação binária %s)\n",
        value2,
        binary2
);

var result = value1 | value2;
var binaryResult = Integer.toBinaryString(result);

System.out.printf(
        "%s | %s = %s (representação binária %s)\n",
        value1,
        value2,
        result,
        binaryResult
);
*/

/*
=================================================
OPERADOR NOT (~)
=================================================

Inverte todos os bits do número.

Exemplo:
9  = 00000000000000000000000000001001
~9 = 11111111111111111111111111110110

Em Java o resultado fica negativo porque utiliza
a representação em complemento de dois;

var result = ~value1;
var binaryResult = Integer.toBinaryString(result);

System.out.printf(
        "~%s = %s (representação binária %s)\n",
        value1,
        result,
        binaryResult
);
*/

/*
=================================================
OPERADOR DE DESLOCAMENTO À ESQUERDA (<<)
=================================================

Move os bits para a esquerda.

Cada deslocamento equivale a multiplicar por 2.

Exemplo:
9 = 1001

9 << 2

1001 -> 100100

Resultado:
36

Porque:
9 * 2² = 9 * 4 = 36
*/

// Valor que define quantas posições os bits serão deslocados
        var value2 = 2;

// Converte para binário apenas para visualização
        var binary2 = Integer.toBinaryString(value2);

        System.out.printf(
                "Segundo número da operação %s (representação binária %s)\n",
                value2,
                binary2
        );

// Realiza o deslocamento para a esquerda
        var result = value1 << value2;

// Converte o resultado para binário
        var binaryResult = Integer.toBinaryString(result);

// Exibe o resultado
        System.out.printf(
                "%s << %s = %s (representação binária %s)\n",
                value1,
                value2,
                result,
                binaryResult
        );
    }
}
