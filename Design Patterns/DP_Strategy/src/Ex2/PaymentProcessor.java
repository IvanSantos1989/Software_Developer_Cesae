package Ex2;

public class PaymentProcessor {
    private PaymentStrategy discountStrategy;

    public PaymentProcessor(PaymentStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(PaymentStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal(double valor){
        return this.discountStrategy.calculateTotal(valor);
    }
}