package PrimeiroDesafio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimeiroDesafio {
    /*
     * Considerando a entrada de valores inteiros não negativos, ordene estes valores segundo
     * o seguinte critério:
     * • Primeiro os Pares
     * • Depois os Ímpares
     * Sendo que deverão ser apresentados os pares em ordem crescente e depois os ímpares
     * em ordem decrescente.
     *
     * Entrada
     * A primeira linha de entrada contém um único inteiro positivo N (1 < N <= 105) Este é o
     * número de linhas de entrada que vem logo a seguir. As próximas N linhas conterão, cada
     * uma delas, um valor inteiro não negativo.
     *
     * Saída
     * Apresente todos os valores lidos na entrada segundo a ordem apresentada acima. Cada
     * número deve ser impresso em uma linha, conforme exemplo abaixo.
     * Exemplo de Entrada   Exemplo de Saída
     * 10                   4
     * 4                    32
     * 32                   34
     * 34                   98
     * 543                  654
     * 3456                 3456
     * 654                  6789
     * 567                  567
     * 87                   543
     * 6789                 87
     * 98
     */

    public static void main(String[] args) {
        Scanner entrada;
        int numeroDeValoresAOrdenar;
        List<Integer> numerosPares;
        List<Integer> numerosImpares;

        entrada = new Scanner(System.in);
        numeroDeValoresAOrdenar = 0;
        numerosPares = new ArrayList<>();
        numerosImpares = new ArrayList<>();

        System.out.print("Insira quantos números devem ser ordenados: ");
        numeroDeValoresAOrdenar = entrada.nextInt();
        if (numeroDeValoresAOrdenar > 0 && numeroDeValoresAOrdenar < 106) {
            for (int i = 0; i < numeroDeValoresAOrdenar; i++) {
                System.out.print("Insira o " + (i+1) + " valor: ");
                int novoValor = entrada.nextInt();

                if (novoValor % 2 == 0) {
                    numerosPares.add(novoValor);
                } else {
                    numerosImpares.add(novoValor);
                }
            }

            Collections.sort(numerosPares);
            numerosImpares.sort(Collections.reverseOrder());

//            System.out.println("Números Pares:");
            for (int valorPar : numerosPares) {
                System.out.println(valorPar);
            }

//            System.out.println("Números Ímpares:");
            for (int valorImpar : numerosImpares) {
                System.out.println(valorImpar);
            }

        } else {
            System.out.println("Não é possível ordenar esse número de valores. Entre um número maior que 0 e menor que 106.");
        }
    }
}
