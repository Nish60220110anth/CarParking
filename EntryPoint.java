import java.util.Scanner;

//import java.time.Instant;
public class EntryPoint extends Person implements interfaceForEntry {
    public int Id;
    public ParkingCharge parkingCharge = new ParkingCharge();
    public Person person = new Person();
    public VehicleType vType;
    public ParkingSpotRequired psType;
    public LicenseStatus Ltype;
    public boolean isCarParked = false;
    public int floorParked;
    public double start;

    public void startPortal(Scanner myin) {
        if (isCarParked == true) {
            System.out.println("Please Go to Exit Portal To Take Your Vehicle");
        } else {
            System.out.println("\nDear Customer, Do You Wish To Proceed Further for registration?");
            System.out.println("Please Enter Yes/No ( yes/no/y/n also valid )");
            myin.nextLine();
            String temp = myin.nextLine().toLowerCase();
            if (temp.matches("(.*yes.*)|(.*y.*)")) {
                getData(myin);
                isFreeFloor(psType, myin);
                parkingCharge.getMoney(psType, Ltype, myin);
                this.sendMailRegistration();
                System.out.println("Dear User, a Confirmation Mail is Sent To Your Mail");
                System.out.println("Please Use the Credentials Shared in the Mail at Exit Point");
            } else {
                Admin.main(null);}}}
    public void isFreeFloor(ParkingSpotRequired obj, Scanner myin) {
        Floor.isAnyFloorFreeForType(obj);/* to create the showSpacesArray */
        for (int i=0;i<Admin.noOfFloors;i++) {
            if (Admin.showSpacesArray[i] == 1) {
                int temp = i + 1;
                System.out.println("Floor Number: " +temp+" Is Free To Park");
            } else if (i == Admin.noOfFloors - 1) {
                System.out.println("Sorry Currently No Floors Available");
                System.exit(0);
            }
        }
        System.out.println("Enter The Floor Number -You Need To Park");
        int floorNumber = myin.nextInt();
        this.floorParked=(floorNumber-1);
        Floor.oneSpaceAddedFor(obj, floorParked);
        for (int i = 0; i < Admin.noOfFloors; i++) {Admin.showSpacesArray[i] = 0;}
        this.start = System.nanoTime();
        this.isCarParked = true;
        System.out.println("Your Car have been Parked Successfully");}
    private void getData(Scanner myin) {
        System.out.println("Enter your Driving License ID: ");
        Id = myin.nextInt();
        this.person.getPersonDetails(myin);
        System.out.println("Enter the Vehicle Type You Need To Park");
        displayVehicleType();
        int a = myin.nextInt();
        switchForVehicleType(a);
        System.out.println("Enter the Parking Area Type  You Need To Park");
        displayParkingSpotInfo();
        int a1 = myin.nextInt();
        switchForParking(a1);
        System.out.println("Enter the Driving License Status");
        displayLicenseStatus();
        int status = myin.nextInt();
        switchForLicenseStatus(status);
        checkBasicRequirements(psType, vType);
    }
    public void showData() {
        System.out.println("Your Id is: "+Id);
        this.person.showPersonDetails();
    }
    public void showTransactionData() {this.parkingCharge.transactionDetails();}
    public void sendMailRegistration() {Person.sendMail(person, parkingCharge.threeDigitCode);}
    public void checkBasicRequirements(ParkingSpotRequired a1, VehicleType a2) {
        if (person.isHandiCap&&((a2==VehicleType.AMBULANCE)||(a2==VehicleType.FIREENGINE))) {
            System.out.println("Sorry -Your Providing Wrong Information ");
            System.out.println("Physically Disabled Persons Can't Drive Ambulance or Fire-Engine");
            System.exit(0);} 
        else if (person.isHandiCap&& ((a1 == ParkingSpotRequired.AMBULANCE) || (a1 == ParkingSpotRequired.FIREENGINE))) 
        {
            System.out.println("Sorry Sir -Your Providing Wrong Information :(");
            System.out.println("Physically Disabled Persons Can't Drive Ambulance or Fire-Engine");
            System.exit(0);
        } 
        else if ((a1==ParkingSpotRequired.HANDICAPPED)&&(this.person.isHandiCap==false)) {
            System.out.println("Please Be loyal ");
            System.exit(0);
        } 
        else if (this.person.isHandiCap==true&&a1!=ParkingSpotRequired.HANDICAPPED) {
            System.out.println("Sir You have Chosen Wrong Option -We will Change Parking Spot Required For You");
            this.psType = ParkingSpotRequired.HANDICAPPED;}}
    public void switchForVehicleType(int a) {
        switch (a) {
            case 1:
                this.vType = VehicleType.CAR;break;
            case 2:
                this.vType = VehicleType.TRUCK;break;
            case 3:
                this.vType = VehicleType.VAN;break;
            case 4:
                this.vType = VehicleType.MOTORBIKE;break;
            case 5:
                this.vType = VehicleType.ELECTRIC;break;
            case 6:
                this.vType = VehicleType.AMBULANCE;break;
            case 7:
                this.vType = VehicleType.FIREENGINE;break;
            default:
                System.out.println("You have Entered the Number Which is Out of Bound");
                System.exit(0);
        }
    }

    public void switchForParking(int a1) {
        switch (a1) {
            case 1:
                this.psType = ParkingSpotRequired.COMPACT;
                break;
            case 2:
                this.psType = ParkingSpotRequired.LARGE;
                break;
            case 3:
                this.psType = ParkingSpotRequired.HANDICAPPED;
                break;
            case 4:
                this.psType = ParkingSpotRequired.MOTORBIKE;
                break;
            case 5:
                this.psType = ParkingSpotRequired.ELECTRIC;
                break;
            case 6:
                this.psType = ParkingSpotRequired.AMBULANCE;
                break;
            case 7:
                this.psType = ParkingSpotRequired.FIREENGINE;
                break;
            default:
                System.out.println("You have Entered the Number Which is Out of Bound");
        }
    }

    public void switchForLicenseStatus(int status) {
        switch (status) {
            case 1:
                this.Ltype = LicenseStatus.ACTIVE;
                break;
            case 2:
                this.Ltype = LicenseStatus.BANNED;
                break;
            case 3:
                this.Ltype = LicenseStatus.EXPIRED;
                break;
            case 4:
                this.Ltype = LicenseStatus.NOLICENSE;
                break;
            default:
                System.out.println("You have Entered the Number Which is Out of Bound");
        }
    }

    public void displayVehicleType() {
        System.out.println("Press 1: " + VehicleType.CAR.toString());
        System.out.println("Press 2: " + VehicleType.TRUCK.toString());
        System.out.println("Press 3: " + VehicleType.VAN.toString());
        System.out.println("Press 4: " + VehicleType.MOTORBIKE.toString());
        System.out.println("Press 5: " + VehicleType.ELECTRIC.toString());
        System.out.println("Press 6: " + VehicleType.AMBULANCE.toString());
        System.out.println("Press 7: " + VehicleType.FIREENGINE.toString());
    }

    public void displayParkingSpotInfo() {
        System.out.println("Press 1: " + ParkingSpotRequired.COMPACT.toString());
        System.out.println("Press 2: " + ParkingSpotRequired.LARGE.toString());
        System.out.println("Press 3: " + ParkingSpotRequired.HANDICAPPED.toString());
        System.out.println("Press 4: " + ParkingSpotRequired.MOTORBIKE.toString());
        System.out.println("Press 5: " + ParkingSpotRequired.ELECTRIC.toString());
        System.out.println("Press 6: " + ParkingSpotRequired.AMBULANCE.toString());
        System.out.println("Press 7: " + ParkingSpotRequired.FIREENGINE.toString());
    }

    public void displayLicenseStatus() {
        System.out.println("Press 1: " + LicenseStatus.ACTIVE.toString());
        System.out.println("Press 2: " + LicenseStatus.BANNED.toString());
        System.out.println("Press 3: " + LicenseStatus.EXPIRED.toString());
        System.out.println("Press 4: " + LicenseStatus.NOLICENSE.toString());
    }
}
