package Ex2;

public class PercentageDiscountStrategy implements PaymentStrategy {

    private double discountPercentage;

    public PercentageDiscountStrategy(double discountPercentage) {

        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Desconto não pode ser menor que 0 nem maior que 100");
        }

        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateTotal(double valor) {
        return valor * (1 - discountPercentage);
    }
}