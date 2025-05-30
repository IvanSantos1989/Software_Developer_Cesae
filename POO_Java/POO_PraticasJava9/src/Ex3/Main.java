package Ex3;

public class Main {
    public static void main(String[] args) {

//        String[] alimentacaoZacarias = new String[3];
//        alimentacaoZacarias[0]="Peixe";
//        alimentacaoZacarias[1]="Crustaceos";
//        alimentacaoZacarias[2]="Plankton";
//
//        Animal animal1 = new Animal("Zacarias","Pinguim Imperador","Antartica",15,alimentacaoZacarias,ReinoAnimal.AVE);

        Animal animal1 = new Animal("Zacarias", "Pinguim Imperador", "Antartica", 15, new String[]{"Peixe", "Crustaceos", "Plankton"}, ReinoAnimal.AVE);
        Animal animal2 = new Animal("Dumbo", "Elefante", "Congo", 450, new String[]{"Erva", "Folhas", "Fruta", "Palha"}, ReinoAnimal.MAMIFERO);

        System.out.println("_________________________________________________________");

        System.out.println("\nAnimal menos esquisito (o que come mais coisas): ");
        Animal animalMenosEsquisito = animal1.menosEsquisito(animal2);
        animalMenosEsquisito.exibirDetalhes();

        System.out.println("_________________________________________________________");

        animal1.fazerBarulho();
        animal2.fazerBarulho();

        System.out.println("\n\n_________________________________________________________");

        animal1.exibirDetalhes();
        animal2.exibirDetalhes();

        System.out.println("_________________________________________________________");

        animal1.comer("Bife", 500);
        animal2.comer("Fruta", 500);

        System.out.println("_________________________________________________________");

        animal1.exibirDetalhes();
        animal2.exibirDetalhes();

        System.out.println("_________________________________________________________");
    }
}