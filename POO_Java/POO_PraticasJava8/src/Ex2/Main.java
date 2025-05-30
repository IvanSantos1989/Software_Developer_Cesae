package Ex2;

public class Main {
    public static void main(String[] args) {

        Edificio edificio = new Edificio
                ("Edifício Central", "Rua Principal",
                        "Porto",
                        "Branco",
                        10,
                        true);


        System.out.println("Nome do Edifício: " + edificio.getNome());
        System.out.println("Rua: " + edificio.getRua());
        System.out.println("Cidade: " + edificio.getCidade());
        System.out.println("Cor da Fachada: " + edificio.getCorFachada());
        System.out.println("Número de Andares: " + edificio.getNumeroAndares());
        System.out.println("Tem Garagem: " + (edificio.gettemGaragem() ? "Sim" : "Não"));
        edificio.setCorFachada("Azul");
        System.out.println("Nova Cor da Fachada: " + edificio.getCorFachada());

    }
}