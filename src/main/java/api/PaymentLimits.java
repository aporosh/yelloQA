package api;

public class PaymentLimits extends PaymentSystemData {
    private String minimum;
    private String maximum;

    public PaymentLimits(String paymentsSystem, Object limits) {
        super(paymentsSystem, limits);
    }

    public PaymentLimits(String paymentsSystem, Object limits, String minimum, String maximum) {
        super(paymentsSystem, limits);
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public String getMaximum() {
        return maximum;
    }
}
