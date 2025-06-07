package Ex3.Ingredientes;

import Ex3.Enums.OrigemIngrediente;
import Ex3.Enums.UnidadeMedida;

public abstract class Topping extends Ingrediente {
    private OrigemIngrediente origem;

    public Topping(int id, String nome, UnidadeMedida medida, double kcalPorMedida, OrigemIngrediente origem) {
        super(id, nome, medida, kcalPorMedida);
        this.origem = origem;
    }
}