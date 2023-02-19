import java.util.Scanner;

//make a isAdmin boolean value and its value must be changed by calling a method in admin class 
public class ChangeParkingFee extends Admin {
    static private double compactParkFee = 30.00;
    static private double largeParkFee = 40.00;
    static private double handiCapParkFee = 10.00;
    static private double motorBikeParkFee = 20.00;
    static private double electricParkFee = 25.00;
    static private double ambulanceParkFee = 0;
    static private double fireEngineParkFee = 0;
    static private double valid = 1;
    static private double expiried = 2;
    static public double donationCash;

    public static void toChangeMotorBikeParkFee(Scanner myin) {
        if (isMaster) {
            System.out.println("Enter the Motor Bike Park Fee");
            motorBikeParkFee = myin.nextDouble();
        } else {
            System.out.println("You Don't have the Permission to change the Motor Bike Park Fee");
        }
    }

    public static void toChangeCompactParkFee(Scanner myin) {
        if (isMaster) {
            System.out.println("Enter the Compact Vehicle Park Fee");
            compactParkFee = myin.nextDouble();
        } else {
            System.out.println("You Don't have the Permission to change the Compact Vehicle Park Fee");
        }
    }

    public static void toChangeLargeParkFee(Scanner myin) {
        if (isMaster) {
            System.out.println("Enter the Large Vehicle Park Fee");
            largeParkFee = myin.nextDouble();
        } else {
            System.out.println("You Don't have the Permission to change the Large Vehicle Park Fee");
        }
    }

    public static void toChangeElectricParkFee(Scanner myin) {
        if (isMaster) {
            System.out.println("Enter the Electric Bike Park Fee");
            electricParkFee = myin.nextDouble();
        } else {
            System.out.println("You Don't have the Permission to change the Electric Bike Park Fee");
        }
    }

    public static void toChangeAmbulanceParkFee(Scanner myin) {
        if (isMaster) {
            System.out.println("Enter the Ambulance Park Fee");
            ambulanceParkFee = myin.nextDouble();
            myin.nextLine();
        } else {
            System.out.println("You Don't have the Permission to change the Ambulance Park Fee");
        }
    }

    public static void toChangeFireEngineParkFee(Scanner myin) {
        if (isMaster) {
            System.out.println("Enter the Fire-Engine Park Fee");
            fireEngineParkFee = myin.nextDouble();
        } else {
            System.out.println("You Don't have the Permission to change the Fire-Engine Park Fee");
        }
    }
    public static void toChangeHandiCapParkFee(Scanner myin) {
        if (isMaster) {
            System.out.println("Enter the Handi-Cap Park Fee");
            handiCapParkFee= myin.nextDouble();
        } else {
            System.out.println("You Don't have the Permission to change the Handi-Cap Park Fee");
        }
    }

    public double giveDoubleAccToVehicleType(ParkingSpotRequired parkRequired) {
        if (parkRequired == ParkingSpotRequired.COMPACT) {
            return compactParkFee;
        } else if (parkRequired == ParkingSpotRequired.LARGE) {
            return largeParkFee;
        } else if (parkRequired == ParkingSpotRequired.HANDICAPPED) {
            if (handiCapParkFee > donationCash) {
                double temp = donationCash;
                donationCash = 0;
                return handiCapParkFee - temp;
            } else {
                donationCash -= handiCapParkFee;
                return 0.0;
            }
        } else if (parkRequired == ParkingSpotRequired.MOTORBIKE) {
            return motorBikeParkFee;
        } else if (parkRequired == ParkingSpotRequired.AMBULANCE) {
            return ambulanceParkFee;
        } else if (parkRequired == ParkingSpotRequired.FIREENGINE) {
            return fireEngineParkFee;
        } else if (parkRequired == ParkingSpotRequired.ELECTRIC) {
            return electricParkFee;
        }
        return 0.00;
    }

    public double getRate(ParkingSpotRequired parkRequired, LicenseStatus licenseType) {
        if (licenseType == LicenseStatus.ACTIVE) {
            return giveDoubleAccToVehicleType(parkRequired) * valid;
        } else if ((licenseType == LicenseStatus.BANNED) || (licenseType == LicenseStatus.EXPIRED)
                || (licenseType == LicenseStatus.NOLICENSE)) {
            return giveDoubleAccToVehicleType(parkRequired) * expiried;
        }
        return 0.00;
    }
}
