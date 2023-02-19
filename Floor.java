import java.util.Scanner;

public class Floor {

    public MaxFloor maxFloorObject = new MaxFloor();
    public int handiCapCount;
    public int compactCount;
    public int largeCount;
    public int motorBikeCount;
    public int electricCount;
    public int ambulanceCount;
    public int fireEngineCount;

    public boolean isHandiCapFree() {
        return (maxFloorObject.getHandiCapMaxCount() != this.handiCapCount);
    }

    public boolean isCompactFree() {
        return (maxFloorObject.getCompactMaxCount() != this.compactCount);
    }

    public boolean isLargeFree() {
        return (maxFloorObject.getLargeMaxCount() != this.largeCount);
    }

    public boolean isElectricFree() {
        return (maxFloorObject.getElectricMaxCount() != this.electricCount);
    }

    public boolean isAmbulanceFree() {
        return (maxFloorObject.getAmbulanceMaxCount() != this.ambulanceCount);
    }

    public boolean isFireEngineFree() {
        return (maxFloorObject.getFireEngineMaxCount() != this.fireEngineCount);
    }

    public boolean isMotorBikeFree() {
        return (maxFloorObject.getMotorBikeMaxCount() != this.motorBikeCount);
    }

    public boolean isFreeFor(ParkingSpotRequired object) {
        if (object == ParkingSpotRequired.AMBULANCE) {
            return this.isAmbulanceFree();
        } else if (object == ParkingSpotRequired.COMPACT) {
            return this.isCompactFree();
        } else if (object == ParkingSpotRequired.ELECTRIC) {
            return this.isElectricFree();
        } else if (object == ParkingSpotRequired.FIREENGINE) {
            return this.isFireEngineFree();
        } else if (object == ParkingSpotRequired.HANDICAPPED) {
            return this.isHandiCapFree();
        } else if (object == ParkingSpotRequired.LARGE) {
            return this.isLargeFree();
        } else if (object == ParkingSpotRequired.MOTORBIKE) {
            return this.isMotorBikeFree();
        }
        return false;
    }

    static void isAnyFloorFreeForType(ParkingSpotRequired obj) {
        for (int i = 0; i < Admin.noOfFloors; i++) {
            if (Admin.floorObject[i].isFreeFor(obj)) {
                Admin.showSpacesArray[i] = 1;
            } else {
                Admin.showSpacesArray[i] = 0;
            }
        }
    }

    private static void setNoOfFloors(Scanner myin) {
        if (Admin.isMaster) {
            System.out.println("Enter the NumbeR of Floors :");
            Admin.noOfFloors = myin.nextInt();
        } else {
            System.out.println("You Don't Have Access to Floors");
        }
    }

    public static void setMaxCountForAllFloorsWithInitilations(Scanner myin) {
        setNoOfFloors(myin);
        Admin.floorObject = new Floor[Admin.noOfFloors];
        Admin.showSpacesArray = new int[Admin.noOfFloors];
        for (int i = 0; i < Admin.noOfFloors; i++) {
            Admin.floorObject[i] = new Floor();
            Admin.floorObject[i].maxFloorObject.setMaxCount(myin);
        }
    }

    public static void setMaxCountForThis(int Number, Scanner myin) {
        Admin.floorObject[Number] = new Floor();
        Admin.floorObject[Number].maxFloorObject.setMaxCount(myin);
    }

    static void oneSpaceAddedFor(ParkingSpotRequired object, int FloorNumber) {
        if (object == ParkingSpotRequired.AMBULANCE) {
            Admin.floorObject[FloorNumber].ambulanceCount++;
        } else if (object == ParkingSpotRequired.COMPACT) {
            Admin.floorObject[FloorNumber].compactCount++;
        } else if (object == ParkingSpotRequired.ELECTRIC) {
            Admin.floorObject[FloorNumber].electricCount++;
        } else if (object == ParkingSpotRequired.FIREENGINE) {
            Admin.floorObject[FloorNumber].fireEngineCount++;
        } else if (object == ParkingSpotRequired.HANDICAPPED) {
            Admin.floorObject[FloorNumber].handiCapCount++;
        } else if (object == ParkingSpotRequired.LARGE) {
            Admin.floorObject[FloorNumber].largeCount++;
        } else if (object == ParkingSpotRequired.MOTORBIKE) {
            Admin.floorObject[FloorNumber].motorBikeCount++;
        }
    }

    static void oneSpaceAddedNotFor(ParkingSpotRequired object, int FloorNumber) {
        if (object == ParkingSpotRequired.AMBULANCE) {
            Admin.floorObject[FloorNumber].ambulanceCount--;
        } else if (object == ParkingSpotRequired.COMPACT) {
            Admin.floorObject[FloorNumber].compactCount--;
        } else if (object == ParkingSpotRequired.ELECTRIC) {
            Admin.floorObject[FloorNumber].electricCount--;
        } else if (object == ParkingSpotRequired.FIREENGINE) {
            Admin.floorObject[FloorNumber].fireEngineCount--;
        } else if (object == ParkingSpotRequired.HANDICAPPED) {
            Admin.floorObject[FloorNumber].handiCapCount--;
        } else if (object == ParkingSpotRequired.LARGE) {
            Admin.floorObject[FloorNumber].largeCount--;
        } else if (object == ParkingSpotRequired.MOTORBIKE) {
            Admin.floorObject[FloorNumber].motorBikeCount--;
        }
    }

    public static void showPresentCount(int Number) {
        System.out.println("HandiCap  Count     " + Admin.floorObject[Number].handiCapCount + " Filled out of "
                + Admin.floorObject[Number].maxFloorObject.getHandiCapMaxCount());
        System.out.println("Large  Count        " + Admin.floorObject[Number].largeCount + " Filled out of "
                + Admin.floorObject[Number].maxFloorObject.getLargeMaxCount());
        System.out.println("Compact  Count      " + Admin.floorObject[Number].compactCount + " Filled out of "
                + Admin.floorObject[Number].maxFloorObject.getCompactMaxCount());
        System.out.println("Motor Bike  Count   " + Admin.floorObject[Number].motorBikeCount + " Filled out of "
                + Admin.floorObject[Number].maxFloorObject.getMotorBikeMaxCount());
        System.out.println("Ambulance  Count    " + Admin.floorObject[Number].ambulanceCount + " Filled out of "
                + Admin.floorObject[Number].maxFloorObject.getAmbulanceMaxCount());
        System.out.println("Electric  Count     " + Admin.floorObject[Number].electricCount + " Filled out of "
                + Admin.floorObject[Number].maxFloorObject.getElectricMaxCount());
        System.out.println("Fire-Engine  Count  " + Admin.floorObject[Number].fireEngineCount + " Filled out of "
                + Admin.floorObject[Number].maxFloorObject.getFireEngineMaxCount());
    }

    public static void showAllPresentCount() {
        for (int i = 0; i < Admin.noOfFloors; i++) {
            int temp = i + 1;
            System.out.println("Present Count of Floor " + temp + ":");
            showPresentCount(i);
        }
    }
}