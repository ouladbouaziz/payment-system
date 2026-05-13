package payment;
import java.time.LocalDate;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder){
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount){
        Receipt receipt = new Receipt(amount, cardHolder);
        receipt.display();
    }

    public class Receipt{
        private double amount;
        private String date;
        private String cardHolder;

        public Receipt(double amount, String cardHolder){
            this.amount = amount;
            this.date = LocalDate.now().toString();
            this.cardHolder = cardHolder; 
        }

        public String getCardHolder(){return cardHolder;}
        public double getAmount(){return amount;}
        public String getDate(){return date;}

        public void display(){
            System.out.println("Reçu — " + cardHolder + " — " + amount + " DH");
        }
    }
}
