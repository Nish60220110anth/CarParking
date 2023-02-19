import java.util.Scanner;
import java.util.Locale;
import java.util.Random;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author NISHANTH
 */
public class ParkingCharge extends ChangeParkingFee {
    public double entryPayToBePaid;
    public double entryPayPaid;
    public double storedAmount;
    public boolean hasGotTicket;
    public boolean hasPaidAmountAtEntry;
    public boolean hasUsedOnlineTransactionsToPay;
    public TransactionType cardType;
    public String cardCompanyName = "";
    public int threeDigitCode;
    public TypeOfCurrency typeOfCurrency = TypeOfCurrency.RUPEES;

    public void transactionDetails() {
        
        try {
            System.out.println("The User had Paid ");
            this.printTheCashInTheirCurrency(inrToGiven(this.entryPayPaid));
            System.out.println("The Charged Entry Fee was ");
            this.printTheCashInTheirCurrency(inrToGiven(this.entryPayToBePaid));
         if(this.storedAmount>0)
         {
             System.out.println("Bonus Cash in his Account is ");
             this.printTheCashInTheirCurrency(inrToGiven(this.storedAmount));
         }
         else if(this.storedAmount==0){
             System.out.println("User have balance of Zero Balance ");
            }
            else {
                double temp=-this.storedAmount;
                System.out.println("User has balance of ");
                printTheCashInTheirCurrency(inrToGiven(temp));
            }
            if (hasGotTicket) {
                System.out.println("Entry Ticket Had Been Given");
            } else {
                System.out.println("Entry Ticket Had Not been Given");
            }
            if (hasPaidAmountAtEntry) {
                System.out.println("User had Paid at Entry");
            } else {
                System.out.println("User had Not Paid Complete Cash at Entry Point");
            }
            // try {
            System.out.println("User used " + this.cardType.toString() + " To Pay the Entry Fee");
            System.out.println("Type of Currency Used  : " + this.typeOfCurrency.toString());
        } catch (Exception e) {
            System.out.println("You need not Pay The Entry Fee!");
        }

    }

    public void payWarningMessage(double entryPayToBePaid, double entryPayPaid, Scanner myin) {
        if (entryPayToBePaid>entryPayPaid) {
            System.out.println("You Have Paid Just " + entryPayPaid + " But You Have To Pay " + entryPayToBePaid);
            System.out.println("Pay the Remaining Fee At Exit Point :)");
            DecimalFormat df=new DecimalFormat("##.##");
            this.storedAmount=Double.parseDouble(df.format(entryPayPaid-entryPayToBePaid));
            double temp=-storedAmount;
            System.out.println("You have to Pay extra " +temp+ " at Exit Point :)");
            this.hasGotTicket = true;
            hasPaidAmountAtEntry = false;
        } else if (entryPayToBePaid == entryPayPaid) {
            System.out.println("You Have Paid The Amount");
            this.storedAmount = 0.00;
            this.hasGotTicket = true;
            hasPaidAmountAtEntry = true;
        } else {
            System.out.println("You Have Paid More Than the Required Amount ");
            System.out.println("Will You Take it Back Now or You Want Us To Deposit in Your Account");
            System.out.println("Enter y/n  (y  : Take Back Now     n : Reduce at Exit Point)");
            myin.nextLine();
            if (myin.nextLine().toLowerCase().equals("y")) {
                storedAmount = 0.00;
            } else {
                storedAmount = (entryPayPaid - entryPayToBePaid);
            }
            this.hasGotTicket = true;
            hasPaidAmountAtEntry = true;
        }
        this.threeDigitCode = toGenerateThreeDigitCode();
        System.out.println("Enjoy Your Day!  \u263A");
    }

    private int toGenerateThreeDigitCode() {
        Random random = new Random();
        int temp = random.nextInt(900) + 100;
        return temp;
    }

    public void displayMoneyCategories() {
        System.out.println("Press 1: "+TypeOfCurrency.RUPEES);
        System.out.println("Press 2: "+TypeOfCurrency.DOLLAR);
        System.out.println("Press 3: "+TypeOfCurrency.YEN);
        System.out.println("Press 4: "+TypeOfCurrency.POUND);
        System.out.println("Press 5: "+TypeOfCurrency.EURO);
    }

    public void switchForMoneyCategories(int moneyCategories) {
        switch (moneyCategories) {
            case 1:
                this.typeOfCurrency = TypeOfCurrency.DOLLAR;
                break;
            case 2:
                this.typeOfCurrency = TypeOfCurrency.RUPEES;
                break;
            case 3:
                this.typeOfCurrency = TypeOfCurrency.YEN;
                break;
            case 4:
                this.typeOfCurrency = TypeOfCurrency.POUND;
                break;
            case 5:
                this.typeOfCurrency = TypeOfCurrency.EURO;
                break;
            default:
                System.out.println("Sorry Your Number is Out Of Bound");
                System.exit(0);
        }
    }

    public void displayMoneyMedium() {
        System.out.println("Press 1: " +TransactionType.CASH.toString());
        System.out.println("Press 2: " +TransactionType.CREDITCARD.toString());
        System.out.println("Press 3: " +TransactionType.DEBITCARD.toString());
        System.out.println("Press 4: " +TransactionType.GOOGLEPAY.toString());
        System.out.println("Press 5: " +TransactionType.MASTERCARD.toString());
        System.out.println("Press 6: " +TransactionType.PAYPAL.toString());
        System.out.println("Press 7: " +TransactionType.PAYTM.toString());

    }

    public void getMoney(ParkingSpotRequired ptype, LicenseStatus ltype, Scanner myin) {
        entryPayToBePaid = getRate(ptype, ltype);
        if (entryPayToBePaid > 0) {
            System.out.print("You have been Charged "); 
            printTheCashInTheirCurrency(entryPayToBePaid);
            System.out.println("\nThrough What Medium Of Transaction You Wish To Pay The Money?");
            System.out.println("(Enter it has Statement (String) Or Type Number as shown in the Table)");
            this.displayMoneyMedium();
            myin.nextLine();
            String temp = (myin.nextLine()).toLowerCase();
            System.out.println("What Currency Type Do You Use?\n(Enter it has Statement (String) Or Type Number as shown in the Table)");
            displayMoneyCategories();
            this.switchForMoneyCategories(myin.nextInt());
            if (temp.matches("(.*credit.*)|(.*debit.*)|(.*master.*)|(.*google.*)|(.*cash.*)|(.*note.*)|(.*pay.*)")) {
                if (temp.matches("(.*credit.*)")) {
                    hasUsedOnlineTransactionsToPay = false;
                    System.out.println("You have chosen a Credit card as a Payment medium");
                    cardType = TransactionType.CREDITCARD;
                    System.out.println("Enter your credit card Company Name: ");
                    myin.nextLine();
                    this.cardCompanyName = myin.nextLine();
                } else if (temp.matches("(.*cash.*)|(.*note.*)")) {
                    hasUsedOnlineTransactionsToPay = false;
                    System.out.println("You have chosen  Cash as a Payment medium");
                    this.cardType = TransactionType.CASH;
                } else if (temp.matches("(.*paytm.*)|(.*tm.*)")) {
                    hasUsedOnlineTransactionsToPay = true;
                    System.out.println("You have chosen a  PayTm as a Payment medium");
                    this.cardType = TransactionType.PAYTM;
                } else if (temp.matches("(.*paypal.*)|(.*pal.*)")) {
                    hasUsedOnlineTransactionsToPay = true;
                    System.out.println("You have chosen a PayPal as a Payment medium");
                    this.cardType = TransactionType.PAYPAL;
                } else if (temp.matches("(.*google ?pay.*)|(.*pay.*)")) {
                    hasUsedOnlineTransactionsToPay = true;
                    System.out.println("You have chosen a Google Pay as a Payment medium");
                    this.cardType = TransactionType.GOOGLEPAY;
                } else if (temp.matches(".*debit.*")) {
                    hasUsedOnlineTransactionsToPay = false;
                    System.out.println("You have chosen a Debit Card as a Payment medium");
                    this.cardType = TransactionType.DEBITCARD;
                    System.out.println("Enter your Debit card Company Name: ");
                    myin.nextLine();
                    this.cardCompanyName = myin.nextLine();
                } else if (temp.matches(".*master.*")) {
                    hasUsedOnlineTransactionsToPay = false;
                    System.out.println("You have chosen a Master Card as a Payment medium");
                    this.cardType = TransactionType.MASTERCARD;
                    System.out.println("Enter your Master card Company Name: ");
                    myin.nextLine();
                    this.cardCompanyName = myin.nextLine();
                }
            } else if (Integer.parseInt(temp) >= 1 && Integer.parseInt(temp) <= 7) {
                if (Integer.parseInt(temp) == 2) {
                    hasUsedOnlineTransactionsToPay = false;
                    System.out.println("You have chosen a credit card as a Payment medium");
                    cardType = TransactionType.CREDITCARD;
                    System.out.println("Enter your credit card Company Name: ");
                    myin.nextLine();
                    this.cardCompanyName = myin.nextLine();
                } else if (Integer.parseInt(temp) == 1) {
                    hasUsedOnlineTransactionsToPay = false;
                    System.out.println("You have chosen " + TransactionType.CASH.toString() + " as a Payment medium");
                    this.cardType = TransactionType.CASH;
                } else if (Integer.parseInt(temp) == 7) {
                    hasUsedOnlineTransactionsToPay = true;
                    System.out.println("You have chosen " + TransactionType.PAYTM.toString() + " as a Payment medium");
                    this.cardType = TransactionType.PAYTM;
                } else if (Integer.parseInt(temp) == 6) {
                    hasUsedOnlineTransactionsToPay = true;
                    System.out.println("You have chosen " + TransactionType.PAYPAL.toString() + " as a Payment medium");
                    this.cardType = TransactionType.PAYPAL;
                } else if (Integer.parseInt(temp) == 4) {
                    hasUsedOnlineTransactionsToPay = true;
                    System.out.println("You have chosen " + TransactionType.GOOGLEPAY.toString() + " as a Payment medium");
                    this.cardType = TransactionType.GOOGLEPAY;
                } else if (Integer.parseInt(temp) == 3) {
                    hasUsedOnlineTransactionsToPay = false;
                    System.out.println("You have chosen " + TransactionType.DEBITCARD.toString() + " as a Payment medium");
                    this.cardType = TransactionType.DEBITCARD;
                    System.out.println("Enter your Debit card Company Name: ");
                    myin.nextLine();
                    this.cardCompanyName = myin.nextLine();
                } else {
                    hasUsedOnlineTransactionsToPay = false;
                    System.out.println("You have chosen " + TransactionType.MASTERCARD.toString() + " as a Payment medium");
                    this.cardType = TransactionType.MASTERCARD;
                    System.out.println("Enter your Master card Company Name: ");
                    myin.nextLine();
                    this.cardCompanyName = myin.nextLine();
                }

            } else {
                System.out.println("You Have Entered Wrong Inputs !");
                System.exit(0);
            }
            System.out.println("Enter the Cash :");
            entryPayPaid = myin.nextDouble();
            payWarningMessage(entryPayToBePaid, entryPayPaid, myin);
        } else if (entryPayToBePaid==0) {
            System.out.println("You Need Not To Pay Entry Fee");
            entryPayPaid=0.00;
            payWarningMessage(entryPayToBePaid,entryPayPaid, myin);
        }

    }

    public double inrToGiven(double value) {
        DecimalFormat temp = new DecimalFormat("##.##");
        if (this.typeOfCurrency == TypeOfCurrency.DOLLAR) {
            return (double) Double.parseDouble(temp.format(value / 70));
        } else if (this.typeOfCurrency == TypeOfCurrency.EURO) {
            return (double) Double.parseDouble(temp.format(value / 80));
        } else if (this.typeOfCurrency == TypeOfCurrency.POUND) {
            return (double) Double.parseDouble(temp.format(value / 88));
        } else if (this.typeOfCurrency == TypeOfCurrency.YEN) {
            return (double) Double.parseDouble(temp.format(value/0.63));
        } else {
            return (double) Double.parseDouble(temp.format(value/1));
        }
    }
    public double givenToInr(double value)
    {
        DecimalFormat df = new DecimalFormat("##.##");
        if(typeOfCurrency == TypeOfCurrency.DOLLAR)
        {return (double)Double.parseDouble(df.format(value*70));}
        else if(typeOfCurrency == TypeOfCurrency.EURO)
        {return (double) Double.parseDouble(df.format(value *80));}
        else if(typeOfCurrency == TypeOfCurrency.POUND)
        {return (double) Double.parseDouble(df.format(value *88));}
        else if(typeOfCurrency == TypeOfCurrency.YEN)
        {   return (double) Double.parseDouble(df.format(value *0.63));}
        else {return value;}
    } 

    public void printTheCashInTheirCurrency(double d) {
    NumberFormat df;
        if (this.typeOfCurrency == TypeOfCurrency.YEN) {
          df= DecimalFormat.getCurrencyInstance(Locale.JAPAN);
           df.setMinimumFractionDigits(2);
           System.out.println(df.format(d));
        } else if (this.typeOfCurrency == TypeOfCurrency.POUND) {
            df = DecimalFormat.getCurrencyInstance(Locale.UK);
            df.setMinimumFractionDigits(2);
            System.out.println(df.format(d));
        } else if (this.typeOfCurrency == TypeOfCurrency.DOLLAR) {
            df = DecimalFormat.getCurrencyInstance(Locale.US);
            df.setMinimumFractionDigits(2);
            System.out.println(df.format(d));
        } else if (this.typeOfCurrency == TypeOfCurrency.EURO) {
            df = DecimalFormat.getCurrencyInstance(Locale.FRANCE);
            df.setMinimumFractionDigits(2);
            System.out.println(df.format(d));
        } else if (this.typeOfCurrency == TypeOfCurrency.RUPEES) {
            System.out.println("₹ " + d);
        }
    }
}