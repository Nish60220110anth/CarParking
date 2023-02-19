public class MaxParkingSpot extends ParkingCharge {
    public static String printWithLine(String a1) {
        return String.join("\u0332", a1.split("", -1));
    }

    public static int compactSpotCount;
    public static int largeSpotCount;
    public static int handiCapSpotCount;
    public static int motorCycleSpotCount;
    public static int electricSpotCount;
    public static int maxHandiCapCount;
    public static int maxCompactCount;
    public static int maxLargeCount;
    public static int maxMotorCycleCount;
    public static int maxElectricCount;

    public boolean isHandiCapFree() {
        return (handiCapSpotCount < maxHandiCapCount);
    }

    public boolean isCompactFree() {
        return (compactSpotCount < maxCompactCount);
    }

    public boolean isMotorCycle() {
        return (motorCycleSpotCount < maxMotorCycleCount);
    }

    public boolean isLargeFree() {
        return (largeSpotCount < maxLargeCount);
    }

    public boolean isElectricFree() {
        return (electricSpotCount < maxElectricCount);
    }

}