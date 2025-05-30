package Ex3;

public class Animal {
    private String nome;
    private String especie;
    private String paisOrigem;
    private double pesoKg;
    private String[] alimentacao;
    private ReinoAnimal reino;

    public Animal(String nome, String especie, String paisOrigem, double pesoKg, String[] alimentacao, ReinoAnimal reino) {
        this.nome = nome;
        this.especie = especie;
        this.paisOrigem = paisOrigem;
        this.pesoKg = pesoKg;
        this.alimentacao = alimentacao;
        this.reino = reino;
    }

    public Animal menosEsquisito(Animal animalComparado) {

        // Comparar o tamanho do array de alimentos
        if (this.alimentacao.length > animalComparado.alimentacao.length) {
            return this;
        } else {
            return animalComparado;
        }
    }

    public void fazerBarulho() {
        switch (reino) {
            case MAMIFERO:
                System.out.println("Tinoninoni");
                break;

            case ANFIBIO:
                System.out.println("Brrrrrrrr");
                break;

            case AVE:
                System.out.println("Kwak Kwak");
                break;

            case PEIXE:
                System.out.println("Blub blub");
                break;

            case REPTIL:
                System.out.println("Pssssssssss");
                break;

        }
    }

    public void comer(String alimento, double pesoG) {

        boolean gostou = false;

        for (int i = 0; i < this.alimentacao.length; i++) {
            if (this.alimentacao[i].equalsIgnoreCase(alimento)) {
                // O animal gosta deste alimento
                gostou = true;
            }
        }

        if (gostou) {
            this.pesoKg += pesoG / 1000;
            System.out.println("O " + this.especie + " " + this.nome + " comeu " + alimento);
            this.fazerBarulho();
        } else {
            System.out.println("O " + this.especie + " " + this.nome + " recusou " + alimento);
        }

    }

    public void exibirDetalhes() {
        System.out.println(this.nome + " | " + this.especie + " | País Origem: " + this.paisOrigem + " | Peso: " + this.pesoKg + " Kg." + " | " + this.reino);
    }
}