package Ex3.Ingredientes;

import Ex3.Enums.OrigemIngrediente;
import Ex3.Enums.TipoVegetal;
import Ex3.Enums.UnidadeMedida;

public class Vegetal extends Topping{
    private TipoVegetal tipo;

    public Vegetal(int id, String nome, UnidadeMedida medida, double kcalPorMedida, OrigemIngrediente origem, TipoVegetal tipo) {
        super(id, nome, medida, kcalPorMedida, origem);
        this.tipo = tipo;
    }

    @Override
    public void imprimirTipoIngrediente() {
        System.out.println("Isto é um Vegetal");
    }
}