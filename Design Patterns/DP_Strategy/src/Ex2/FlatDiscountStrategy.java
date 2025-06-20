package Ex2;

public class FlatDiscountStrategy implements PaymentStrategy {

    private double fixedDiscount;

    public FlatDiscountStrategy(double fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }

    @Override
    public double calculateTotal(double valor) {
        return valor - this.fixedDiscount;
    }
}