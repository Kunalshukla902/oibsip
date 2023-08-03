import java.util.Scanner;

class BankAccount {
    // Attributes to store user information
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory = "";

    // Method to register a new user
    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your Username - ");
        this.userName = sc.nextLine();
        System.out.print("\nEnter Your Password - ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number - ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration completed..kindly login");
    }

    // Method to handle user login
    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);

        while (!isLogin) {
            System.out.print("\nEnter Your Username - ");
            String username = sc.nextLine();

            // Check if the entered username matches the registered username
            if (username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("\nEnter Your Password - ");
                    String password = sc.nextLine();

                    // Check if the entered password matches the registered password
                    if (password.equals(this.password)) {
                        System.out.print("\nLogin successful!!");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }

    // Method to handle withdrawals
    public void withdraw() {
        System.out.print("\nEnter amount to withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\nWithdraw Successfully");
                String str = amount + " Rs Withdrawed\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
            // Handle any potential exceptions (not recommended to catch all exceptions like this in a real system)
        }
    }

    // Method to handle deposits
    public void deposit() {
        System.out.print("\nEnter amount to deposit - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try {
            if (amount <= 100000f) {
                transactions++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry...Limit is 100000.00");
            }
        } catch (Exception e) {
            // Handle any potential exceptions (not recommended to catch all exceptions like this in a real system)
        }
    }

    // Method to handle fund transfers
    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Recipient's Name - ");
        String recipient = sc.nextLine();
        System.out.print("\nEnter amount to transfer - ");
        float amount = sc.nextFloat();

        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transferred to " + recipient);
                    String str = amount + " Rs transferred to " + recipient + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry...Limit is 50000.00");
                }
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
            // Handle any potential exceptions (not recommended to catch all exceptions like this in a real system)
        }
    }

    // Method to check account balance
    public void checkBalance() {
        System.out.println("\nCurrent Balance: " + balance + " Rs");
    }

    // Method to view transaction history
    public void transHistory() {
        if (transactions == 0) {
            System.out.println("\nTransaction History: Empty");
        } else {
            System.out.println("\nTransaction History:\n" + transactionHistory);
        }
    }
}

public class AtmInterface {
    // Method to take integer input from the user with error handling for invalid input
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && (input > limit || input < 1)) {
                    System.out.println("Choose a number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only an integer value");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\nWELCOME TO SBI ATM SYSTEM\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice - ");
        int choice = takeIntegerInput(2);

        if (choice == 1) {
            BankAccount b = new BankAccount();
            b.register();

            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice - ");
                int ch = takeIntegerInput(2);

                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n\nWELCOME BACK " + b.name + " \n");
                        boolean isFinished = false;

                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice - ");
                            int c = takeIntegerInput(6);

                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
