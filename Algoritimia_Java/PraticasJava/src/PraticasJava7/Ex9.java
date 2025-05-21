package PraticasJava7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static PraticasJava7.Ex7.contarLinhas;


public class Ex9 {
    /**
     * Função que carrega o conteúdo de um ficheiro para uma matriz
     *
     * @param caminho Caminho para o ficheiro a ser carregado
     * @return String[][] - matriz de Strings com o conteúdo do ficheiro
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static String[][] ficheiroParaMatriz(String caminho) throws FileNotFoundException {

        // Saber quantas músicas tem o ficheiro (atenção ao cabeçalho (-1))
        int numeroMusicas = contarLinhas(caminho) - 1;

        // Criar uma matriz com o tamanho certo
        String[][] matrizCompleta = new String[numeroMusicas][4];

        // Criar as ferramentas de leitura
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        // Avançar o cabeçalho
        sc.nextLine();

        // Controlar o numero da musica
        int numMusicaAtual = 0;

        // Enquanto houver músicas
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(",");

            for (int i = 0; i < matrizCompleta[0].length; i++) {
                matrizCompleta[numMusicaAtual][i] = linhaSeparada[i];
            }

            numMusicaAtual++;

        }

        return matrizCompleta;
    }

    /**
     * Função que pesquisa músicas de um determinado género
     * @param matriz Matriz com todas as músicas
     * @param generoPesquisa Género a pesquisar
     */
    public static void pesquisarMusicasGenero(String[][] matriz, String generoPesquisa) {

        System.out.println("\n_*_*_ Músicas de " + generoPesquisa + " _*_*_");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][2].equalsIgnoreCase(generoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][1]);
            }
        }
    }


    /**
     * Função que pesquisa músicas de um determinado artista
     * @param matriz Matriz com todas as músicas
     * @param artistaPesquisa Artista a pesquisar
     */
    public static void pesquisarMusicasArtista(String[][] matriz, String artistaPesquisa) {

        System.out.println("\n_*_*_ Músicas de " + artistaPesquisa + " _*_*_");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][1].equalsIgnoreCase(artistaPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][2]);
            }

        }
    }

    /**
     * Função que imprime a música mais longa
     * @param matriz Matriz com todas as músicas
     */
    public static void musicaMaisLonga(String[][] matriz) {

        String nomeMaiorMusica = "", artistaMaiorMusica = "", generoMaiorMusica = "";
        int duracaoTotalMaiorMusica = 0;

        for (int linha = 0; linha < matriz.length; linha++) {

            // Calcular a duração total (em segundos) da musica atual
            String duracaoNaoTratada = matriz[linha][3];
            String[] duracaoDividida = duracaoNaoTratada.split(":");

            int minutosMusicaAtual = Integer.parseInt(duracaoDividida[0]);
            int segundosMusicaAtual = Integer.parseInt(duracaoDividida[1]);

            int segundosTotaisMusicaAtual = (minutosMusicaAtual * 60) + segundosMusicaAtual;

            // Comparar e perceber se é a maior música
            if (segundosTotaisMusicaAtual > duracaoTotalMaiorMusica) {
                duracaoTotalMaiorMusica = segundosTotaisMusicaAtual;
                nomeMaiorMusica = matriz[linha][0];
                artistaMaiorMusica = matriz[linha][1];
                generoMaiorMusica = matriz[linha][2];
            }
        }

        System.out.println("Nome: " + nomeMaiorMusica);
        System.out.println("Artista: " + artistaMaiorMusica);
        System.out.println("Género: " + generoMaiorMusica);


    }

    /**
     * Função que pesquisa músicas acima de uma determinada duração (minutos:segundos)
     * @param matriz Matriz com todas as músicas
     * @param minutosProcurar Minutos mínimos
     * @param segundosProcurar Segundos mínimos
     */
    public static void pesquisarMusicasDuracao(String[][] matriz, int minutosProcurar, int segundosProcurar) {

        System.out.println("\nMúsicas acima de " + minutosProcurar + ":" + segundosProcurar);

        int totalProcurar = (minutosProcurar * 60) + segundosProcurar; // Pegamos nos valores que foram passados por parametro e passamos tudo para segundos

        for (int linha = 0; linha < matriz.length; linha++) { // For: porque precisamos de percorrer todas as linhas (musicas) da matriz

            // Calcular a duração total (em segundos) da musica atual
            String duracaoNaoTratada = matriz[linha][3]; // Apanhamos a informação bruta (por exemplo: "6:06")
            String[] duracaoDividida = duracaoNaoTratada.split(":"); // Dividimos usando o split. ["6"]["06"]

            // Passamos para duas variaveis individuais
            int minutosMusicaAtual = Integer.parseInt(duracaoDividida[0]); // Minutos são a posição 0 do array duracaoDividida
            int segundosMusicaAtual = Integer.parseInt(duracaoDividida[1]); // Segundos são a posição 1 do array duracaoDividida

            int segundosTotaisMusicaAtual = (minutosMusicaAtual * 60) + segundosMusicaAtual; // Calcular o total de segundos da música atual

            // Comparar e perceber se a musica tem o minimo de duração para ser impressa
            if (segundosTotaisMusicaAtual > totalProcurar) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][1] + " | " + matriz[linha][2] + " | " + matriz[linha][3]);
            }
        }
    }

    /**
     * Função que contém o meno do programa
     */
    public static void menu(String[][] matriz) {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n\n_*_*_*_*_*_*_*_*_*_ Programa de Músicas TOP _*_*_*_*_*_*_*_*_*_");
            System.out.println("1. Pesquisar por Género");
            System.out.println("2. Pesquisar por Artista");
            System.out.println("3. Música Mais Longa");
            System.out.println("4. Pesquisar por Duração");
            System.out.println("5. Total de Músicas");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("_*_*_*_*_*_ Pesquisar por Género _*_*_*_*_*_ ");
                    System.out.print("Género a pesquisar: ");
                    input.nextLine(); // Limpar o buffer
                    String generoPesquisa = input.nextLine();

                    pesquisarMusicasGenero(matriz, generoPesquisa);
                    break;

                case 2:
                    System.out.println("_*_*_*_*_*_ Pesquisar por Artista _*_*_*_*_*_ ");
                    System.out.print("Artista a pesquisar: ");
                    input.nextLine(); // Limpar o buffer
                    String artistaPesquisa = input.nextLine();

                    pesquisarMusicasArtista(matriz, artistaPesquisa);
                    break;

                case 3:
                    System.out.println("_*_*_*_*_*_ Música Mais Longa _*_*_*_*_*_ ");
                    musicaMaisLonga(matriz);
                    break;

                case 4:
                    System.out.println("_*_*_*_*_*_ Pesquisar por Duração _*_*_*_*_*_ ");
                    System.out.println("Acima de quantos minutos e segundos?");

                    System.out.print("Minutos: ");
                    int minutosInput = input.nextInt();

                    System.out.print("Segundos: ");
                    int segundosInput = input.nextInt();

                    pesquisarMusicasDuracao(matriz, minutosInput, segundosInput);
                    break;

                case 5:
                    System.out.println("_*_*_*_*_*_ Total de Músicas _*_*_*_*_*_ ");
                    System.out.println(matriz.length);
                    break;

                case 0:
                    System.out.println("_*_*_*_*_*_ Encerrar o Programa _*_*_*_*_*_ ");
                    break;

                default:
                    System.out.println("!!!!!!!!!!! Opção Inválida !!!!!!!!!!!");
                    break;

            }

        } while (opcao != 0);
    }

    public static void main(String[] args) throws FileNotFoundException {

        String[][] matriz = ficheiroParaMatriz("Ficheiros/exercicio_09.csv");
        menu(matriz);

        // menu(ficheiroParaMatriz("Ficheiros/exercicio_09.csv"));
    }
}