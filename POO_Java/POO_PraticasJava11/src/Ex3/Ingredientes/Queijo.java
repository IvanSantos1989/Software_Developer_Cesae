package Ex3.Ingredientes;

import Ex3.Enums.OrigemIngrediente;
import Ex3.Enums.TipoQueijo;
import Ex3.Enums.UnidadeMedida;

public class Queijo extends Topping{
    private TipoQueijo tipo;

    public Queijo(int id, String nome, UnidadeMedida medida, double kcalPorMedida, OrigemIngrediente origem, TipoQueijo tipo) {
        super(id, nome, medida, kcalPorMedida, origem);
        this.tipo = tipo;
    }

    @Override
    public void imprimirTipoIngrediente() {
        System.out.println("Isto é um Queijo");
    }
}