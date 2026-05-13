import payment.CreditCardPayment;
import payment.PaymentMethod;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class PaymentGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PaymentGUI::createWindow);
    }

    static void createWindow(){
        JFrame frame = new JFrame("Système de Paiement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,520);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        //-- Header
        JPanel header = new JPanel();
        header.setBackground(new Color(24, 95, 165));
        header.setBorder(new EmptyBorder(14, 20, 14, 20));
        JLabel title = new JLabel("Système de Paiement");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 15));
        header.add(title);

        //-- Formulaire
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(4,2,10,12));
        form.setBorder(new EmptyBorder(20, 20, 10, 20));

        JTextField cardField = new JTextField("1234-5678-9012-3456");
        JTextField holderField = new JTextField("Oulad bouaziz Yassine");
        JTextField amountField = new JTextField("250.00");

        form.add(cardField);
        form.add(holderField);
        form.add(amountField);

        JButton payBtn = new JButton("Payer");
        payBtn.setBackground(new Color(24,95,165));
        payBtn.setForeground(Color.WHITE);
        payBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        form.add(new JLabel()); // Placeholder
        form.add(payBtn);

        //-- Zone du reçu
        JTextArea receiptArea = new JTextArea(6,30);
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        receiptArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        receiptArea.setBackground(new Color(245, 245, 245));
        receiptArea.setText("Le reçu s'affichera ici après le paiement...");

        JScrollPane scroll = new JScrollPane(receiptArea);
        scroll.setBorder(new TitledBorder("Reçu de paiement"));
        scroll.setPreferredSize(new Dimension(380, 160));

        JPanel bottom = new JPanel();   
        bottom.setBorder(new EmptyBorder(10, 20, 20, 20));
        bottom.add(scroll);

        //-- Action du bouton
        payBtn.addActionListener(e->{
            try{
                String card = cardField.getText().trim();
                String holder = holderField.getText().trim();
                double amount = Double.parseDouble(amountField.getText().trim());

                PaymentMethod paiement = new CreditCardPayment(card, holder);
                paiement.pay(amount);

                CreditCardPayment ccp = new CreditCardPayment(card, holder);
                CreditCardPayment.Receipt receipt = ccp.new Receipt(amount, holder);

                receiptArea.setText(
                    "======= Reçu =======\n" +
                    "Titulaire : " + receipt.getCardHolder() + "\n" +
                    "Montant   : " + receipt.getAmount() + " DH\n" +
                    "Date      : " + receipt.getDate() + "\n" +
                    "Statut    : Approuvé\n" +
                    "===================="
                );
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Veuillez entrer un montant valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(header , BorderLayout.NORTH);
        frame.add(form , BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
