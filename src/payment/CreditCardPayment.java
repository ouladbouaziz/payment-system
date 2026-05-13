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
        System.out.println("Paiement de " + amount + "DH par carte de credit !");
        
    }

    public class Receipt{
        private double amount;
        private String date;
        private String cardHolder;

        public Receipt(double amount, String cardHolder){
            this.amount = amount;
            this.date = LocalDate.now().toString();
            this.cardHolder = cardHolder; 

            Receipt receipt = new Receipt(amount, cardHolder);
            receipt.display();
        }

        public void display(){
            System.out.println("======= Recu =======");
            System.out.println("Titulaire : " + cardHolder);
            System.out.println("Montant : " + amount + "DH");
            System.out.println("Date : " + date);
            System.out.println("====================");
        }
    }
}
