package Ex3.Ingredientes;

import Ex3.Enums.OrigemIngrediente;
import Ex3.Enums.TipoFrutoMar;
import Ex3.Enums.UnidadeMedida;

public class FrutoMar extends Topping{
    private TipoFrutoMar tipo;

    public FrutoMar(int id, String nome, UnidadeMedida medida, double kcalPorMedida, OrigemIngrediente origem, TipoFrutoMar tipo) {
        super(id, nome, medida, kcalPorMedida, origem);
        this.tipo = tipo;
    }

    @Override
    public void imprimirTipoIngrediente() {
        System.out.println("Isto é um Fruto do Mar");
    }
}