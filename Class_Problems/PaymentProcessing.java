
import java.util.Scanner;

interface Payment {
    double processPayment(double amount);
    double getFee(double amount);
    String getMode();
}

class CashPayment implements Payment {
    public double processPayment(double amount) {
        return amount;
    }

    public double getFee(double amount) {
        return 0;
    }

    public String getMode() {
        return "Cash";
    }
}

class CardPayment implements Payment {
    public double processPayment(double amount) {
        return amount * 1.02;
    }

    public double getFee(double amount) {
        return amount * 0.02;
    }

    public String getMode() {
        return "Card";
    }
}

class UpiPayment implements Payment {
    public double processPayment(double amount) {
        return amount;
    }

    public double getFee(double amount) {
        return 0;
    }

    public String getMode() {
        return "UPI";
    }
}

public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Payment[] payments = new Payment[n];
        double[] amounts = new double[n];

        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            amounts[i] = sc.nextDouble();

            switch (mode.toUpperCase()) {
                case "CASH":
                    payments[i] = new CashPayment();
                    break;
                case "CARD":
                    payments[i] = new CardPayment();
                    break;
                case "UPI":
                    payments[i] = new UpiPayment();
                    break;
                default:
                    System.out.println("Invalid payment mode");
                    return;
            }
        }

        for (int i = 0; i < n; i++) {
            double amount = amounts[i];
            double fee = payments[i].getFee(amount);
            double processed = payments[i].processPayment(amount);

            System.out.println(payments[i].getMode() +
                ": amount " + amount +
                ", fee " + fee +
                ", processed " + processed);

            total += processed;
        }

        System.out.println("Total Amount Processed: " + total);

        sc.close();
    }
}
