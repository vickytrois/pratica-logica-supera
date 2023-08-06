package QuartoDesafio;

import java.util.Scanner;

public class QuartoDesafio {
    /*
     * A sua impressora foi infectada por um vírus e está imprimindo de forma incorreta. Depois
     * de olhar para várias páginas impressas por um tempo, você percebe que ele está
     * imprimindo cada linha de dentro para fora. Em outras palavras, a metade esquerda de cada
     * linha está sendo impressa a partir do meio da página até a margem esquerda. Do mesmo
     * modo, a metade direita de cada linha está sendo impressa à partir da margem direita e
     * prosseguindo em direção ao centro da página.
     *
     * Por exemplo a linha:
     * THIS LINE IS GIBBERISH
     * está sendo impressa como:
     * I ENIL SIHTHSIREBBIG S
     *
     * Da mesma forma, a linha " MANGOS " está sendo impressa incorretamente como
     * "NAM SOG". Sua tarefa é desembaralhar (decifrar) a string a partir da forma como ela foi
     * impressa para a sua forma original. Você pode assumir que cada linha conterá um número
     * par de caracteres.
     * Entrada
     * A entrada contém vários casos de teste. A primeira linha de entrada contém um
     * inteiro N que indica a quantidade de casos de teste. Seguem N linhas, cada uma com uma
     * frase com no mínimo 2 e no máximo 100 caracteres de letras maiúsculas e espaços que
     * deverá ser desembaralhada (decifrada) à partir da forma impressa para a sua forma
     * original, conforme especificação acima.
     * Saída
     * Para cada linha de entrada deverá ser impressa uma linha de saída com a frase decifrada,
     * conforme a especificação acima.
     * Exemplo de Entrada                       Exemplo de Saída
     * 5                                        THIS LINE IS GIBBERISH
     * I ENIL SIHTHSIREBBIG S                   LEVELKAYAK
     * LEVELKAYAK                               HAPPY HOLIDAYS
     * H YPPAHSYADILO                           MLKJIHGFEDCBAZYXWVUTSRQPON
     * ABCDEFGHIJKLMNOPQRSTUVWXYZ               FRENCH HENS TWO DOVES AND A PARTRIDGE
     * VOD OWT SNEH HCNERF EGDIRTRAP A DNA SE
     */
    public static void main(String[] args) {
        Scanner entrada;
        int numeroDeLinhas;
        String[] linhasCifradas;
        int numeroDeLinhasFornecidas;

        entrada = new Scanner(System.in);
        linhasCifradas = null;
        numeroDeLinhas = 0;
        numeroDeLinhasFornecidas = 0;

        System.out.print("Digite o número de linhas que deseja decifrar: ");
        numeroDeLinhas = entrada.nextInt();
        entrada.nextLine();

        linhasCifradas = new String[numeroDeLinhas];

        while (numeroDeLinhasFornecidas < numeroDeLinhas) {
            System.out.println("Digite a " + (numeroDeLinhasFornecidas+1) + "ª linha:");
            String linhaCifrada = entrada.nextLine();
            if (linhaCifrada.length() % 2 != 0) {
                System.out.println("Entrada inválida. Esta solução opera somente com linhas de número de caracteres pares.");
            } else {
                linhasCifradas[numeroDeLinhasFornecidas] = linhaCifrada;
                numeroDeLinhasFornecidas++;
            }
        }

        for (int i = 0; i < numeroDeLinhas; i++) {
            String linhaDecifrada = decifraLinha(linhasCifradas[i]);
            System.out.println(linhaDecifrada);
        }
    }

    public static String decifraLinha(String linhaCifrada) {
        int tamanhoDaLinha;
        int metadeDoTamanho;
        String metadeEsquerda;
        String metadeDireita;
        StringBuilder linhaDecifrada;

        tamanhoDaLinha = linhaCifrada.length();
        metadeDoTamanho = tamanhoDaLinha / 2;
        metadeEsquerda = linhaCifrada.substring(0, metadeDoTamanho);
        metadeDireita = linhaCifrada.substring(metadeDoTamanho);

        linhaDecifrada= new StringBuilder();

        for (int i = metadeDoTamanho - 1; i >= 0; i--) {
            linhaDecifrada.append(metadeEsquerda.charAt(i));
        }

        for (int i = metadeDoTamanho - 1; i >= 0; i--) {
            linhaDecifrada.append(metadeDireita.charAt(i));
        }

        return linhaDecifrada.toString();
    }
}





