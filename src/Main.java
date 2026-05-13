import payment.PaymentMethod;
import payment.CreditCardPayment;


public class Main {
    public static void main(String[] args) {
        PaymentMethod paiement = new CreditCardPayment("1234-5678-9012-3456", "Alice Martin");
        paiement.pay(139.99);
    }
}
