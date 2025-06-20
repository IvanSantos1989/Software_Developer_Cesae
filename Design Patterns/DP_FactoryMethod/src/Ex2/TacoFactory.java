package Ex2;

public class TacoFactory {
    static Taco criarTaco(String tipo) {

        switch (tipo.toLowerCase()) {

            case "carne":
                return new TacoCarneVaca();

            case "frango":
                return new TacoFrango();

            case "vegetariano":
                return new TacoVegetariano();

            default: return null;
        }
    }
}
