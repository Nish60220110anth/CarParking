import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Map;
import java.util.TreeMap;

public class Person extends Location {
    private String name;
    private String email;
    private Location address = new Location();
    public boolean isHandiCap = false;

    public void getPersonDetails(Scanner myin) {
        System.out.println("Enter Your Personal Details :");
        this.getName(myin);
        this.address.getAddress(myin);
        this.getEmail(myin);
        this.areYouHandiCap(myin);
        this.checkGivenData();
        System.out.println("Your Data have been Recorded!\n");
    }

    public String countryCodePhoneString() {
        return "+" + getCountryCodeForPhoneNumber(countryCodes(this.address.returnCountry()));
    }

    public void showPersonDetails() {
        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
        this.address.showAddress();
        System.out.println("Phone Number : " + this.address.returnPhoneNumber());
    }

    public String returnPersonalDetails() {
        return "Name : " + this.name + "\nEmail : " + this.email + "\n" + this.returnAddress();
    }

    public String returnPersonalDetailsForMail() {
        return "Name : " + this.name + "<p>Email : " + this.email + "<p>" + this.returnAddress();
    }

    public String returnAddress() {
        return ("<p>Country  : " + address.returnCountry() + "<p>State  : " + address.returnState() + "<p>City  : "
                + address.returnCity() + "<p>Zip Code  : " + address.returnZipCode() + "<p>Phone Number  : "
                + this.countryCodePhoneString() + address.returnPhoneNumber() + "<p>Street Details  : "
                + this.address.returnStreetDetails());
    }

    public void areYouHandiCap(Scanner myin) {
        System.out.println(
                "Can you share With Us whether You Are Handicapped? \nIf You Don't Want To Share With Us Then We Will Consider as False (Default Value)");
        System.out.println("Enter Yes or No ");
        String temp = myin.nextLine().toLowerCase();
        if (temp.matches("(.*yes.*)|(.*true.*)") || temp.equals("yes") || temp.equals("true")
                || temp.matches("(.*y.*)")) {
            this.isHandiCap = true;
        } else {
            this.isHandiCap = false;
        }
    }

    public void getName(Scanner myin) {
        System.out.println("Enter Your Name");
        myin.nextLine();
        name = myin.nextLine();
    }

    public void getEmail(Scanner myin) {
        System.out.println("Enter Your Email \n(You will recieve OTP over this, so Please fill carefully)");
        email = myin.nextLine();
    }

    public static void sendMail(Person obj, int Number) {
        System.out.println("Preparing to Send Email...");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String username = "team10pm.2021@gmail.com";
        String password = "team10@2021";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        Message message = obj.prepareMessage(session, username, obj.email, Number);
        try {
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Email sent successfully to  " + obj.email);
    }

    private Message prepareMessage(Session session, String username, String recepient, int Number) {
        Message message = new MimeMessage(session);
        try {

            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Confirmation E-Mail From Shiva Mall For Your Parking Your Vehicle");
            message.setContent(this.emailBodyForMail() + "" + "<p>The 3-Digit Code Genarated For You is </p>" + Number
                    + "<p>Use This Number At Exit Portal To Get Your Vehicle</p>" + "<html>\n" + "<body>\n" + "\n"
                    + "<a href=\"https://vikaspedia.in/social-welfare/social-awareness/consumer-education/safe-driving/tips-for-safe-driving\">\n"
                    + "Checkout some quick tips for a safer driving!</a>\n" + "\n" + "</body>\n" + "</html>",
                    "text/html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    private String emailBodyForMail() {
        return "<p>Your Email ID had been Registered For The Parking slot in Shiva Mall with Following Details</p>"
                + this.returnPersonalDetailsForMail();
    }

    public static void sendMailWithAdminBody(String to, String Body) {
        System.out.println("Preparing to Send Email...");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String username = "team10pm.2021@gmail.com";
        String password = "team10@2021";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        Message message = prepareMessage(session, username, to, Body);
        try {
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Email sent successfully to  " + to);
    }

    private static Message prepareMessage(Session session, String username, String recepient, String Body) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Confirmation E-Mail From Shiva Mall For Your Parking Your Vehicle");
            message.setText(Body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    public int getCountryCodeForPhoneNumber(String countryCode) {
        PhoneNumberUtil phonenumber = PhoneNumberUtil.getInstance();
        return phonenumber.getCountryCodeForRegion(countryCode);
    }

    public String countryCodes(String countryName) {
        final Map<String, String> map = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);

        try {
            map.put("United Arab Emirates", "AE");
            map.put("Australia", "AU");
            map.put("Bangladesh", "BD");
            map.put("Belgium", "BE");
            map.put("Brazil", "BR");
            map.put("Bhutan", "BT");
            map.put("Canada", "CA");
            map.put("Switzerland", "CH");
            map.put("China", "CN");
            map.put("Germany", "DE");
            map.put("Denmark", "DK");
            map.put("Egypt", "EG");
            map.put("Spain", "ES");
            map.put("France", "FR");
            map.put("Britain", "UK");
            map.put("Greece", "GR");
            map.put("Hong Kong", "HK");
            map.put("Indonesia", "ID");
            map.put("India", "IN");
            map.put("Iraq", "IQ");
            map.put("Iran", "IR");
            map.put("Iceland", "IS");
            map.put("Italy", "IT");
            map.put("Japan", "JP");
            map.put("Kenya", "KE");
            map.put("North Korea", "KP");
            map.put("South Korea", "KR");
            map.put("Sri Lanka", "LK");
            map.put("Mexico", "MX");
            map.put("Malaysia", "MY");
            map.put("Netherlands", "NL");
            map.put("Norway", "NO");
            map.put("Nepal", "NP");
            map.put("New Zealand", "NZ");
            map.put("Pakistan", "PK");
            map.put("Poland", "PL");
            map.put("Portugal", "PT");
            map.put("Russian Federation", "RU");
            map.put("Saudi Arabia", "SA");
            map.put("Sweden", "SE");
            map.put("Singapore", "SG");
            map.put("Thailand", "TH");
            map.put("Turkey", "TR");
            map.put("Uganda", "UG");
            map.put("United Kingdom", "UK");
            map.put("United States", "US");
            map.put("Vietnam", "VN");
            map.put("South Africa", "ZA");
        } catch (Exception e) {
            System.out.println("Sorry Your Country Doesn't Have Code.\nSelecting default country as India");
            countryName = "India";
        }
        return map.get(countryName);
    }

    public void checkGivenData() {
        if (isAlphabet(this.name) & Location.isValidLocation(this.address)) {

        } else {
            System.out.println("Your data is Invalid. Please Try Again ");
            System.exit(0);
        }
    }

    public Object returnName() {
        return this.name;
    }
}
