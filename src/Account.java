import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: ilialloyd
 * Date: 8/7/2022
 * Leave your comment below if you have
 * --------------------------------------------------------
 */
public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int getCustomerNumber() {
        return customerNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(Double amount) {
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        }else {
            System.out.println("Balance Cannot be Negative!\n");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance1" +
                    ": " + moneyFormat.format(savingBalance));
        }else {
            System.out.println("Balance Cannot be Negative!\n");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit to Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        }else {
            System.out.println("Balance Cannot be Negative!\n");
        }
    }


    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit to Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        }else {
            System.out.println("Balance Cannot be Negative!\n");
        }
    }


}
