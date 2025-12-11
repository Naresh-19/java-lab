import java.util.Scanner;

class Account {
    String customerName;
    String accNumber;
    String accType;
    double balance;

    Account(String name, String accNo, String type, double bal) {
        customerName = name;
        accNumber = accNo;
        accType = type;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited. Updated Balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

class Sav_acct extends Account {
    Sav_acct(String n, String a, String t, double b) {
        super(n, a, t, b);
    }

    void computeInterest() {
        double rate = 0.05;
        double interest = balance * rate;
        balance += interest;
        System.out.println("Interest Added: " + interest);
        System.out.println("Updated Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Amount Withdrawn. Updated Balance: " + balance);
        }
    }
}

class Cur_acct extends Account {
    final double minBalance = 1000;
    final double serviceCharge = 100;

    Cur_acct(String n, String a, String t, double b) {
        super(n, a, t, b);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Amount Withdrawn. Balance: " + balance);
            checkMinimumBalance();
        }
    }

    void checkMinimumBalance() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Minimum Balance Not Maintained!");
            System.out.println("Service Charge Imposed: " + serviceCharge);
            System.out.println("Updated Balance: " + balance);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.println("Enter Account Type (Saving/Current): ");
        String type = sc.nextLine();

        System.out.println("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        Account acc;

        if (type.equalsIgnoreCase("Saving")) {
            acc = new Sav_acct(name, accNo, "Saving", bal);
        } else {
            acc = new Cur_acct(name, accNo, "Current", bal);
        }

        while (true) {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (acc instanceof Sav_acct)
                System.out.println("4. Compute Interest");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    if (acc instanceof Sav_acct)
                        ((Sav_acct) acc).withdraw(wd);
                    else
                        ((Cur_acct) acc).withdraw(wd);
                    break;

                case 3:
                    acc.displayBalance();
                    break;

                case 4:
                    if (acc instanceof Sav_acct)
                        ((Sav_acct) acc).computeInterest();
                    else
                        System.out.println("Interest not available for Current Account!");
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
