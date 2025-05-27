package Bibliotecas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FunctionsClient {
    /*Imprimir Catálogo de todos os filmes avaliados e respetiva classificação*/
    public static void printCatalogoFilmes(String path) throws FileNotFoundException {

        File ficheiro = new File(path);
        Scanner reader = new Scanner(ficheiro);

        System.out.println("\nCatálogo de Filmes Avaliados:\n");

        if (reader.hasNextLine()) {
            reader.nextLine(); // Lê o cabeçalho e ignora
        }

        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            String[] partes = linha.split(";");
            if (partes.length >= 3) {
                String filme = partes[1].trim();
                String classificacao = partes[2].trim();
                System.out.println("Filme: " + filme + " | Classificação: " + classificacao);
            }
        }
    }

    //imprimir catálogo gráfico de filmes com base no número escolhido pelo utilizador
    public static void printCatalogoGraficos() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("\nFilmes com Arte Gráfica disponíveis:");
        System.out.println("1. Harry Potter");
        System.out.println("2. Interstellar");
        System.out.println("3. Lord of the Rings");
        System.out.println("4. Star Wars");

        System.out.print("\nEscolha um número (1-4) para ver o catálogo gráfico: ");
        int escolha = input.nextInt();

        String ficheiro = "";

        switch (escolha) {
            case 1:
                ficheiro = "FicheirosIMDV/CatalogoGrafico/HarryPotter.txt";
                break;
            case 2:
                ficheiro = "FicheirosIMDV/CatalogoGrafico/Interstellar.txt";
                break;
            case 3:
                ficheiro = "FicheirosIMDV/CatalogoGrafico/LordOfTheRings.txt";
                break;
            case 4:
                ficheiro = "FicheirosIMDV/CatalogoGrafico/StarWars.txt";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        File file = new File(ficheiro);

        Scanner reader = new Scanner(file);
        System.out.println("\n--- Conteúdo do Catálogo Gráfico ---\n");
        while (reader.hasNextLine()) {
            System.out.println(reader.nextLine());
        }
    }


    //função Melhor Estúdio: Imprime qual o estúdio com maior classificação média.
    public static void melhorEstudio(String path) throws FileNotFoundException {
        File ficheiro = new File(path);

        // 1ª Leitura: contar número de linhas válidas (para estimar tamanho)
        Scanner contador = new Scanner(ficheiro);
        int linhasValidas = 0;

        if (contador.hasNextLine()) contador.nextLine(); // ignora cabeçalho
        while (contador.hasNextLine()) {
            String linha = contador.nextLine();
            String[] partes = linha.split(";");
            if (partes.length >= 6) {
                linhasValidas++;
            }
        }


        // Criar arrays com o tamanho exato
        String[] estudios = new String[linhasValidas];
        double[] somaClassificacoes = new double[linhasValidas];
        int[] contagemFilmes = new int[linhasValidas];
        int totalEstudios = 0;

        // 2ª Leitura: processar estúdios e classificações
        Scanner reader = new Scanner(ficheiro);
        if (reader.hasNextLine()) reader.nextLine(); // ignora cabeçalho

        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            String[] partes = linha.split(";");
            if (partes.length >= 6) {
                String estudio = partes[5].trim();
                double classificacao = Double.parseDouble(partes[2].trim());

                boolean encontrado = false;
                for (int i = 0; i < totalEstudios; i++) {
                    if (estudios[i].equals(estudio)) {
                        somaClassificacoes[i] += classificacao;
                        contagemFilmes[i]++;
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    estudios[totalEstudios] = estudio;
                    somaClassificacoes[totalEstudios] = classificacao;
                    contagemFilmes[totalEstudios] = 1;
                    totalEstudios++;
                }
            }
        }


        // Encontrar o estúdio com maior média
        String melhorEstudio = "";
        double maiorMedia = 0.0;

        for (int i = 0; i < totalEstudios; i++) {
            double media = somaClassificacoes[i] / contagemFilmes[i];
            if (media > maiorMedia) {
                maiorMedia = media;
                melhorEstudio = estudios[i];
            }
        }

        System.out.println("\nMelhor Estúdio: " + melhorEstudio + " | Média de Classificação: " + maiorMedia);
    }

    //agora é a vez do pior estúdio: Imprime qual o estúdio com menor classificação média.
    public static void piorEstudio(String path) throws FileNotFoundException {
        File ficheiro = new File(path);

        // 1ª Leitura: contar número de linhas válidas
        Scanner contador = new Scanner(ficheiro);
        int linhasValidas = 0;
        if (contador.hasNextLine()) contador.nextLine(); // ignora cabeçalho
        while (contador.hasNextLine()) {
            String linha = contador.nextLine();
            String[] partes = linha.split(";");
            if (partes.length >= 6) {
                linhasValidas++;
            }
        }


        // Arrays com tamanho exato
        String[] estudios = new String[linhasValidas];
        double[] somaClassificacoes = new double[linhasValidas];
        int[] contagemFilmes = new int[linhasValidas];
        int totalEstudios = 0;

        // 2ª Leitura: processar dados
        Scanner reader = new Scanner(ficheiro);
        if (reader.hasNextLine()) reader.nextLine(); // ignora cabeçalho

        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            String[] partes = linha.split(";");
            if (partes.length >= 6) {
                String estudio = partes[5].trim();
                double classificacao = Double.parseDouble(partes[2].trim());

                boolean encontrado = false;
                for (int i = 0; i < totalEstudios; i++) {
                    if (estudios[i].equals(estudio)) {
                        somaClassificacoes[i] += classificacao;
                        contagemFilmes[i]++;
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    estudios[totalEstudios] = estudio;
                    somaClassificacoes[totalEstudios] = classificacao;
                    contagemFilmes[totalEstudios] = 1;
                    totalEstudios++;
                }
            }
        }


        // Inicializa com o primeiro estúdio
        String piorEstudio = estudios[0];
        double menorMedia = somaClassificacoes[0] / contagemFilmes[0];

        // Percorre os restantes
        for (int i = 1; i < totalEstudios; i++) {
            double media = somaClassificacoes[i] / contagemFilmes[i];
            if (media < menorMedia) {
                menorMedia = media;
                piorEstudio = estudios[i];
            }
        }
        System.out.println("\nPior Estúdio: " + piorEstudio + " | Média de Classificação: " + menorMedia);
    }


    //Imprimir Crítica Mais Recente: Imprime a última crítica atribuída.
    public static void printCriticaMaisRecente(String path) throws FileNotFoundException {

        File ficheiro = new File(path);
        Scanner reader = new Scanner(ficheiro);

        String cabecalho = "";
        String ultimaCritica = "";

        if (reader.hasNextLine()) {
            cabecalho = reader.nextLine(); // salva o cabeçalho
        }

        while (reader.hasNextLine()) {
            ultimaCritica = reader.nextLine(); // Lê a última linha do ficheiro
        }

        System.out.println(cabecalho);
        System.out.println(ultimaCritica);
}


    // aqui fazemos o quiz de cinema, onde o utilizador responde a perguntas e recebe uma pontuação no final
    public static void displayQuiz(String path) throws FileNotFoundException {
        File ficheiro = new File(path);
        Scanner reader = new Scanner(ficheiro);

        int score = 0;
        int questionNumber = 1;
        Scanner input = new Scanner(System.in); // Só um scanner para as respostas

        if (reader.hasNextLine()) {
            reader.nextLine(); // Lê o cabeçalho e ignora
        }

        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            String[] partes = linha.split(";");

            if (partes.length >= 5) {
                String pergunta = partes[0];
                String opcaoA = partes[1];
                String opcaoB = partes[2];
                String opcaoC = partes[3];
                String opcaoD = partes[4];
                String respostaCorreta = partes[5];

                System.out.println("\nPergunta " + questionNumber + ": " + pergunta);
                System.out.println("1) " + opcaoA);
                System.out.println("2) " + opcaoB);
                System.out.println("3) " + opcaoC);
                System.out.println("4) " + opcaoD);
                System.out.print("Digite a sua resposta (1-4): ");
                String resposta = input.nextLine();

                if (resposta.equals(respostaCorreta)) {
                    System.out.println(" Resposta correta!");
                    score++;
                } else {
                    System.out.println(" Resposta errada! Resposta correta: " + respostaCorreta);
                }

                questionNumber++;
            }
        }
        System.out.println("\nSua pontuação final: " + score + " de " + (questionNumber - 1));
    }


    //aqui serve para o utilizador pesquisar por um estúdio específico e imprimir os filmes desse estúdio, organizados por categoria
    public static void printCatalogoEstudio(String path, String estudioPesquisa) throws FileNotFoundException {
        File ficheiro;
        Scanner reader;

        // === 1ª LEITURA: Contar categorias únicas ===
        ficheiro = new File(path);
        reader = new Scanner(ficheiro);
        int totalCategorias = 0;

        if (reader.hasNextLine()) reader.nextLine(); // Ignora cabeçalho

        // Contar quantas categorias únicas existem para o estúdio
        String[] categoriasTemp = new String[0];

        while (reader.hasNextLine()) {
            String[] partes = reader.nextLine().split(";");
            if (partes.length >= 7) {
                String categoria = partes[7].trim();
                String estudio = partes[5].trim();

                if (estudio.equalsIgnoreCase(estudioPesquisa)) {
                    boolean existe = false;
                    for (int i = 0; i < totalCategorias; i++) {
                        if (categoriasTemp[i].equalsIgnoreCase(categoria)) {
                            existe = true;
                            break;
                        }
                    }

                    if (!existe) {
                        // Criar novo array maior e copiar
                        String[] novoArray = new String[totalCategorias + 1];
                        for (int i = 0; i < totalCategorias; i++) {
                            novoArray[i] = categoriasTemp[i];
                        }
                        novoArray[totalCategorias] = categoria;
                        categoriasTemp = novoArray;
                        totalCategorias++;
                    }
                }
            }
        }


        // === 2ª LEITURA: Contar filmes por categoria ===
        int[] contagemFilmes = new int[totalCategorias];
        ficheiro = new File(path);
        reader = new Scanner(ficheiro);
        if (reader.hasNextLine()) reader.nextLine(); // Ignora cabeçalho

        while (reader.hasNextLine()) {
            String[] partes = reader.nextLine().split(";");
            if (partes.length >= 7) {
                String categoria = partes[7].trim();
                String estudio = partes[5].trim();

                if (estudio.equalsIgnoreCase(estudioPesquisa)) {
                    for (int i = 0; i < totalCategorias; i++) {
                        if (categoriasTemp[i].equalsIgnoreCase(categoria)) {
                            contagemFilmes[i]++;
                            break;
                        }
                    }
                }
            }
        }


        // === Criar arrays para os filmes por categoria ===
        String[][] filmesPorCategoria = new String[totalCategorias][];
        for (int i = 0; i < totalCategorias; i++) {
            filmesPorCategoria[i] = new String[contagemFilmes[i]];
            contagemFilmes[i] = 0; // reset para usar como índice
        }

        // === 3ª LEITURA: Preencher os filmes ===
        ficheiro = new File(path);
        reader = new Scanner(ficheiro);
        if (reader.hasNextLine()) reader.nextLine(); // Ignora cabeçalho

        while (reader.hasNextLine()) {
            String[] partes = reader.nextLine().split(";");
            if (partes.length >= 7) {
                String titulo = partes[1].trim();
                String categoria = partes[7].trim();
                String estudio = partes[5].trim();

                if (estudio.equalsIgnoreCase(estudioPesquisa)) {
                    for (int i = 0; i < totalCategorias; i++) {
                        if (categoriasTemp[i].equalsIgnoreCase(categoria)) {
                            filmesPorCategoria[i][contagemFilmes[i]] = titulo;
                            contagemFilmes[i]++;
                            break;
                        }
                    }
                }
            }
        }


        // === Impressão final ===
        System.out.println("\n> Estúdio a pesquisar: " + estudioPesquisa);
        System.out.println("\n**** " + estudioPesquisa + " ****\n");

        for (int i = 0; i < totalCategorias; i++) {
            System.out.println("__ " + categoriasTemp[i] + " __");
            for (int j = 0; j < filmesPorCategoria[i].length; j++) {
                System.out.println(filmesPorCategoria[i][j]);
            }
            System.out.println();
        }
    }

    //pesquisando por categoria, mostra todos os estúdios e os respetivos filmes.
    public static void printCatalogoCategoria(String path, String categoriaPesquisa) throws FileNotFoundException {
        // === 1ª LEITURA: Estúdios únicos da categoria ===

        File ficheiro = new File(path);
        Scanner reader = new Scanner(ficheiro);
        int totalEstudios = 0;

        if (reader.hasNextLine()) reader.nextLine(); // Ignora cabeçalho

        String[] estudiosTemp = new String[0];

        while (reader.hasNextLine()) {
            String[] partes = reader.nextLine().split(";");
            if (partes.length >= 7) {
                String categoria = partes[7].trim();
                String estudio = partes[5].trim();

                if (categoria.equalsIgnoreCase(categoriaPesquisa)) {
                    boolean existe = false;
                    for (int i = 0; i < totalEstudios; i++) {
                        if (estudiosTemp[i].equalsIgnoreCase(estudio)) {
                            existe = true;
                            break;
                        }
                    }

                    if (!existe) {
                        String[] novoArray = new String[totalEstudios + 1];
                        for (int i = 0; i < totalEstudios; i++) {
                            novoArray[i] = estudiosTemp[i];
                        }
                        novoArray[totalEstudios] = estudio;
                        estudiosTemp = novoArray;
                        totalEstudios++;
                    }
                }
            }
        }


        // === 2ª LEITURA: Contar filmes por estúdio ===
        int[] contagemFilmes = new int[totalEstudios];
        ficheiro = new File(path);
        reader = new Scanner(ficheiro);
        if (reader.hasNextLine()) reader.nextLine(); // Ignora cabeçalho

        while (reader.hasNextLine()) {
            String[] partes = reader.nextLine().split(";");
            if (partes.length >= 7) {
                String categoria = partes[7].trim();
                String estudio = partes[5].trim();

                if (categoria.equalsIgnoreCase(categoriaPesquisa)) {
                    for (int i = 0; i < totalEstudios; i++) {
                        if (estudiosTemp[i].equalsIgnoreCase(estudio)) {
                            contagemFilmes[i]++;
                            break;
                        }
                    }
                }
            }
        }


        // === Criar arrays para os filmes por estúdio ===
        String[][] filmesPorEstudio = new String[totalEstudios][];
        for (int i = 0; i < totalEstudios; i++) {
            filmesPorEstudio[i] = new String[contagemFilmes[i]];
            contagemFilmes[i] = 0;
        }

        // === 3ª LEITURA: Preencher os filmes ===
        ficheiro = new File(path);
        reader = new Scanner(ficheiro);
        if (reader.hasNextLine()) reader.nextLine(); // Ignora cabeçalho

        while (reader.hasNextLine()) {
            String[] partes = reader.nextLine().split(";");
            if (partes.length >= 7) {
                String titulo = partes[1].trim();
                String categoria = partes[7].trim();
                String estudio = partes[5].trim();

                if (categoria.equalsIgnoreCase(categoriaPesquisa)) {
                    for (int i = 0; i < totalEstudios; i++) {
                        if (estudiosTemp[i].equalsIgnoreCase(estudio)) {
                            filmesPorEstudio[i][contagemFilmes[i]] = titulo;
                            contagemFilmes[i]++;
                            break;
                        }
                    }
                }
            }
        }


        // === Impressão final ===
        System.out.println("\n> Categoria a pesquisar: " + categoriaPesquisa);
        System.out.println("\n**** " + categoriaPesquisa + " ****\n");

        for (int i = 0; i < totalEstudios; i++) {
            System.out.println("__ " + estudiosTemp[i] + " __");
            for (int j = 0; j < filmesPorEstudio[i].length; j++) {
                System.out.println(filmesPorEstudio[i][j]);
            }
            System.out.println();
        }
    }
}