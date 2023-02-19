import java.util.Scanner;

/**
 * @author NISHANTH
 *
 */
public class UserQuery extends MaxParkingSpot {
    public static void getQuery(Scanner myin, ExitPoint obj) {
        System.out.println("Enter The Query: ");
        myin.nextLine();
        String temp = (myin.nextLine()).toLowerCase();
        if (temp.matches("(.*change.*)|(.*changes.*)|(.*switch.*)|(.*interchange.*)")) {
            if (temp.matches("(.*country.*)")) {
                System.out.println("We have Guessed That You Want To Change Your Country\n");
                obj.getCountry(myin);
            } else if (temp.matches("(.*state.*)")) {
                System.out.println("We have Guessed That You Want To Change Your State\n");
                obj.getState(myin);
            } else if (temp.matches("(.*city.*)")) {
                System.out.println("We have Guessed That You Want To Change Your City\n");
                obj.getCity(myin);
            } else if (temp.matches("(.*zipcode.*)")) {
                System.out.println("We have Guessed That You Want To Change Your Zip Code\n");
                obj.getZipCode(myin);
            } else if (temp.matches("(.*street.*(town)?)")) {
                System.out.println("We have Guessed That You Want To Change Your Street Details\n");
                obj.getOtherDetails(myin);
            } else if (temp.matches("(.*phone ?Number.*)")) {
                System.out.println("We have Guessed That You Want To Change Your Phone Number\n");
                obj.getPhoneNumber(myin);
            } else {
                System.out.println("Invalid Process Data");
            }
        } else if (temp.matches("(.*see.*)|(.*look.*)|(.*glance.*)|(.*know.*)|(.*view.*)|(.*present.*)|(.*status.*)")) {
            if (temp.matches("(.*country.*)")) {
                System.out.println("We have Guessed That You Want To See Your Country\n");
                System.out.println("The Country You Had Saved is " + MaxParkingSpot.printWithLine(obj.returnCountry()));
            } else if (temp.matches("(.*state.*)")) {
                System.out.println("We have Guessed That You Want To See Your State\n");
                System.out.println("The State You Had Saved is " + MaxParkingSpot.printWithLine(obj.returnState()));
            } else if (temp.matches("(.*city.*)")) {
                System.out.println("We have Guessed That You Want To See Your City\n");
                System.out.println("The City You Had Saved is " + printWithLine(obj.returnCity()));
            } else if (temp.matches("(.*zipcode.*)")) {
                System.out.println("We have Guessed That You Want To See Your Zip Code\n");
                System.out.println("The Zip code You Had Saved is " + printWithLine(obj.returnZipCode()));
            } else if (temp.matches("(.*street.*(town)?)")) {
                System.out.println("We have Guessed That You Want To See Street Details\n");
                System.out.println("The Street details You Had Saved is " + printWithLine(obj.returnPersonalDetails()));
            } else if (temp.matches("(.*phone ?Number.*)")) {
                System.out.println("We have Guessed That You Want To See Your Phone Number\n");
                System.out.println("The Phone Number You Had Saved is " + printWithLine(obj.returnPhoneNumber()));
            } else if (temp.matches("(.*license.*)")) {
                System.out.println("We have Guessed That You Want To See Your License Status\n");
                System.out.println("The License Status You Had Saved is " + printWithLine(obj.Ltype.toString()));
            } else if (temp.matches("(.*cash ?medium.*)|(.*type ?of ?transaction.*)")) {
                System.out.println("We have Guessed That You Want To See Your Type of Money Transaction Used\n");
                System.out.println("The Used Transaction is " + printWithLine(obj.cardType.toString()));
            } else if (temp.matches("(.*currency.*)")) {
                System.out.println("We have Guessed That You Want To See Type Of Currency Used\n");
                System.out.println("The Currecny Type  You Used is " + printWithLine(obj.typeOfCurrency.toString()));
            } else {
                System.out.println("Invalid Process Data");
            }
        } else if (temp.matches("(.*admin.*)|(.*master.*)")) {
            System.out.println("We have Guessed that you Want to Login As Admin");
            Admin.setMaster(myin);
        } else if (temp.matches("(.*floor.*)")) {

            if (temp.matches("(.*present ?count.*)")) {
                if (temp.matches("(.*all.*)")) {
                    Floor.showAllPresentCount();
                } else {
                    System.out.println("We have Guessed That You need to See present Status of a Particular Floor");
                    System.out.println("Enter The floor Number ");
                    Floor.showPresentCount(myin.nextInt());
                }

            } else if (temp.matches("(.*max.*)")) {
                if (temp.matches("(.*all.*)")) {
                    MaxFloor.showMaxCountForAllFloors();
                } else {
                    System.out.println("We have Guessed That You need to See Max Status of a Particular Floor");
                    System.out.println("Enter The floor Number ");
                    MaxFloor.showMaxCount(myin.nextInt());
                }
            } else if (temp.matches("(.*number ?of.*)")) {
                System.out.println("Total Number Of Floors" + Admin.noOfFloors);
            }

        }

        else {
            System.out.println("Invalid Process Data. Try Again!");
        }

    }

    public static void adminOptions() {
        System.out.println("Press  1: To Send Mail To Customer");
        System.out.println("Press  2: To initialize All Floors ");
        System.out.println("Press  3: To See All Vehicles Available to Park");
        System.out.println("Press  4: To See Types Of Parking Slots Available");
        System.out.println("Press  5: To See Type Of Currency Available");
        System.out.println("Press  6: To Set Max Count For Floor Number");
        System.out.println("Press  7: To See Present Count Of All Floors Available");
        System.out.println("Press  8: To See Max Count Of All Floors Available");
        System.out.println("Press  9: To Change Park Fee for " + ParkingSpotRequired.AMBULANCE);
        System.out.println("Press  10: To Change Park Fee for " + ParkingSpotRequired.COMPACT);
        System.out.println("Press  11: To Change Park Fee for " + ParkingSpotRequired.ELECTRIC);
        System.out.println("Press  12: To Change Park Fee for " + ParkingSpotRequired.FIREENGINE);
        System.out.println("Press  13: To Change Park Fee for " + ParkingSpotRequired.HANDICAPPED);
        System.out.println("Press  14: To Change Park Fee for " + ParkingSpotRequired.LARGE);
        System.out.println("Press  15: To Change Park Fee for " + ParkingSpotRequired.MOTORBIKE);
    }

    private static void switchForAdminOptions(int Option, Scanner myin) {
        switch (Option) {
            case 1:
                System.out.println("Enter The Body ");
                System.out.println("You Can End The Paragraph Using the Word -> password:admin");
                String Body = "";
                String s;
                while (myin.hasNextLine()) {
                    s = myin.nextLine();
                    if (s.equals("password:admin")) {
                        break;
                    }
                    Body += (s + "\n");
                }
                System.out.println("Enter the Mail ID of Person who You Need To Sent");
                String to = myin.nextLine();
                Person.sendMailWithAdminBody(to, Body);
                break;
            case 2:
                Floor.setMaxCountForAllFloorsWithInitilations(myin);
                break;
            case 3:
                System.out.println("1) " + VehicleType.AMBULANCE);
                System.out.println("2) " + VehicleType.CAR);
                System.out.println("3) " + VehicleType.ELECTRIC);
                System.out.println("4) " + VehicleType.FIREENGINE);
                System.out.println("5) " + VehicleType.MOTORBIKE);
                System.out.println("6) " + VehicleType.TRUCK);
                System.out.println("7) " + VehicleType.VAN);
                break;
            case 4:
                System.out.println("1) " + ParkingSpotRequired.AMBULANCE);
                System.out.println("2) " + ParkingSpotRequired.COMPACT);
                System.out.println("3) " + ParkingSpotRequired.ELECTRIC);
                System.out.println("4) " + ParkingSpotRequired.FIREENGINE);
                System.out.println("5) " + ParkingSpotRequired.MOTORBIKE);
                System.out.println("6) " + ParkingSpotRequired.HANDICAPPED);
                System.out.println("7) " + ParkingSpotRequired.LARGE);
                break;
            case 5:
                System.out.println("1) " + TypeOfCurrency.DOLLAR);
                System.out.println("2) " + TypeOfCurrency.EURO);
                System.out.println("3) " + TypeOfCurrency.POUND);
                System.out.println("4) " + TypeOfCurrency.RUPEES);
                System.out.println("5) " + TypeOfCurrency.YEN);
            case 6:
                System.out.println("Enter The Number Of Floor");
                MaxFloor.showMaxCount(myin.nextInt());
                break;
            case 7:
                Floor.showAllPresentCount();
                break;
            case 8:
                MaxFloor.showMaxCountForAllFloors();
                break;
            case 9:
                ChangeParkingFee.toChangeAmbulanceParkFee(myin);
                break;
            case 10:
                ChangeParkingFee.toChangeCompactParkFee(myin);
                break;
            case 11:
                ChangeParkingFee.toChangeElectricParkFee(myin);
                break;
            case 12:
                ChangeParkingFee.toChangeFireEngineParkFee(myin);
                break;
            case 13:
                ChangeParkingFee.toChangeHandiCapParkFee(myin);
                break;
            case 14:
                ChangeParkingFee.toChangeLargeParkFee(myin);
                break;
            case 15:
                ChangeParkingFee.toChangeMotorBikeParkFee(myin);
                break;
            default:
                System.out.println("Out Of Range");
        }
    }

    public static void adminQuery(Scanner myin) {
        adminOptions();
        System.out.println("Enter The Option");
        switchForAdminOptions(myin.nextInt(), myin);
    }
}
