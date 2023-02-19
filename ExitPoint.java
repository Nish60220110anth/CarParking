import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
public class ExitPoint extends EntryPoint {
    public double end;
    public double amountToBePaid;
    public double firstHour = 20;
    public double secondHour = 10;
    public double thirdHour = 5;
    public int noOfHourSpend;
    private static int noOfTrails =3;
    public boolean isCheckExit = false;

    public void toTakeTheCar(Scanner myin) {
        if (isCheckExit) {
            double noOfHoursSpendT;
            end = System.nanoTime();
            noOfHoursSpendT = this.end - this.start;
            noOfHoursSpendT = Math.floor(noOfHoursSpendT / 1000);
            this.noOfHourSpend = (int) Math.round(noOfHoursSpendT);
            amountToBePaid = getAmountWRTTime();
            double t = -this.parkingCharge.storedAmount;
            System.out.print("You have To Pay Exit Amount ");
            this.parkingCharge.printTheCashInTheirCurrency(this.parkingCharge.inrToGiven(amountToBePaid));
            double total;
            if (t > 0) {
                System.out.print(" You Want To Pay Entry Fee Balance ");
                this.parkingCharge.printTheCashInTheirCurrency(this.parkingCharge.inrToGiven(t));
                total = amountToBePaid + t;
                System.out.println("Total :");
                DecimalFormat df = new DecimalFormat("##.##");
                this.parkingCharge.printTheCashInTheirCurrency(this.parkingCharge.inrToGiven(total));
                System.out.println("Pay the total fee");
                double paidTemp=myin.nextDouble();
                System.out.println("Transition in progress. Please Wait...");
                if (inrToGiven(total)==Double.parseDouble(df.format(paidTemp))) {
                    System.out.println("You had Paid Completly :)");
                } 
                else if(inrToGiven(total)>Double.parseDouble(df.format(paidTemp)))
                {
System.out.println("You had Paid More Amount");
System.out.println("We Will Use It has Donation fee");
                }
                else {System.out.println("You had Not Paid Complete Amount");}
            } else if (t == 0) {

            } else {
                if (amountToBePaid > this.parkingCharge.storedAmount) {
                    total = amountToBePaid - this.parkingCharge.storedAmount;
                    System.out.print("But after Reduction You Have To Pay ");
                    this.parkingCharge.printTheCashInTheirCurrency(this.parkingCharge.inrToGiven(total));
                    System.out.println("Pay the total fee");
                    String temp2 = myin.nextLine();
                    if (isFirstIsEqualToSecond(total,temp2)) {
                        System.out.println("Transition in progress. Please Wait...");
                    } else if (Double.parseDouble(temp2) < total) {
                        System.out.println("You had not paid the total fee Please pay the rest amount. Thank You!");
                    } else {
                        System.out.println(
                                "You had Paid more Amount -We will Take The Extra Money as Donation For HandiCap");
                        this.storedAmount = Double.parseDouble(temp2)-total;
                    }
                } else if (amountToBePaid == this.parkingCharge.storedAmount) {
                    System.out.println("You need Not to Pay exit Fee");
                } else {
                    total = this.parkingCharge.storedAmount-amountToBePaid;
                    System.out.println("You had Paid More Amount At Entry Point and You Can Collect Your Money here");
                    System.out.println("The Amount You Need to Take Back is: ");
                    this.parkingCharge.printTheCashInTheirCurrency(this.parkingCharge.inrToGiven(total));
                    System.out.println("\nDear User, We also Run a Charity Program for Handicapped people. Please Choose One option:\nType Y-> I Wish to Take My Money Back   N-> I Wish To Donate this Money For Differently abled People");
                    if (myin.nextLine().toLowerCase().equals("y")) {

                    } else {
                        System.out.println("\nWe Really Appreciate Your Decision");
                    }
                }
            }
            System.out.println("\nYou Can Take Your Vehicle\nThank You. We hope You Enjoyed our Service!\n\n");
            this.isCarParked = false;
            Floor.oneSpaceAddedNotFor(this.psType, this.floorParked);
            this.isCheckExit = false;
        } else {
            System.out.println("Give Your three-digit Code at Exit Check Point To Take Car");
        }

    }

    public void checkExit(Scanner myin) {
        System.out.println("To Take Your Car -Enter the Three digit Pin code Send To Your Mail");
        myin.nextLine();
        while (noOfTrails>0) {
            String password = myin.nextLine();
            if (Double.parseDouble(password)==this.parkingCharge.threeDigitCode) {
                isCheckExit = true;
                System.out.println("Verification Successful\n\n");
                return;
            } else {
                noOfTrails--;
                System.out.println("Try Again!");
            }
        }
        System.out.println(" --- More than Three trials had been tried !");
        isCheckExit=false;
        noOfTrails=3;
        System.exit(0);
    }

    public double getAmountWRTTime() {
        if (noOfHourSpend < 2 && noOfHourSpend >= 1) {
            amountToBePaid += firstHour;
        } else if (noOfHourSpend < 3 && noOfHourSpend >= 2) {
            amountToBePaid += (firstHour + secondHour);
        } else if (noOfHourSpend < 1) {
            amountToBePaid += 0;
        } else {
            amountToBePaid += (firstHour + secondHour + thirdHour);
        }
        return amountToBePaid;
    }
    public boolean isFirstIsEqualToSecond(double value,String valueTemp)
    {
       double temp=givenToInr(Double.parseDouble(valueTemp));
       return (temp == value);
    }
}
