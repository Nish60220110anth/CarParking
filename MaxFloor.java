import java.util.Scanner;

public class MaxFloor {
    private int handicapMaxCount;
    private int compactMaxCount;
    private int largeMaxCount;
    private int motorBikeMaxCount;
    private int electricMaxCount;
    private int ambulanceMaxCount;
    private int fireengineMaxCount;

    public void setHandiCapMaxCount(Scanner myin) {
        if (Admin.isMaster) {
            System.out.println("Enter the Handi Cap Maximum Count");
            handicapMaxCount = myin.nextInt();
        } else {
            System.out.println("You Can't Change HandiCap Maximum Count");
        }
    }

    public void setCompactMaxCount(Scanner myin) {
        if (Admin.isMaster) {
            System.out.println("Enter the Compact Vehicles Maximum Count");
            compactMaxCount = myin.nextInt();
        } else {
            System.out.println("You Can't Change Compact Vehicles Maximum Count");
        }
    }

    public void setLargeMaxCount(Scanner myin) {
        if (Admin.isMaster) {
            System.out.println("Enter the Large Vehicles Maximum Count");
            largeMaxCount = myin.nextInt();
        } else {
            System.out.println("You Can't Change Large Vehicles  Maximum Count");
        }
    }

    public void setMotorBikeMaxCount(Scanner myin) {
        if (Admin.isMaster) {
            System.out.println("Enter the Motor Bike Vehicles Maximum Count");
            motorBikeMaxCount = myin.nextInt();
        } else {
            System.out.println("You Can't Change Motor Bike Vehicles Maximum Count");
        }
    }

    public void setElectricMaxCount(Scanner myin) {
        if (Admin.isMaster) {
            System.out.println("Enter the Electric Vehicle Maximum Count");
            electricMaxCount = myin.nextInt();
        } else {
            System.out.println("You Can't Change Electric Vehicle Maximum Count");
        }
    }

    public void setAmbulanceMaxCount(Scanner myin) {
        if (Admin.isMaster) {
            System.out.println("Enter the Ambulance Vehicles Maximum Count");
            ambulanceMaxCount = myin.nextInt();
        } else {
            System.out.println("You Can't Change Ambulance Vehicles Maximum Count");
        }
    }

    public void setFireEngineMaxCount(Scanner myin) {
        if (Admin.isMaster) {
            System.out.println("Enter the Fire Engine Vehicles Maximum Count");
            fireengineMaxCount = myin.nextInt();
        } else {
            System.out.println("You Can't Change Fire Engine Vehicles Maximum Count");
        }
    }

    public int getHandiCapMaxCount() {
        if (Admin.isMaster) {
            return handicapMaxCount;
        } else {
            System.out.println("You Can't Get HandiCap Maximum Count");
            return -1;
        }
    }

    public int getCompactMaxCount() {
        if (Admin.isMaster) {
            return compactMaxCount;
        } else {
            System.out.println("You Can't Get Compact Vehicles Maximum Count");
            return -1;
        }
    }

    public int getLargeMaxCount() {
        if (Admin.isMaster) {
            return largeMaxCount;
        } else {
            System.out.println("You Can't Get Large Vehicles  Maximum Count");
            return -1;
        }
    }

    public int getMotorBikeMaxCount() {
        if (Admin.isMaster) {
            return motorBikeMaxCount;
        } else {
            System.out.println("You Can't Get Motor Bike Vehicles Maximum Count");
            return -1;
        }
    }

    public int getElectricMaxCount() {
        if (Admin.isMaster) {
            return electricMaxCount;
        } else {
            System.out.println("You Can't Get Electric Vehicle Maximum Count");
            return -1;
        }
    }

    public int getAmbulanceMaxCount() {
        if (Admin.isMaster) {
            return ambulanceMaxCount;
        } else {
            System.out.println("You Can't Get Ambulance Vehicles Maximum Count");
            return -1;
        }
    }

    public int getFireEngineMaxCount() {
        if (Admin.isMaster) {
            return fireengineMaxCount;
        } else {
            System.out.println("You Can't Get Fire Engine Vehicles Maximum Count");
            return -1;
        }
    }

    public void setMaxCount(Scanner myin) {
        if (Admin.isMaster) {
            this.setHandiCapMaxCount(myin);
            this.setCompactMaxCount(myin);
            this.setLargeMaxCount(myin);
            this.setMotorBikeMaxCount(myin);
            this.setElectricMaxCount(myin);
            this.setAmbulanceMaxCount(myin);
            this.setFireEngineMaxCount(myin);
        } else {
            System.out.println("You Can't Change Maximum Count");
        }
    }

    public static void showMaxCount(int Number) {
        int temp = Number + 1;
        System.out.println("Maximum Count for Floor Number " + temp + ":");
        System.out.println(
                "HandiCap Maximum Count        " + Admin.floorObject[Number].maxFloorObject.getHandiCapMaxCount());
        System.out.println(
                "Large Maximum Count           " + Admin.floorObject[Number].maxFloorObject.getLargeMaxCount());
        System.out.println(
                "Compact Maximum Count         " + Admin.floorObject[Number].maxFloorObject.getCompactMaxCount());
        System.out.println(
                "Motor Bike Maximum Count      " + Admin.floorObject[Number].maxFloorObject.getMotorBikeMaxCount());
        System.out.println(
                "Ambulance Maximum Count       " + Admin.floorObject[Number].maxFloorObject.getAmbulanceMaxCount());
        System.out.println(
                "Electric Maximum Count        " + Admin.floorObject[Number].maxFloorObject.getElectricMaxCount());
        System.out.println(
                "Fire-Engine Maximum Count     " + Admin.floorObject[Number].maxFloorObject.getFireEngineMaxCount());
    }

    public static void showMaxCountForAllFloors() {
        System.out.println("\n");
        for (int i = 0; i < Admin.noOfFloors; i++) {
            showMaxCount(i);
            System.out.println("");

        }
        System.out.println("\n");

    }

}
