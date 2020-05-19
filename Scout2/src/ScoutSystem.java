import java.util.Scanner;

/**
 * ScoutSystem acts as the User Interface.
 * @author Ben Capper
 */
public class ScoutSystem {

    /**
     * Initializes ArrayLists and Scanner Object
     */
    private Scanner input = new Scanner(System.in);
    private ScoutList scoutList = new ScoutList();
    private InterestList interestList = new InterestList();
    private EventList eventList = new EventList();


    public ScoutSystem() {
        runMainMenu();
    }

    public static void main(String[] args) {
        new ScoutSystem();
    }


    //------------------------------MENUS-------------------------------------------//

    /**
     * Menu which provides the userChoice for runMainMenu()
     */
    private int mainMenu() {
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Scouting Ireland");
        System.out.println("------------------------");
        System.out.println("Choose a category: ");
        System.out.println("1 - Scouts");
        System.out.println("2 - Events");
        System.out.println("3 - Admin");
        System.out.println("4 - load");
        System.out.println("------------------------");
        System.out.println("0 - Exit Menu.");
        System.out.println("------------------------");
        System.out.print("==> ");
        int option = input.nextInt();
        return option;
    }

    /**
     * Takes user input from mainMenu() and runs appropriate option
     */
    private void runMainMenu() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    runScoutMenu();
                    scoutMenu();
                    break;
                case 2:
                    runEventMenu();
                    eventMenu();
                case 3:
                    runAdminMenu();
                    adminMenu();
                    break;
                case 4:
                    load();
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Invalid option entered: " + option);
                    System.out.println("---------------------------------");
            }

            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }


//----------------------SCOUT--------------------//

    /**
     * Menu which provides the userChoice for runScoutMenu()
     */
    private int scoutMenu() {
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Scout");
        System.out.println("------------------------");
        System.out.println("1 - Register a Scout");
        System.out.println("2 - Update a Scout");
        System.out.println("3 - List all Scouts");
        System.out.println("4 - List all Scouts by Group");
        System.out.println("5 - Search for a Scout");
        System.out.println("6 - Add Special Interest");
        System.out.println("7 - Remove a Scout");
        System.out.println("8 - Save");
        System.out.println("------------------------");
        System.out.println("9 - Main Menu");
        System.out.println("------------------------");
        System.out.print("==> ");
        int optionScout = input.nextInt();
        return optionScout;
    }

    /**
     * Takes user input from scoutMenu() and runs appropriate option
     */
    private void runScoutMenu() {
        int optionScout = scoutMenu();
        while (optionScout != 0) {
            switch (optionScout) {
                case 1:
                    runScoutRegisterMenu();
                    scoutRegisterMenu();
                    break;
                case 2:
                    runScoutUpdateGroupMenu();
                    scoutListByGroupMenu();
                    break;
                case 3:
                    System.out.println(scoutList.listAllScouts());
                    break;
                case 4:
                    runScoutListByGroupMenu();
                    scoutListByGroupMenu();
                    break;
                case 5:
                    searchScoutsByName();
                    break;
                case 6:
                    addInterestToScout();
                    break;
                case 7:
                    removeScout();
                    break;
                case 8:
                    save();
                case 9:
                    runMainMenu();
                    mainMenu();
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Invalid option entered: " + optionScout);
                    System.out.println("---------------------------------\n");
            }

            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            optionScout = scoutMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }

    //----------------------------------EVENTS--------------------------//

    /**
     * Menu which provides the userChoice for runEventMenu()
     */
    private int eventMenu() {
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Event");
        System.out.println("------------------------");
        System.out.println("1 - Schedule an Event");
        System.out.println("2 - Update an Event");
        System.out.println("3 - List all Events");
        System.out.println("4 - Add Equipment to Event");
        System.out.println("5 - Add Donator to Event");
        System.out.println("6 - Remove an Event");
        System.out.println("7 - Save");
        System.out.println("------------------------");
        System.out.println("9 - Main Menu");
        System.out.println("------------------------");
        System.out.print("==> ");
        int optionEvent = input.nextInt();
        return optionEvent;
    }

    /**
     * Takes user input from eventMenu() and runs appropriate option
     */
    private void runEventMenu() {
        int optionEvent = eventMenu();
        while (optionEvent != 0) {
            switch (optionEvent) {
                case 1:
                    runEventRegisterMenu();
                    eventRegisterMenu();
                    break;
                case 2:
                    runEventUpdateMenu();
                    eventRegisterMenu();
                    break;
                case 3:
                    System.out.println(eventList.listAllEvents());
                    break;
                case 4:
                    addAnotherEquip();
                    break;
                case 5:
                    addAnotherDonator();
                    break;
                case 6:
                    removeEvent();
                    break;
                case 7:
                    save();
                    break;
                case 9:
                    runMainMenu();
                    mainMenu();
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Invalid option entered: " + optionEvent);
                    System.out.println("---------------------------------\n");
            }

            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            optionEvent = eventMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }

//--------------------------SCHEDULE EVENT------------------------------//

    /**
     * Menu which provides the userChoice for runEventRegisterMenu() and runEventUpdateMenu()
     */
    private int eventRegisterMenu() {
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Event");
        System.out.println("------------------------");
        System.out.println("Choose one of the following: ");
        System.out.println("1 - Scout");
        System.out.println("2 - Fundraiser");
        System.out.println("------------------------");
        System.out.println("9 - Event Options");
        System.out.println("------------------------");
        System.out.print("==> ");
        int option = input.nextInt();
        return option;
    }

    /**
     * Takes user input from eventRegisterMenu() and runs appropriate option
     */
    private void runEventRegisterMenu() {
        int option = eventRegisterMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    addScoutEvent();
                    break;
                case 2:
                    addFundEvent();
                    break;
                case 9:
                    runEventMenu();
                    eventMenu();
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Invalid option entered: " + option);
                    System.out.println("---------------------------------");
            }

            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            option = eventRegisterMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }

    /**
     * Takes user input from adminMenu() and runs appropriate option
     */
    private void runEventUpdateMenu() {
        int option = eventRegisterMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    updateScoutEvent();
                    break;
                case 2:
                    updateFundEvent();
                    break;
                case 9:
                    runEventMenu();
                    eventMenu();
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Invalid option entered: " + option);
                    System.out.println("---------------------------------");
            }

            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            option = eventRegisterMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }

//------------------------ADMIN-----------------//

    /**
     * Menu which provides the userChoice for runAdminMenu()
     */
    private int adminMenu() {
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Admin Menu.");
        System.out.println("------------------------");
        System.out.println("1 - Calculate Total Annual Fees Received");
        System.out.println("2 - Calculate Fees Received by Group");
        System.out.println("3 - Calculate Fees Received by Scout");
        System.out.println("4 - Calculate Cost of Equipment");
        System.out.println("5 - Calculate Cost of Event Locations");
        System.out.println("6 - List all Special Interests");
        System.out.println("7 - List all Donators");
        System.out.println("8 - Summary Report of all Scout Membership Numbers");
        System.out.println("9 - load");
        System.out.println("------------------------");
        System.out.println("10 - Main Menu.");
        System.out.println("------------------------");
        System.out.print("==> ");
        int optionAdmin = input.nextInt();
        return optionAdmin;
    }

    /**
     * Takes user input from adminMenu() and runs appropriate option
     */
    private void runAdminMenu() {
        int optionAdmin = adminMenu();
        while (optionAdmin != 0) {
            switch (optionAdmin) {
                case 1:
                    calcTotalFees();
                    break;
                case 2:
                    calcFeesByGroup();
                    break;
                case 3:
                    calcFeesByScout();
                    break;
                case 4:
                    calcTotalEquipCost();
                    break;
                case 5:
                    calcTotalLocationCost();
                    break;
                case 6:
                    System.out.println("\n" + interestList.listAllInterests());
                    break;
                case 7:
                    System.out.println(eventList.listDonators());
                    break;
                case 8:
                    summaryReport();
                    break;
                case 9:
                    save();
                    break;
                case 10:
                    runMainMenu();
                    mainMenu();
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Invalid option entered: " + optionAdmin);
                    System.out.println("---------------------------------");
            }

            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            optionAdmin = adminMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }


//---------------------------REGISTER SCOUT-------------------------------//

    /**
     * Menu which provides the userChoice for runScoutRegisterMenu()
     */
    private int scoutRegisterMenu() {
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Register Scout");
        System.out.println("------------------------");
        System.out.println("Choose one of the following: ");
        System.out.println("1 - Beaver");
        System.out.println("2 - Cub");
        System.out.println("3 - Scouter");
        System.out.println("------------------------");
        System.out.println("9 - Scout Options");
        System.out.println("------------------------");
        System.out.print("==> ");
        int option = input.nextInt();
        return option;
    }

    /**
     * Takes user input from scoutRegisterMenu() and runs appropriate option
     */
    private void runScoutRegisterMenu() {
        int option = scoutRegisterMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    addBeaverScout();
                    break;
                case 2:
                    addCubScout();
                    break;
                case 3:
                    addScouter();
                    break;
                case 9:
                    runScoutMenu();
                    scoutMenu();
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Invalid option entered: " + option);
                    System.out.println("---------------------------------");
            }

            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            option = scoutRegisterMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }

    //---------------------------lIST SCOUT-------------------------------//

    /**
     * Menu which provides the userChoice for runScoutUpdateGroupMenu() and runScoutListbyGroupMenu()
     */
    private int scoutListByGroupMenu() {
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Scout Groups");
        System.out.println("------------------------");
        System.out.println("Choose one of the following: ");
        System.out.println("1 - Beaver");
        System.out.println("2 - Cub");
        System.out.println("3 - Scouter");
        System.out.println("------------------------");
        System.out.println("9 - Scout Options");
        System.out.println("------------------------");
        System.out.print("==> ");
        int option = input.nextInt();
        return option;
    }

    /**
     * Takes user input from scoutListByGroupMenu() and runs appropriate option
     */
    private void runScoutUpdateGroupMenu() {
        int option = scoutListByGroupMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    updateBeaverScout();
                    break;
                case 2:
                    updateCubScout();
                    break;
                case 3:
                    updateScouter();
                    break;
                case 9:
                    runScoutMenu();
                    scoutMenu();
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Invalid option entered: " + option);
                    System.out.println("---------------------------------");
            }

            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            option = scoutListByGroupMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }

    /**
     * Takes user input from scoutListByGroupMenu() and runs appropriate option
     */
    private void runScoutListByGroupMenu() {
        int option = scoutListByGroupMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    System.out.println(scoutList.listBeaverScout());
                    break;
                case 2:
                    System.out.println(scoutList.listCubScout());
                    break;
                case 3:
                    System.out.println(scoutList.listScouter());
                    break;
                case 9:
                    runScoutMenu();
                    scoutMenu();
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Invalid option entered: " + option);
                    System.out.println("---------------------------------");

            }

            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            option = scoutListByGroupMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }
//------------------------------END OF MENU'S--------------------------------//


//-------------------------------ADD SCOUTS----------------------------------//

    /**
     * Adds a Special Interest to the interestList
     * @return SpecialInterest
     */
    private SpecialInterest repeatInterest() {
        input.nextLine();
        System.out.print("Enter Special Interest Category: \n==> ");
        String interestCategory = input.nextLine();

        System.out.print("Enter Special Interest Details: \n==> ");
        String details = input.nextLine();

        System.out.print("Enter Badge Receipt Date: \n==> ");
        String dateBadgeReceived = input.nextLine();
        SpecialInterest interest = new SpecialInterest(interestCategory, details, dateBadgeReceived);
        interestList.addSpecialInterest(new SpecialInterest(interestCategory, details, dateBadgeReceived));
        System.out.println("\n------------------------");
        System.out.println("Special Interest added");
        System.out.println("------------------------\n");
        return interest;
    }

    /**
     * Returns appropriate message to user if there are no Scouts in the scoutList
     */
    private void noScoutInList() {
        System.out.println("\n-------------------------------");
        System.out.println("There are no scouts registered \nPress Y | y to register");
        System.out.print("-------------------------------\n==> ");
        input.nextLine();
        String choice = input.nextLine();
        if (choice.contentEquals("y") || choice.contentEquals("Y")) {
            runScoutRegisterMenu();
            scoutRegisterMenu();

        } else {
            System.out.println("");
            System.out.println("-------------------------------");
            System.out.println("Invalid Option entered: " + choice);
            System.out.println("-------------------------------");
            System.out.println("Press Y | y to register a scout");
            System.out.println("Press B | b to return to menu");
            System.out.print("-------------------------------\n==> ");
            String reg = input.nextLine();
            if (reg.contentEquals("Y") || reg.contentEquals("y")) {
                runScoutRegisterMenu();
                scoutRegisterMenu();
            } else if (reg.contentEquals("B") || reg.contentEquals("b")) {
                runScoutRegisterMenu();
                scoutRegisterMenu();
            } else {
                System.out.println("-------------------------------");
                System.out.println("Invalid Option Entered: " + reg);
                System.out.println("-------------------------------\n\n");
            }
        }
    }

    /**
     * Adds a Special Interest to a Scout object
     */
    private void addInterestToScout() {
        if (scoutList.numberOfScouts() != 0) {

            System.out.println(scoutList.listAllScouts());
            System.out.println("Enter Scout index: ");
            int scoutIndex = input.nextInt();

            if (scoutList.getScout(scoutIndex) instanceof BeaverScout) {
                scoutList.addInterest(((BeaverScout) scoutList.getScout(scoutIndex)).getBeaverPhoneNumber(), repeatInterest());
            } else if (scoutList.getScout(scoutIndex) instanceof CubScout) {
                scoutList.addInterest(((CubScout) scoutList.getScout(scoutIndex)).getCubPhoneNumber(), repeatInterest());
            } else if (scoutList.getScout(scoutIndex) instanceof Scouter) {
                scoutList.addInterest(((Scouter) scoutList.getScout(scoutIndex)).getScouterPhoneNumber(), repeatInterest());
            }
        } else {
            noScoutInList();
        }
    }

    /**
     * Adds a BeaverScout to the ScoutList
     */
    private void addBeaverScout() {

        input.nextLine();
        System.out.println("");
        System.out.println("Enter Name: ");
        String scoutName = input.nextLine();

        System.out.println("Enter County: ");
        String scoutCounty = input.nextLine();

        System.out.println("Enter Date of Birth: ");
        String scoutDob = input.nextLine();

        System.out.println("Enter Address: ");
        String scoutAddress = input.nextLine();

        System.out.println("Enter Home Phone Number: ");
        String scoutPhone = input.nextLine();

        System.out.println("Enter Beavers Phone Number: ");
        String beaverPhoneNumber = input.nextLine();

        scoutList.addScout(new BeaverScout(scoutName, scoutCounty, scoutDob, scoutAddress, scoutPhone, beaverPhoneNumber));
        addedToRegisterMessage(scoutName);
        scoutList.addInterest(beaverPhoneNumber, repeatInterest());

        while (scoutList.getBeaverByPhone(beaverPhoneNumber).getSpecialInterests().size() > 0) {
            System.out.println("Would you like to enter another Special Interest? (y / n)");
            String choice = input.nextLine();
            if (choice.contentEquals("y")) {
                scoutList.addInterest(beaverPhoneNumber, repeatInterest());
            } else {
                runScoutMenu();
                scoutMenu();
            }
        }
    }

    /**
     * Adds a CubScout to the scoutList
     */
    private void addCubScout() {

        input.nextLine();
        System.out.println("");
        System.out.println("Enter Name: ");
        String scoutName = input.nextLine();

        System.out.println("Enter County: ");
        String scoutCounty = input.nextLine();

        System.out.println("Enter Date of Birth: ");
        String scoutDob = input.nextLine();

        System.out.println("Enter Address: ");
        String scoutAddress = input.nextLine();

        System.out.println("Enter Home Phone Number: ");
        String scoutPhone = input.nextLine();

        System.out.println("Enter Cubs Phone Number: ");
        String cubPhoneNumber = input.nextLine();

        scoutList.addScout(new CubScout(scoutName, scoutCounty, scoutDob, scoutAddress, scoutPhone, cubPhoneNumber));
        addedToRegisterMessage(scoutName);
        scoutList.addInterest(cubPhoneNumber, repeatInterest());

        while (scoutList.getCubByPhone(cubPhoneNumber).getSpecialInterests().size() >= 0) {
            input.nextLine();
            System.out.println("Would you like to enter another Special Interest? (y / n)");
            String choice = input.nextLine();
            if (choice.contentEquals("y")) {
                scoutList.addInterest(cubPhoneNumber, repeatInterest());
            } else {
                runScoutMenu();
                scoutMenu();
            }
        }
    }

    /**
     * Adds a Scouter object to the ArrayList of Scouts
     */
    private void addScouter() {
        input.nextLine();
        System.out.println("");
        System.out.println("Enter Name: ");
        String scoutName = input.nextLine();

        System.out.println("Enter County: ");
        String scoutCounty = input.nextLine();

        System.out.println("Enter Date of Birth: ");
        String scoutDob = input.nextLine();

        System.out.println("Enter Address: ");
        String scoutAddress = input.nextLine();

        System.out.println("Enter Home Phone Number: ");
        String scoutPhone = input.nextLine();

        System.out.println("Enter Scouters Phone Number: ");
        String scouterPhoneNumber = input.nextLine();

        scoutList.addScout(new Scouter(scoutName, scoutCounty, scoutDob, scoutAddress, scoutPhone, scouterPhoneNumber));
        addedToRegisterMessage(scoutName);
        scoutList.addInterest(scoutPhone, repeatInterest());


        while (scoutList.getScouterByPhone(scouterPhoneNumber).getSpecialInterests().size() > 0) {
            System.out.println("Would you like to enter another Special Interest? (y / n)");
            String choice = input.nextLine();
            if (choice.contentEquals("y")) {
                scoutList.addInterest(scouterPhoneNumber, repeatInterest());
            } else {
                runScoutMenu();
                scoutMenu();
            }
        }
    }
//--------------------------------ADD SCOUTS END-------------------------------------//


//--------------------------------ADD EVENTS-----------------------------------------//

    /**
     * Adds a ScoutEvent to the EventList
     */
    private void addScoutEvent() {
        if (scoutList.numberOfScouts() == 0) {
            System.out.println("\n---------------------------------------");
            System.out.println("There are no Scouts Registered");
            System.out.println("Add a Scout before Scheduling an Event");
            System.out.println("---------------------------------------");
            runScoutRegisterMenu();
            scoutRegisterMenu();
        } else {
            input.nextLine();
            System.out.print("\nEnter the Activity \n==> ");
            String activity = input.nextLine();
            System.out.print("Enter the Event Date \n==> ");
            String date = input.nextLine();
            System.out.print("Enter the Location \n==> ");
            String location = input.nextLine();
            System.out.print("Enter the Duration \n==> ");
            String duration = input.nextLine();
            System.out.print("Enter the Location Cost \n==> ");
            System.out.print("");
            double cost = input.nextDouble();
            eventList.addEvent(new ScoutEvent(date, location, duration, cost, activity));
            for (int i = 0; i < eventList.numberOfEvents(); i++) {
                if (eventList.getEvent(i).getDate().equals(date) && eventList.getEvent(i).getLocation().equals(location)) {
                    eventList.getEvent(i).addEquipmentToList(addEquipment());
                }
            }
            System.out.println("\nChoose Group to Invite: ");
            System.out.println("1 - Beavers");
            System.out.println("2 - Cubs");
            System.out.println("3 - Scouters");
            input.nextLine();
            System.out.print("==> ");
            String group = input.nextLine();
            for (int i = 0; i < scoutList.numberOfScouts(); i++) {
                if (scoutList.getScout(i) instanceof BeaverScout && group.equals("1")) {
                    for (int j = 0; j < eventList.numberOfEvents(); j++) {
                        if (eventList.getEvent(j).getDate().equals(date) && eventList.getEvent(j).getLocation().equals(location)) {
                            ((ScoutEvent) eventList.getEvent(j)).addScoutGroup(scoutList.getScout(i));
                            System.out.println("\n------------------------");
                            System.out.println("Event Scheduled");
                            System.out.println("------------------------\n");
                        }
                    }
                }
            }
            for (int i = 0; i < scoutList.numberOfScouts(); i++) {
                if (scoutList.getScout(i) instanceof CubScout && group.equals("2")) {
                    for (int j = 0; j < eventList.numberOfEvents(); j++) {
                        if (eventList.getEvent(j).getDate().equals(date) && eventList.getEvent(j).getLocation().equals(location)) {
                            ((ScoutEvent) eventList.getEvent(j)).addScoutGroup(scoutList.getScout(i));
                            System.out.println("\n------------------------");
                            System.out.println("Event Scheduled");
                            System.out.println("------------------------\n");
                        }
                    }
                }
            }
            for (int i = 0; i < scoutList.numberOfScouts(); i++) {
                if (scoutList.getScout(i) instanceof Scouter && group.equals("3")) {
                    for (int j = 0; j < eventList.numberOfEvents(); j++) {
                        if (eventList.getEvent(j).getDate().equals(date) && eventList.getEvent(j).getLocation().equals(location)) {
                            ((ScoutEvent) eventList.getEvent(j)).addScoutGroup(scoutList.getScout(i));
                            System.out.println("\n------------------------");
                            System.out.println("Event Scheduled");
                            System.out.println("------------------------\n");
                        }
                    }
                }

            }

            if (!group.equals("1") && !group.equals("2") && !group.equals("3")) {
                System.out.println(group + " is not a valid choice");
            }
        }
    }

    /**
     * Returns an Equipment object to be added to an Event
     * @return Equipment
     */
    private Equipment addEquipment() {
        System.out.println("\n----------------------");
        System.out.println("Equipment Details");
        System.out.println("----------------------\n");
        input.nextLine();
        System.out.print("Enter Description \n==> ");
        String description = input.nextLine();
        System.out.print("Enter Supplier Name \n==> ");
        String supplier = input.nextLine();
        System.out.print("Enter Item Unit Cost \n==> ");
        double cost = input.nextDouble();
        System.out.print("Enter Amount of Units Required \n==> ");
        double units = input.nextDouble();
        Equipment equipment = new Equipment(description, supplier, cost, units);
        return equipment;
    }

    /**
     * Adds equipment to an Event, outside of the addEvent methods
     */
    private void addAnotherEquip() {
        System.out.println(eventList.listAllEvents());
        input.nextLine();
        System.out.print("Enter the index number of the event to add equipment: \n==> ");
        int choice = input.nextInt();
        if (choice < eventList.numberOfEvents() && choice >= 0){
                eventList.getEvent(choice).addEquipmentToList(addEquipment());
                System.out.println("\n----------------------");
                System.out.println("Equipment Added to Event");
                System.out.println("----------------------\n");
            }
        else {
            System.out.println(choice + " is not a valid option");
        }
    }

    /**
     * Returns a Donator object to be added to an Event
     * @return donator
     */
    private Donator addDonator() {
        System.out.println("\n----------------------");
        System.out.println("Donator Details");
        System.out.println("----------------------");
        input.nextLine();
        System.out.print("\nEnter Name \n==> ");
        String name = input.nextLine();
        System.out.print("Enter Phone Number \n==> ");
        String number = input.nextLine();
        System.out.print("Enter Address \n==> ");
        String address = input.nextLine();
        System.out.print("Enter Email \n==> ");
        String email = input.nextLine();
        System.out.print("Enter Amount Donated \n==> ");
        double donation = input.nextDouble();
        Donator donator = new Donator(name, number, address, email, donation);
        return donator;

    }

    /**
     * Adds a donator to a Fundraise Event outside of the addFundEvent Method
     */
    private void addAnotherDonator() {
        System.out.println(eventList.listFundEvent());
        if (eventList.numberOfEvents() <= 0) {
            System.out.println("\n---------------------------------");
            System.out.println("There are no Scheduled Fundraisers");
            System.out.println("Press Y to Schedule an Event");
            System.out.println("---------------------------------\n");
            input.nextLine();
            System.out.print("==> ");
            String confirm = input.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                runEventRegisterMenu();
                eventRegisterMenu();
            } else {
                runEventMenu();
                eventMenu();
            }
        } else {
            input.nextLine();
            System.out.print("Enter the index number of the event to add donator: \n==> ");
            int choice = input.nextInt();
            if (choice < eventList.numberOfEvents() && choice >= 0)
                for (int i = 0; i < eventList.numberOfEvents(); i++) {
                    if (eventList.getEvent(i) instanceof FundraiseEvent) {
                        ((FundraiseEvent) eventList.getEvent(i)).addDonatorToList(addDonator());
                        System.out.println("\n----------------------");
                        System.out.println("Donator Added to Event");
                        System.out.println("----------------------\n");
                    }
                }
            else {
                System.out.println("\n------------------------------");
                System.out.println(choice + " is not a valid option");
                System.out.println("------------------------------\n");
            }
        }
    }

    /**
     * Adds a Fundraise Event to the ArrayList
     */
    private void addFundEvent() {
        input.nextLine();
        System.out.print("\nEnter Event Name \n==> ");
        String name = input.nextLine();
        System.out.print("Enter Event Date \n==> ");
        String date = input.nextLine();
        System.out.print("Enter Event Location \n==> ");
        String location = input.nextLine();
        System.out.print("Enter Event Duration \n==> ");
        String duration = input.nextLine();
        System.out.print("Enter Location Cost \n==> ");
        double cost = input.nextDouble();
        eventList.addEvent(new FundraiseEvent(name, location, duration, cost, date));
        for (int i = 0; i < eventList.numberOfEvents(); i++) {
            if (eventList.getEvent(i).getDate().equals(date) && eventList.getEvent(i).getLocation().equals(location)) {
                eventList.getEvent(i).addEquipmentToList(addEquipment());
            }
        }
        for (int i = 0; i < eventList.numberOfEvents(); i++) {
            if (eventList.getEvent(i) instanceof FundraiseEvent) {
                if (eventList.getEvent(i).getDate().equals(date) && eventList.getEvent(i).getLocation().equals(location)) {
                    ((FundraiseEvent) eventList.getEvent(i)).addDonatorToList(addDonator());
                }
            }
        }
        System.out.println("\n------------------------");
        System.out.println("Event Scheduled");
        System.out.println("------------------------\n");


    }
//--------------------------------ADD EVENTS END-----------------------------------------//

    /**
     * Returns the Scout object which matches user input
     */
    private void searchScoutsByName() {
        if (scoutList.numberOfScouts() > 0) {
            System.out.println("");
            input.nextLine();
            System.out.print("\nEnter the Scouts name: \n==> ");
            String name = input.nextLine();
            System.out.println(scoutList.getScoutByName(name));
        } else {
            noScoutInList();
        }
    }

    /**
     * Formats a word so that the first letter is capitalized
     * @param scoutName
     */
    private String nameFormat(String scoutName) {
        String word = "";
        String lowerCase = "";
        String capLetter = "";
        if (scoutName.length() > 0) {
            capLetter = scoutName.substring(0, 1).toUpperCase();
            lowerCase = scoutName.substring(1);
            word = capLetter + lowerCase;
        }
        return word;
    }

    /**
     * Returns an added successfully message before adding Special Interest to a Scout
     * @param scoutName
     */
    private void addedToRegisterMessage(String scoutName) {
        System.out.println("\n------------------------");
        System.out.println(nameFormat(scoutName) + " added to the register \n" + "Add " + nameFormat(scoutName) + "'s Special Interests");
        System.out.println("------------------------");
    }


//-----------------------------------UPDATE METHODS---------------------------------//

    /**
     * Update a Beaver
     */
    private void updateBeaverScout() {
        if (scoutList.numberOfScouts() != 0) {
            System.out.println("\n" + scoutList.listBeaverScout());
            System.out.print("Enter the index of the Beaver to be updated: \n==> ");
            int index = input.nextInt();
            if (index >= 0 && index <= eventList.numberOfEvents()) {
                input.nextLine();
                System.out.print("Enter Name: \n==> ");
                String name = input.nextLine();
                System.out.print("Enter County: \n==> ");
                String county = input.nextLine();
                System.out.print("Enter Date of Birth: \n==> ");
                String dob = input.nextLine();
                System.out.print("Enter Address: \n==> ");
                String address = input.nextLine();
                System.out.print("Enter Home Phone Number: \n==> ");
                String phone = input.nextLine();
                System.out.print("Enter Beaver Phone Number: \n==> ");
                String beaverPhone = input.nextLine();
                scoutList.updateBeaverScout(index, name, county, dob, address, phone, beaverPhone);
                System.out.println("\n-------------------");
                System.out.println("Beaver Updated");
                System.out.println("-------------------\n");
            } else {
                System.out.println("\n-------------------");
                System.out.println(index + " is not a valid index number");
                System.out.println("-------------------\n");
            }
        }
        else{
            System.out.println("\n---------------------------------");
            System.out.println("There are no Beavers Registered");
            System.out.println("---------------------------------\n");
        }
    }

    /**
     * Update a CubScout
     */
    private void updateCubScout() {
        if (scoutList.numberOfScouts() != 0) {
            System.out.println("\n" + scoutList.listCubScout());
            System.out.print("Enter the index of the Cub to be updated: \n==> ");
            int index = input.nextInt();
            if (index >= 0 && index <= eventList.numberOfEvents()) {
                input.nextLine();
                System.out.print("Enter Name: \n==> ");
                String name = input.nextLine();
                System.out.print("Enter County: \n==> ");
                String county = input.nextLine();
                System.out.print("Enter Date of Birth: \n==> ");
                String dob = input.nextLine();
                System.out.print("Enter Address: \n==> ");
                String address = input.nextLine();
                System.out.print("Enter Home Phone Number: \n==> ");
                String phone = input.nextLine();
                System.out.print("Enter Cub Phone Number: \n==> ");
                String cubPhone = input.nextLine();
                scoutList.updateCubScout(index, name, county, dob, address, phone, cubPhone);
                System.out.println("\n-------------------");
                System.out.println("Cub Updated");
                System.out.println("-------------------\n");
            } else {
                System.out.println("\n-------------------");
                System.out.println(index + " is not a valid index number");
                System.out.println("-------------------\n");
            }
        }
        else {
                System.out.println("\n---------------------------------");
                System.out.println("There are no Cubs Registered");
                System.out.println("---------------------------------\n");
            }
        }

    /**
     * Update a Scouter
     */
    private void updateScouter(){
        if(scoutList.numberOfScouts() != 0) {
            System.out.println("\n" + scoutList.listScouter());
            System.out.print("Enter the index of the scout to be updated: \n==> ");
            int index = input.nextInt();
            if (index >= 0 && index <= eventList.numberOfEvents()) {
                input.nextLine();
                System.out.print("Enter Name: \n==> ");
                String name = input.nextLine();
                System.out.print("Enter County: \n==> ");
                String county = input.nextLine();
                System.out.print("Enter Date of Birth: \n==> ");
                String dob = input.nextLine();
                System.out.print("Enter Address: \n==> ");
                String address = input.nextLine();
                System.out.print("Enter Home Phone Number: \n==> ");
                String phone = input.nextLine();
                System.out.print("Enter Beaver Phone Number: \n==> ");
                String scouterPhone = input.nextLine();
                scoutList.updateScouter(index, name, county, dob, address, phone, scouterPhone);
                System.out.println("\n-------------------");
                System.out.println("Scouter Updated");
                System.out.println("-------------------\n");
            } else {
                System.out.println("\n-------------------");
                System.out.println(index + " is not a valid index number");
                System.out.println("-------------------\n");
            }
        }
        else{
            System.out.println("\n---------------------------------");
            System.out.println("There are no Scouters Registered");
            System.out.println("---------------------------------\n");
        }
    }

    /**
     * Update a Scout Event
     */
    private void updateScoutEvent() {
        if (eventList.numberOfEvents() != 0) {
            System.out.println("\n" + eventList.listScoutEvent());
            System.out.print("Enter the index of the Event to be updated: \n==> ");
            int index = input.nextInt();
            input.nextLine();
            if (index >= 0 && index <= eventList.numberOfEvents()) {
                System.out.print("Enter Activity: \n==> ");
                String activity = input.nextLine();
                System.out.print("Enter Event Date: \n==> ");
                String date = input.nextLine();
                System.out.print("Enter Event Location: \n==> ");
                String location = input.nextLine();
                System.out.print("Enter Event Duration: \n==> ");
                String duration = input.nextLine();
                System.out.print("Enter Location Cost: \n==> ");
                int cost = input.nextInt();
                eventList.updateScoutEvent(index, activity, date, location, duration, cost);
                System.out.println("\n-------------------");
                System.out.println("Event Updated");
                System.out.println("-------------------\n");
            } else {
                System.out.println("\n-------------------");
                System.out.println(index + " is not a valid index number");
                System.out.println("-------------------\n");
            }
        }
        else {
                System.out.println("\n-------------------");
                System.out.println("There are no Scheduled Scout Events");
                System.out.println("-------------------\n");
            }
        }

    /**
     * Update a Fundraise Event
     */
    private void updateFundEvent() {
        if (eventList.numberOfEvents() != 0) {
            System.out.println("\n" + eventList.listFundEvent());
            System.out.print("Enter the index of the Event to be updated: \n==> ");
            int index = input.nextInt();
            if (index >= 0 && index <= eventList.numberOfEvents()) {
                input.nextLine();
                System.out.print("Enter Event Name: \n==> ");
                String name = input.nextLine();
                System.out.print("Enter Event Date: \n==> ");
                String date = input.nextLine();
                System.out.print("Enter Event Location: \n==> ");
                String location = input.nextLine();
                System.out.print("Enter Event Duration: \n==> ");
                String duration = input.nextLine();
                System.out.print("Enter Location Cost: \n==> ");
                int cost = input.nextInt();
                eventList.updateFundEvent(index, name, date, location, duration, cost);
                System.out.println("\n-------------------");
                System.out.println("Event Updated");
                System.out.println("-------------------\n");
            } else {
                System.out.println("\n-------------------");
                System.out.println(index + " is not a valid index number");
                System.out.println("-------------------\n");
            }
        }
        else{
            System.out.println("\n-------------------");
            System.out.println("There are no Scheduled Fundraisers");
            System.out.println("-------------------\n");
        }
    }
//------------------------------------UPDATE END---------------------------------//


//--------------------------------CALCULATE AND SUMMARY-----------------------------//

    /**
     * Calculates Total Fees across all groups
     */
    private void calcTotalFees() {
        double count = 0;
        for (int i = 0; i < scoutList.numberOfScouts(); i++) {
            count += scoutList.getScout(i).calcRegistrationFee();
        }
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Total annual fee's collected from members: " + count + " euro");
        System.out.println("-------------------------------------------------------------");
        System.out.println("");
    }

    /**
     * Calculates Total Fees from selected Scout Group
     */
    private void calcFeesByGroup() {
        double beaverCount = 0;
        double cubCount = 0;
        double scouterCount = 0;
        for (int i = 0; i < scoutList.numberOfScouts(); i++) {
            if (scoutList.getScout(i) instanceof BeaverScout) {
                beaverCount += scoutList.getScout(i).calcRegistrationFee();
            } else if (scoutList.getScout(i) instanceof CubScout) {
                cubCount += scoutList.getScout(i).calcRegistrationFee();
            } else if (scoutList.getScout(i) instanceof Scouter) {
                scouterCount += scoutList.getScout(i).calcRegistrationFee();
            }
        }
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Beavers: " + beaverCount + " euro");
        System.out.println("------------------------");

        System.out.println("------------------------");
        System.out.println("Cubs: " + cubCount + " euro");
        System.out.println("------------------------");

        System.out.println("------------------------");
        System.out.println("Scouters: " + scouterCount + " euro");
        System.out.println("------------------------");
        System.out.println("");

    }

    /**
     * Calculates Fees collected from a Scout
     */
    private void calcFeesByScout() {
        String scoutGroup = "";
        System.out.println("");
        if (scoutList.numberOfScouts() > 0) {
            for (int i = 0; i < scoutList.numberOfScouts(); i++) {
                if (scoutList.getScout(i) instanceof BeaverScout) {
                    scoutGroup = "Beaver";
                } else if (scoutList.getScout(i) instanceof CubScout) {
                    scoutGroup = "Cub";
                } else if (scoutList.getScout(i) instanceof Scouter) {
                    scoutGroup = "Scouter";
                }
                String name = scoutList.getScout(i).getName();
                System.out.println("------------------------");
                System.out.println(nameFormat(name) + ": " + scoutList.getScout(i).calcRegistrationFee() + " - " + scoutGroup);
                System.out.println("------------------------");
            }
        } else {
            System.out.println("------------------------------");
            System.out.println("There are no scouts registered");
            System.out.println("------------------------------");
        }
        System.out.println("");
    }

    /**
     * Calculates Total cost of all Event Equipment
     */
    private void calcTotalEquipCost(){
        double equipCost = 0;
        for (int i = 0; i < eventList.numberOfEvents() ; i++) {
            equipCost += eventList.getEvent(i).calcEquipCost();
        }
        System.out.println("\n-------------------------------------------------");
        System.out.println("The Cost of Equipment for all Events is " + equipCost + " euro");
        System.out.println("-------------------------------------------------\n");
    }

    /**
     * Calculates Total cost of all Event Locations
     */
    private void calcTotalLocationCost(){
        double locatCost = 0;
        for (int i = 0; i < eventList.numberOfEvents() ; i++) {
            locatCost += eventList.getEvent(i).calcLocationCost();
        }
        System.out.println("\n-------------------------------------------------");
        System.out.println("The Location Cost for all Events is " + locatCost + " euro");
        System.out.println("-------------------------------------------------\n");
    }

    /**
     * Returns a Summary Report of all relevant membership details
     */
    private void summaryReport() {
        int beaverCount = 0;
        int cubCount = 0;
        int scouterCount = 0;
        int fundEventCount = 0;
        int scoutEventCount = 0;
        double donationAmt = 0;
        double scoutCost = 0;
        double scoutLocat = 0;
        double equipFundCost = 0;
        double fundLocat = 0;

        for (int i = 0; i < scoutList.numberOfScouts(); i++) {
            if (scoutList.getScout(i) instanceof BeaverScout) {
                beaverCount += 1;
            } else if (scoutList.getScout(i) instanceof CubScout) {
                cubCount += 1;
            } else if (scoutList.getScout(i) instanceof Scouter) {
                scouterCount += 1;
            }
        }
        for (int i = 0; i < eventList.numberOfEvents(); i++) {
            if (eventList.getEvent(i) instanceof ScoutEvent) {
                scoutEventCount += 1;
                for (int k = 0; k < eventList.getEvent(i).getEquipment().size(); k++) {
                    scoutCost += eventList.getEvent(i).getEquipment().get(k).getCost() * eventList.getEvent(i).getEquipment().get(k).getAmount();
                    scoutLocat += +eventList.getEvent(i).getCost();
                }
            } else if (eventList.getEvent(i) instanceof FundraiseEvent) {
                fundEventCount += 1;
                for (int j = 0; j < eventList.getEvent(i).getEquipment().size(); j++) {
                    equipFundCost += eventList.getEvent(i).getEquipment().get(j).getCost() * eventList.getEvent(i).getEquipment().get(j).getAmount();
                    fundLocat += eventList.getEvent(i).getCost();
                }
                for (int j = 0; j < ((FundraiseEvent) eventList.getEvent(i)).getDonators().size(); j++) {
                    donationAmt += ((FundraiseEvent) eventList.getEvent(i)).getDonators().get(j).getDonation();
                }

            }
        }
        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("Beavers:              " + beaverCount);
        System.out.println("Fees Collected:    " + beaverCount * 100 + " euro");
        System.out.println("----------------------------");

        System.out.println("----------------------------");
        System.out.println("Cubs:                 " + cubCount);
        System.out.println("Fees Collected:    " + cubCount * 150 + " euro");
        System.out.println("----------------------------");

        System.out.println("----------------------------");
        System.out.println("Scouters:             " + scouterCount);
        System.out.println("Fees Collected:    " + scouterCount * 10 + " euro");
        System.out.println("----------------------------");

        System.out.println("-------------------------------------");
        System.out.println("Scout Events:           " + scoutEventCount);
        System.out.println("Equipment Costs:        " + scoutCost + " euro");
        System.out.println("Location Costs:         " + scoutLocat + " euro");
        System.out.println("-------------------------------------");

        System.out.println("-------------------------------------");
        System.out.println("Fundraise Events:       " + fundEventCount);
        System.out.println("Equipment Costs:        " + equipFundCost + " euro");
        System.out.println("Location Costs:         " + fundLocat + " euro");
        System.out.println("Donations Pledged:      " + donationAmt + " euro");
        System.out.println("-------------------------------------");
        System.out.println("");
    }
//--------------------------------CALCULATE END-----------------------------//


//-------------------------------REMOVE METHODS-----------------------------//

    /**
     * Removes a Scout from the scoutList
     */
    private void removeScout() {
        System.out.println("\n------------------------");
        System.out.println(scoutList.listAllScouts());
        if (scoutList.numberOfScouts() != 0) {
            System.out.print("\nEnter the index of the Scout to be deleted\n==> ");
            int scoutIndex = input.nextInt();
            if (scoutIndex >= 0 && scoutIndex < scoutList.numberOfScouts()) {
                scoutList.removeScout(scoutIndex);
                System.out.println("");
                System.out.println("-------------------");
                System.out.println("Scout Deleted");
                System.out.println("-------------------");
                System.out.println("");
            }
        }
    }

    /**
     * Removes an Event from the eventList
     */
    private void removeEvent() {
        System.out.println("\n------------------------");
        System.out.println(eventList.listAllEvents());
        if (eventList.numberOfEvents() != 0) {
            System.out.print("\nEnter the index of the Event to be deleted\n==> ");
            int eventIndex = input.nextInt();
            if (eventIndex >= 0 && eventIndex < eventList.numberOfEvents()) {
                eventList.removeEvent(eventIndex);
                System.out.println("");
                System.out.println("-------------------");
                System.out.println("Event Deleted");
                System.out.println("-------------------");
                System.out.println("");
            }
        }
    }
//----------------------------------REMOVE END--------------------------------//

//-----------------------------------PERSISTENCE------------------------------//

    /**
     * Saves all ArrayLists to .xml files
     */
    private void save() {
        try {
            interestList.save();
            scoutList.save();
            eventList.save();
            System.out.println("---------------");
            System.out.println("Saved");
            System.out.println("---------------");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e);
        }
    }

    /**
     * Loads all ArrayLists from .xml files
     */
    private void load() {
        try {
            interestList.load();
            scoutList.load();
            eventList.load();
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e);
        }
    }

}