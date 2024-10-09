
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class AcntNotFnd extends Throwable {

    AcntNotFnd(String message) {
        super(message);
    }
}

class InsufFund extends Throwable {

    InsufFund(String message) {
        super(message);
    }
}

class InvalidAmt extends Throwable {

    InvalidAmt(String message) {
        super(message);
    }
}

public class exceptionHandlingQuestion {

    static void withdraw(ArrayList<String> accountNo, ArrayList<Integer> balance, int index, int amt)
            throws InsufFund, InvalidAmt {
        if (amt < 0) {
            throw new InvalidAmt("Invalid Amount");
        }
        if (balance.get(index) < amt) {
            throw new InsufFund("Insufficient balance");
        }
        balance.set(index, balance.get(index) - amt);
    }

    public static void main(String[] args) {
        ArrayList<String> accountNo = new ArrayList<>();
        ArrayList<Integer> balance = new ArrayList<>();

        accountNo.add("ACC123");
        balance.add(1000);
        accountNo.add("ACC456");
        balance.add(500);
        accountNo.add("ACC789");
        balance.add(1500);

        Scanner scanner = new Scanner(System.in);
        int accountIndex = -1;

        while (true) {
            if (accountIndex == -1) {
                System.out.print("Enter account number: ");
                String acc = scanner.nextLine();

                try {
                    accountIndex = accountNo.indexOf(acc);
                    if (accountIndex == -1) {
                        throw new AcntNotFnd("Account number not found");
                    } else {
                        System.out.println("Account number " + acc + " found.");
                    }
                } catch (AcntNotFnd e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }

            try {
                System.out.print("Enter amount to withdraw: ");
                int amt = scanner.nextInt();
                scanner.nextLine();

                withdraw(accountNo, balance, accountIndex, amt);
                System.out.println("Withdrawal successful. New balance: " + balance.get(accountIndex));
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer amount.");
                scanner.nextLine();
            } catch (InsufFund e) {
                System.out.println(e.getMessage());
            } catch (InvalidAmt e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
        }

    }
}
