package Ex3;

import Ex3.Enums.*;
import Ex3.Ingredientes.*;

public class Main {
    public static void main(String[] args) {

        // Não funciona: Ingrediente x = new Ingrediente(10,"X",UnidadeMedida.GRAMAS,1);

        Base baseFinaItaliana = new Base(5, "Base Italiana", 1, TipoBase.MASSA_FINA, "Tradicional não falha");

        Vegetal molhoTomate = new Vegetal(10, "Molho Tomate", UnidadeMedida.LITROS, 350, OrigemIngrediente.NACIONAL, TipoVegetal.TOMATE);
        Vegetal cogumelo = new Vegetal(90, "Cogumelo", UnidadeMedida.UNIDADES, 3, OrigemIngrediente.NACIONAL, TipoVegetal.COGUMELO);
        Vegetal azeitona = new Vegetal(15, "Azeitona Preta", UnidadeMedida.UNIDADES, 0.25, OrigemIngrediente.NACIONAL, TipoVegetal.AZEITONA);

        Queijo queijoMozzarela = new Queijo(40, "Queijo Mozzarela", UnidadeMedida.GRAMAS, 1.5, OrigemIngrediente.IMPORTADO, TipoQueijo.MOZZARELA);

        Carne pepperoni = new Carne(55, "Pepperoni", UnidadeMedida.UNIDADES, 20, OrigemIngrediente.IMPORTADO, TipoCarne.PEPPERONI);

        FrutoMar camarao = new FrutoMar(33, "Camarão Tigre", UnidadeMedida.UNIDADES, 50, OrigemIngrediente.IMPORTADO, TipoFrutoMar.CAMARAO);


        Pizza pizza4Estacoes = new Pizza(220, "Pizza 4 Estações", "Muito boa!", 12.5, TamanhoPizza.MEDIA,baseFinaItaliana,200,molhoTomate,0.15);

        pizza4Estacoes.adicionarIngredientePizza(queijoMozzarela, 200);
        pizza4Estacoes.adicionarIngredientePizza(pepperoni, 8);
        pizza4Estacoes.adicionarIngredientePizza(cogumelo, 10);
        pizza4Estacoes.adicionarIngredientePizza(azeitona, 10);


        pizza4Estacoes.exibirDetalhes();

        pizza4Estacoes.removerIngredientePizza(5);

        pizza4Estacoes.exibirDetalhes();

        pizza4Estacoes.editarQuantidadeIngredientePizza(queijoMozzarela, 300);

        pizza4Estacoes.exibirDetalhes();

    }
}