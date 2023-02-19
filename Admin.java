import java.util.*;

public class Admin {
    static boolean isMaster = false;
    static int trails = 0;
    static int noOfFloors;
    static Floor[] floorObject;
    static int[] showSpacesArray;

    static void setMaster(Scanner myin) {
        System.out.println("Enter The Admin Password");
        myin.nextLine();
        while (trails < 3) {
            String password = myin.nextLine();
            if (password.equals("admin")) {
                isMaster = true;
                System.out.println("Login Successful");
                return;
            } else {
                trails++;
                isMaster = false;
                System.out.println("Try Again!");
            }
        }
        System.out.println("-- More than Three trials had been tried !");
        isMaster = false;
        System.exit(0);
    }

    static void welcome(ExitPoint obj, Scanner scanner, ArrayList<Person> arl) {

        while (true) {

            int userChoice = 0;
            System.out.println("Choose any one from the Menu:");
            System.out.println("1: User Portal");
            System.out.println("2: Admin Portal");
            System.out.println("3: Exit");
            System.out.println("4: CustomerChatbot");
            System.out.println("5: AdminChatbot");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1: { // USER
                    System.out.println("User Portal");
                    customerMenu(obj, scanner, arl);
                    break;
                }

                case 2: { // ADMIN
                    System.out.println("Admin Portal\n");
                    Admin.setMaster(scanner);
                    adminMenu(obj, scanner, arl);
                    break;
                }

                // case 3: { // CHATBOT
                // break;
                // }

                case 3: { // EXIT
                    System.out.println("\n\nThanks for coming. Hope you enjoyed our Service!\n\n");
                    System.exit(0);
                    break;
                }
                case 4: {
                    System.out.println("Customer Chat Bot");
                    UserQuery.getQuery(scanner, obj);
                    break;
                }
                case 5: {
                    System.out.println("Admin Chat Bot");
                    UserQuery.adminQuery(scanner);
                    break;
                }
                default: {
                    System.out.println("Invalid Input");
                    welcome(obj, scanner, arl);
                }
            }
        }
    }

    public static void adminMenu(ExitPoint obj, Scanner scanner, ArrayList<Person> arl) {
        System.out.println("\nWelcome to Admin Portal. How can we help you:");
        int adminOption;
        System.out.println(
                "1.Initialze Floors and Slot Counts\n2.Show the Present Count of Slots Filled\n3.Back to Main Menu\n4.Exit\n");
        adminOption = scanner.nextInt();
        adminOptions(obj, scanner, arl, adminOption);
    }

    public static void adminOptions(ExitPoint obj, Scanner scanner, ArrayList<Person> arl, int option) {
        // int check = 0;
        switch (option) {
            case 1: { // ADMIN SLOTS
                // check = 1;
                Floor.setMaxCountForAllFloorsWithInitilations(scanner);
                MaxFloor.showMaxCountForAllFloors();
                break;
            }
            case 2: { // ADMIN OPTION show all count
                if (Admin.noOfFloors > 0) {
                    Floor.showAllPresentCount();
                } else {
                    System.out.println("Please Initialze Floors and Slot Counts First !!");
                    adminMenu(obj, scanner, arl);
                }
                break;
            }
            case 3: { // back to main menu
                welcome(obj, scanner, arl);
                break;
            }
            case 4: { // exit
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Choose Correctly");
                System.out.println("Your Value is Out Of Bounds !");
                adminMenu(obj, scanner, arl);
            }
        }
    }

    public static void customerMenu(ExitPoint obj, Scanner scanner, ArrayList<Person> arl) {
        System.out.println("\nWelcome to Customer Portal. How can we help you :");
        int s;
        if (Admin.isMaster == false) {
            System.out.println("\n\nPLEASE ASK ADMIN TO INITIALIZE FLOORS AND SLOT COUNTS FIRST!\n\n");
            welcome(obj, scanner, arl);
        }

        System.out.println(
                "1.List of Available Slots\n2.Park Your Vehicle\n3.Pay and Exit\n4.Customer Chatbot\n5.Back To The Main Menu\n6.Exit\n");
        s = scanner.nextInt();
        customerOptions(obj, scanner, arl, s);
    }

    public static void customerOptions(ExitPoint obj, Scanner scanner, ArrayList<Person> arl, int option) {
        switch (option) {
            case 1: { // AVAILABLE SLOTS
                Floor.showAllPresentCount();
                customerMenu(obj, scanner, arl);
                break;
            }
            case 2: { // PARK YOUR VEHICLE
                System.out.println("Welcome. Are you a New User? (y/n)");
                String y = scanner.next().toLowerCase();

                // REGISTER NEW USER
                if (y.charAt(0) == 'y') {

                    obj.startPortal(scanner);
                    arl.add(obj);
                }

                // OLD USER
                else {
                    System.out.println("Please Enter Your Registered Name: ");
                    String userName = scanner.next();
                    System.out.println("Searching our Database for name: " + userName);
                    int i = 0, len = arl.size();
                    for (i = 0; i < len; i++) {
                        if (userName.equals(arl.get(i).returnName())) {
                            System.out.println("Name found :" + userName);
                            customerMenu(obj, scanner, arl);
                            break;
                        }
                    }
                    if (i == len) {
                        System.out.println("USER NOT FOUND. REGISTER THE NEW USER:\n");
                        obj.startPortal(scanner);
                        arl.add(obj);
                        customerMenu(obj, scanner, arl);
                    }
                }
                break;
            }
            case 3: {
                System.out.println("Pay and Exit Portal");
                obj.parkingCharge.transactionDetails();
                obj.checkExit(scanner);
                obj.toTakeTheCar(scanner);
                break;
            }
            case 4: {
                // CHATBOT
                System.out.println("Meet our Chatbot\nType in your query");
                Scanner s = new Scanner(System.in);
                UserQuery.getQuery(s, obj);
                customerMenu(obj, scanner, arl);
                break;
            }
            case 5: {
                System.out.println("Returning to the Main Menu");
                welcome(obj, scanner, arl);
                break;
            }
            case 6: {
                System.out.println("Exit");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Choose Correctly");
                customerMenu(obj, scanner, arl);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> registeredCustomerList = new ArrayList<>(); // calling list object from main function
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Team 10's parking lot\n\n");
        ExitPoint obj = new ExitPoint();
        welcome(obj, scanner, registeredCustomerList);
        scanner.close();
    }
}