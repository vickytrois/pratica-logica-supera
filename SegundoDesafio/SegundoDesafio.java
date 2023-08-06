package SegundoDesafio;

import java.util.Scanner;

public class SegundoDesafio {
    /*
     * Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor
     * monetário. A seguir, calcule o menor número de notas e moedas possíveis no qual o valor
     * pode ser decomposto. As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas
     * possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. A seguir mostre a relação de notas
     * necessárias.
     * Entrada
     * O arquivo de entrada contém um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).
     * Saída
     * Imprima a quantidade mínima de notas e moedas necessárias para trocar o valor inicial,
     * conforme exemplo fornecido.
     *
     * Exemplo de Entrada   Exemplo de Saída
     * 576.73               NOTAS:
     *                              5   nota(s)     de      R$      100.00
     *                              1   nota(s)     de      R$      50.00
     *                              1   nota(s)     de      R$      20.00
     *                              0   nota(s)     de      R$      10.00
     *                              1   nota(s)     de      R$      5.00
     *                              0   nota(s)     de      R$      2.00
     *                      MOEDAS:
     *                              1   moeda(s)     de      R$      1.00
     *                              1   moeda(s)     de      R$      0.50
     *                              0   moeda(s)     de      R$      0.25
     *                              2   moeda(s)     de      R$      0.10
     *                              0   moeda(s)     de      R$      0.05
     *                              3   moeda(s)     de      R$      0.01
     * Obs.: Utilize ponto (.) para separar a parte decimal.
     */
    public static void main(String[] args) {
        Scanner entrada;
        final int[] VALOR_DAS_NOTAS_EM_CENTAVOS = { 10000, 5000, 2000, 1000, 500, 200 };
        final int[] VALOR_DAS_MOEDAS_EM_CENTAVOS = { 100, 50, 25, 10, 5, 1 };
        float valorEmReais;
        int valorEmCentavos;

        entrada = new Scanner(System.in);
        valorEmReais = 0;
        valorEmCentavos = 0;

        System.out.print("Digite o valor desejado: ");
        valorEmReais = entrada.nextFloat();

        if (valorEmReais >= 0 && valorEmReais <= 1000000.00) {
            valorEmCentavos = (int) (valorEmReais * 100);

            System.out.println("NOTAS:");
            for (int nota : VALOR_DAS_NOTAS_EM_CENTAVOS) {
                int quantidadeNotas = valorEmCentavos / nota;
                valorEmCentavos %= nota;
                System.out.printf("\t\t%d\tnota(s)\tde\tR$\t%.2f\n", quantidadeNotas, nota / 100.0);
            }

            System.out.println("MOEDAS:");
            for (int moeda : VALOR_DAS_MOEDAS_EM_CENTAVOS) {
                int quantidadeMoedas = valorEmCentavos / moeda;
                valorEmCentavos %= moeda;
                System.out.printf("\t\t%d\tmoedas(s)\tde\tR$\t%.2f\n", quantidadeMoedas, moeda / 100.0);
            }
        } else {
            System.out.println("Valor inválido. Insira um valor entre zero e um milhão");
        }
    }
}
