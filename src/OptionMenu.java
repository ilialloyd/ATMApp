import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: ilialloyd
 * Date: 8/7/2022
 * Leave your comment below if you have
 * --------------------------------------------------------
 */
public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() {
        int loginAttempt = 1;

        do {
            try {
                data.put(950450, 3234);
                data.put(456543, 6554);
                System.out.println("Welcome to the ATM Projects!");
                System.out.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your Pin number:");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                loginAttempt=2;
            }
            /*
             *for(Map.Entry<Integer,Integer>it : data.EntrySet(){
             * if(it.getkey()==getCustomerNumber() && it.getValue()==getPinNumber){
             * getAccountType(); }  }
             */
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && (data.get(cn) == pn)) {
                getAccountType();
            }else {
                System.out.println("\n" + "Wrong Customer or PIN number \n");
            }

        }while (loginAttempt==1) ;

    }

    public void getAccountType() {
        System.out.println("Select the Account you want to access");
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Exit");

        int selection = menuInput.nextInt();

        switch (selection) {

            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you using this ATM. Bye. \n");
                break;
            default:
                System.out.println("\n Invalid Choice. Try Again.");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Deposit Funds");
        System.out.println("4. Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM, bye.");
                break;

            default:
                System.out.println("\n Invalid Choice \n");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Deposit Funds");
        System.out.println("4. Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {

            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM, bye.");
                break;

            default:
                System.out.println("\n Invalid Choice \n");
                getSaving();

        }
    }
}
