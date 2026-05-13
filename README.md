# Payment System — Java

Mini système de paiement en Java illustrant les concepts de :
- Interface
- Classe interne (inner class)
- Organisation en packages

## Structure

src/
├── payment/
│   ├── PaymentMethod.java      # Interface
│   └── CreditCardPayment.java  # Implémentation + classe interne Receipt
└── Main.java                   # Point d'entrée

## Compilation et exécution

```bash
cd src
javac payment/PaymentMethod.java payment/CreditCardPayment.java Main.java
java Main
```

## Exemple de sortie

```
Paiement de 149.99DH par carte de credit !
======= Recu =======
Titulaire : Alice Martin
Montant : 149.99DH
Date : 2026-05-13
====================
```