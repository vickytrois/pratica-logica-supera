package TerceiroDesafio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TerceiroDesafio {
    /*
     * Dado um array de inteiros e um valor alvo, determine o número de pares entre os elementos
     * do array em que a sua diferença seja igual ao valor alvo.
     * Exemplo
     * K = 1
     * arr = [1,2,3,4]
     * Existem 3 valores cuja diferença é igual ao valor alvo K: 2-1 = 1, 3-2 = 1, 4-3 = 1.
     *
     * Descrição do problema:
     * Os pares têm os seguintes parâmetros:
     * int k: Um Inteiro, valor alvo.
     * int arr[n]: Um array de Inteiros.
     *
     * Retorno
     * int: O número de pares que satisfazem o critério.
     *
     * Formatos de Entrada
     * Seu código deve conter duas entradas n e k, que representam o tamanho do array e o valor
     * alvo.
     * Seu código deve conter um array de inteiros, de tamanho n.
     *
     * Exemplos de entrada
     * STDIN    Function
     * -----    --------
     * 5 2      arr[] tamanho n = 5, k = 2
     * 1 5 3 4 2 arr = [1, 5, 3, 4, 2]
     *
     * Exemplo de saida
     * 3
     */
    public static void main(String[] args) {
        Scanner entrada;
        int valorAlvo;
        String valoresParaOVetor;
        int[] valores;
        List<String> paresQueResultamNoValor;
        int numeroDePares;

        entrada = new Scanner(System.in);
        valorAlvo = 0;
        valoresParaOVetor = null;
        valores = null;
        paresQueResultamNoValor = new ArrayList<>();
        numeroDePares = 0;

        System.out.print("Digite o valor alvo: ");
        valorAlvo = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite os valores que deseja conferir: ");
        valoresParaOVetor = entrada.nextLine();

        valoresParaOVetor = valoresParaOVetor.replaceAll("[\\[\\]]", "");

        valores = Arrays.stream(valoresParaOVetor.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(valores);

        paresQueResultamNoValor = identificaParesQueGeramOAlvo(valorAlvo, valores);

        numeroDePares = paresQueResultamNoValor.size();

        System.out.println(numeroDePares);
    }

    public static List<String> identificaParesQueGeramOAlvo(int valorAlvo, int[] valores) {
        List<String> paresQueResultamNoValor;

        paresQueResultamNoValor = new ArrayList<>();

        for (int i = 0; i < valores.length - 1; i++) {
            for (int j = i + 1; j < valores.length; j++) {
                int diferenca = valores[j] - valores[i];
                if (diferenca == valorAlvo) {
                    paresQueResultamNoValor.add(valores[j] + " - " + valores[i] + " = " + valorAlvo);
                }
            }
        }

        return paresQueResultamNoValor;
    }
}
