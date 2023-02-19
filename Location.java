import java.util.*;

/**
 *
 * @author NISHANTH
 */
public class Location extends MaxParkingSpot {
    private String country;
    private String zipcode;
    private String phoneNumber;
    private String state;
    private String city;
    private String otherDetails;

    public void getAddress(Scanner myin) {
        this.getPhoneNumber(myin);
        this.getCountry(myin);
        this.getState(myin);
        this.getZipCode(myin);
        this.getCity(myin);
        this.getOtherDetails(myin);
    }

    public void getCountry(Scanner myin) {
        System.out.println("Enter Your Country Name used Internationally (Eg: India, France, United Kingdom, United States, Japan, Germany, etc)");
        String temp = myin.nextLine().toLowerCase();
        this.country = temp;
    }

    public void getState(Scanner myin) {
        System.out.println("Enter Your State (String)");
        this.state = myin.nextLine();
    }

    public void getZipCode(Scanner myin) {
        System.out.println("Enter Your Zip Code (Integer)");
        this.zipcode = myin.nextLine();
    }

    public void getCity(Scanner myin) {
        System.out.println("Enter Your City (String)");
        this.city = myin.nextLine();
    }

    public void getPhoneNumber(Scanner myin) {
        System.out.println("Enter Your Phone Number (Must be 10 Digit Integer)");
        this.phoneNumber = myin.nextLine();
    }

    public void getOtherDetails(Scanner myin) {
        System.out.println("Enter Your Street Details (String)");
        this.otherDetails = myin.nextLine();
    }

    public void showAddress() {
        System.out.println("Country :       " + country);
        System.out.println("State :         " + state);
        System.out.println("City :          " + city);
        System.out.println("Zip Code :      " + zipcode);
        System.out.println("Street Details :" + otherDetails);
    }

    public String returnPhoneNumber() {
        return phoneNumber;
    }

    public String returnCountry() {
        return country;
    }

    public String returnState() {
        return state;
    }

    public String returnCity() {
        return city;
    }

    public String returnZipCode() {
        return zipcode;
    }

    public String returnStreetDetails() {
        return otherDetails;
    }
    public static boolean isValidLocation(Location object) {
        if (isAlphabet(object.city) & isAlphabet(object.state) & isAlphabet(object.country)
                & isPhoneNumber(object.phoneNumber) & isNumber(object.zipcode)) {
            return true;
        }
        return false;
    }

    public static boolean isTendigitNumber(long x) {
        int count = 0;
        while (x != 0) {
            count++;
            x = x / 10;
        }
        return (count == 10) ? true : false;
    }

    public static boolean isPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^[0-9]*$")) {
            if (isTendigitNumber(Long.parseLong(phoneNumber))) {
                return true;
            }
        }
        return false;

    }

    public static boolean isNumber(String number) {
        if (number.matches("^[0-9]*$")) {
            return true;
        }
        return false;
    }

    public static boolean isAlphabet(String name) {
        if (name.matches("^[a-zA-Z ]*$")) {
            return true;
        }
        return false;
    }

}
