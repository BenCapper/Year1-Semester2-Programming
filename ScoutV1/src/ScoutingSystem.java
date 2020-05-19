import java.util.Scanner;

     /**
     *The ScoutingSystem class acts as the user interface. This class uses methods and classes made in previous classes
     *to create arrayLists of custom objects with user input.
      * @author Ben Capper
     */
public class ScoutingSystem {

    /**
     *The names of the scout and division arrayLists which the user will add to.
     */
    private Scanner input = new Scanner(System.in);
    private ScoutList scoutlist = new ScoutList();
    private DivisionList divisionList = new DivisionList();

    public ScoutingSystem() {
        runMenu();
    }

    public static void main(String[] args) {
        new ScoutingSystem();
    }

    /**
     *This method is the main menu of the scouting system.
     *It allows the user to choose which option they would like to use.
     */
    private int mainMenu() {
            System.out.println("Scouting Ireland Menu.");
            System.out.println("----------------");
            System.out.println("1  - Add a Scouting Division.");
            System.out.println("2  - List all Divisions.");
            System.out.println("3  - Search for a Division (By Name).");
            System.out.println("4  - Update a Division (By Index).");
            System.out.println("5  - Remove a Division (By Index).");
            System.out.println("----------------");
            System.out.println("6  - Add a Scout.");
            System.out.println("7  - List all Scouts.");
            System.out.println("8  - List all Scouts by Gender.");
            System.out.println("9  - List all Scouts by Division.");
            System.out.println("10 - Search for a Scout (By First Name).");
            System.out.println("11 - Update a Scout (By Index).");
            System.out.println("12 - Remove a Scout (By Index).");
            System.out.println("13 - Average Number of Scouts per Division");
            System.out.println("----------------");
            System.out.println("14 - Save to XML.");
            System.out.println("15 - Load from XML.");
            System.out.println("0  - Exit Menu.");
            System.out.print(": ");
            int option = input.nextInt();
            return option;
    }

    /**
     *This method runs the corresponding method to the user input in Main Menu
     */
    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    addDivision();
                    break;
                case 2:
                    System.out.println(divisionList.listOfDivisions());
                    break;
                case 3:
                    searchDivisionByName();
                    break;
                case 4:
                    updateDivision();
                    break;
                case 5:
                    deleteDivision();
                    break;
                case 6:
                    addScout();
                    break;
                case 7:
                    System.out.println(scoutlist.listOfScouts());
                    break;
                case 8:
                    listScoutByGender();
                    break;
                case 9:
                    listScoutByDivision();
                    break;
                case 10:
                    searchScoutByFirstName();
                    break;
                case 11:
                    updateScout();
                    break;
                case 12:
                    deleteScout();
                    break;
                case 13:
                    averageNumScoutPerDivision();
                    break;
                case 14:
                    save();
                    break;
                case 15:
                    load();
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
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

    /**
     *This method allows the user to add a new division to the division list.
     */
    private Division addDivision() {
        input.nextLine();
        System.out.print("Enter the division's name (40 Chars Max): ");
        String divisionName = input.nextLine();
        while (divisionName.length() > 40 || divisionName.contentEquals("invalid")) { // validation -- if user enters over 40 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
            System.out.println("This is not a valid name. Try Again!");
            System.out.print("Enter the division's name (40 Chars Max): ");
            divisionName = input.nextLine();
        }

        System.out.print("Enter the division's address(60 Chars Max): ");
        String divisionAddress = input.nextLine();
            while (divisionAddress.length() > 60 || divisionName.contentEquals("invalid")) { // validation -- if user enters over 60 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                System.out.println("This is not a valid address. Try Again!");
                System.out.print("Enter the division's address (40 Chars Max): ");
                divisionAddress = input.nextLine();
        }

        System.out.print("Enter the division's phone number: ");
        String divisionPhone = input.nextLine();
            if (!divisionPhone.matches("[0-9]+")) { // if user input is not a number, print invalid number to inform user -- stores Unknown number from constructor validation
                System.out.println("Invalid number");
        }

        System.out.print("Enter the division leaders name: ");
        String divisionLeader = input.nextLine();

        System.out.print("Enter the division's Email Address: ");
        String divisionEmail = input.nextLine();
            if (!divisionEmail.contains("@") || !divisionEmail.contains(".")) { // if user input does not contain an @ and . , print invalid email to inform user -- stores Unknown Email Format from constructor.
                System.out.println(divisionEmail + " is an invalid email address");
                divisionList.addDivision(new Division(divisionName.toUpperCase(), divisionAddress, divisionPhone,
                        divisionLeader, divisionEmail));
                System.out.println("-----------------------------");
                System.out.println("Division successfully added.");
                System.out.println("-----------------------------");
            }
            else{
                divisionList.addDivision(new Division(divisionName.toUpperCase(), divisionAddress, divisionPhone,
                        divisionLeader, divisionEmail));
                System.out.println("-----------------------------");
                System.out.println("Division successfully added.");
                System.out.println("-----------------------------");
                }

        return null;
    }
    /**
     *This method allows for the deletion of a division chosen by the user.
     */
    private void deleteDivision() {
        if (divisionList.numberOfDivisions() == 0) { // If there are no divisions in list
            System.out.println("There are no divisions in this list.");
        } else if (divisionList.numberOfDivisions() > 0) { // If there are divisions in the list
            System.out.println(divisionList.listOfDivisions()); // List divisions
            System.out.println("Enter the index number of the division you would like to delete: "); // ask user which they want to delete
            int optionToRemove = input.nextInt();
            if (optionToRemove > divisionList.numberOfDivisions()) { // If the user input is more than the index of available divisions
                System.out.println("There is no division for this index number.");
            } else { // If user input is valid
                divisionList.removeDivision(optionToRemove); // remove division
                System.out.println("Division: " + optionToRemove + " removed."); // confirm to user division is deleted
            }

        }
    }

         /**
          *This method prints the average number of scouts per division.
          */
         private void averageNumScoutPerDivision(){
        if(scoutlist.numberOfScouts() / divisionList.numberOfDivisions() >= 1){
            System.out.println("The average number of scouts per division is: " + scoutlist.numberOfScouts() / divisionList.numberOfDivisions());
        }
        else if (scoutlist.numberOfScouts() / divisionList.numberOfDivisions() < 1){
            System.out.println("The average number of scouts per division is: < 1.");
        }
        else {
            System.out.println("Cannot be calculated. Add more scouts and divisions.");
        }
    }

    /**
     *This method allows the user to search for a division by name.
     */
    private void searchDivisionByName() {
        input.nextLine();
        System.out.println("Enter a name to search by: ");
        String nameChoice = input.nextLine();
        System.out.println(divisionList.searchDivisionByName(nameChoice));
         }

         /**
          *This method allows the user to update the information stored on a division chosen by the user.
          */
         private void updateDivision() {
             //list divisions
             System.out.println(divisionList.listOfDivisions());
             if (divisionList.numberOfDivisions() > 0) {

                 //ask the user to choose a division
                 System.out.print("Enter the index of the division you wish to update ==> ");
                 int index = input.nextInt();
                 if (index > scoutlist.numberOfScouts()) {
                     System.out.println("There is no division for this index number");
                 }
                 //gather new details for each field from the user
                 else if ((index >= 0) && (index <= scoutlist.numberOfScouts())) {
                     input.nextLine();
                     System.out.print("Enter the division's name (40 Chars Max): ");
                     String divisionName = input.nextLine();
                     while (divisionName.length() > 40 || divisionName.contentEquals("invalid")) { // validation -- if user enters over 40 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                         System.out.println("This is not a valid name. Try Again!");
                         System.out.print("Enter the division's name (40 Chars Max): ");
                         divisionName = input.nextLine();
                     }

                     System.out.print("Enter the division's address(60 Chars Max): ");
                     String divisionAddress = input.nextLine();
                     while (divisionAddress.length() > 60 || divisionName.contentEquals("invalid")) { // validation -- if user enters over 60 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                         System.out.println("This is not a valid address. Try Again!");
                         System.out.print("Enter the division's address (40 Chars Max): ");
                         divisionAddress = input.nextLine();
                     }

                     System.out.print("Enter the division's phone number: ");
                     String divisionPhone = input.nextLine();
                     if (!divisionPhone.matches("[0-9]+")) { // if user input is not a number, print invalid number to inform user -- stores Unknown number from constructor validation
                         System.out.println("Invalid number");
                     }

                     System.out.print("Enter the division leaders name: ");
                     String divisionLeader = input.nextLine();

                     System.out.print("Enter the division's Email Address: ");
                     String divisionEmail = input.nextLine();

                     Division scoutDivision = divisionList.getDivision(index);
                     scoutDivision.setDivisionName(divisionName.toUpperCase());
                     scoutDivision.setDivisionAddress(divisionAddress);
                     scoutDivision.setDivisionPhone(divisionPhone);
                     scoutDivision.setDivisionLeader(divisionLeader);
                     scoutDivision.setDivisionEmail(divisionEmail);
                     System.out.println("------------------------------");
                     System.out.println("Division successfully updated.");
                     System.out.println("------------------------------");
                 }
             }
         }

    /**
     *This method allows the user to add a new scout to the scout list.
     *Includes Exception Handling in case user enters the wrong data type.
     */
    private void addScout() {
        if (divisionList.numberOfDivisions() <= 0) { // if there are no divisions, get user to make one
            System.out.println("There are no divisions in the system. Enter Division details to continue.");
            addDivision();
            addScout();
        } else { // if there are divisions
            input.nextLine();
            System.out.print("Enter the scout's first name (40 Chars Max): ");
            String firstName = input.nextLine();
            while (firstName.length() > 40 || firstName.contentEquals("invalid")) { // validation -- if user enters over 40 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                System.out.println("This is not a valid name. Try Again!");
                System.out.print("Enter the scout's name (40 Chars Max): ");
                firstName = input.nextLine();
            }
            System.out.print("Enter the scout's surname (40 Chars Max): ");
            String surName = input.nextLine();
            while (surName.length() > 40 || surName.contentEquals("invalid")) { // validation -- if user enters over 40 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                System.out.println("This is not a valid name. Try Again!");
                System.out.print("Enter the scout's surname (40 Chars Max): ");
                surName = input.nextLine();
            }
            System.out.print("Enter the scout's address: ");
            String scoutAddress = input.nextLine();
            while (scoutAddress.length() > 60 || scoutAddress.contentEquals("invalid")) { // validation -- if user enters over 60 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                System.out.println("This is not a valid address. Try Again!");
                System.out.print("Enter the scout's address (60 Chars Max): ");
                scoutAddress = input.nextLine();
            }

            System.out.print("Enter the scout's gender (M <==> F <==> Unspecified): ");
            String scoutGender = input.nextLine();
            while (!scoutGender.contains("Unspecified") && !scoutGender.contains("unspecified") && !scoutGender.contains("m") // validation -- if user enters anything but required genders, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                    && !scoutGender.contains("M") && !scoutGender.contains("f") && !scoutGender.contains("F") || scoutAddress.contentEquals("invalid")) {
                System.out.println("This is not a valid gender. Try Again!");
                System.out.print("Enter the scout's gender (M <==> F <==> Unspecified): ");
                scoutGender = input.nextLine();
            }
            int scoutDay = 0;
                  // https://www.w3schools.com/java/java_try_catch.asp -- EXCEPTION HANDLING REFERENCE
            try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                    System.out.print("Enter the scouts day of birth (Between 1 and 31): ");
                    scoutDay = input.nextInt();
                    while ((scoutDay < 1) || (scoutDay > 31)) { // Validation -- valid day
                        System.out.println("This isn't a valid day, Try again!");
                        System.out.print("Enter the scouts day of birth (Between 1 and 31): ");
                        scoutDay = input.nextInt();
                    }
                }
                catch(Exception e) { // If error occurs run this segment (Exit program)
                    System.out.println("---------------------------------------------");
                    System.out.println("You did not enter a number. Exiting Program!");
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }


            int scoutMonth = 0;
            try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                System.out.print("Enter the scouts month of birth (Between 1 and 12): ");
                scoutMonth = input.nextInt();
                while ((scoutMonth < 1) || (scoutMonth > 12)) {
                    System.out.println("This isn't a valid month, Try again!");
                    System.out.print("Enter the scouts month of birth (Between 1 and 31): ");
                    scoutMonth = input.nextInt();
                }
            }
            catch(Exception e) { // If error occurs run this segment (Exit program)
                System.out.println("---------------------------------------------");
                System.out.println("You did not enter a number. Exiting Program!");
                System.out.println("---------------------------------------------");
                System.exit(0);
            }

            int scoutYearOfBirth = 0;
            try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                System.out.print("Enter the scout's year of birth: ");
                scoutYearOfBirth = input.nextInt();
                while ((scoutYearOfBirth < 1990) || (scoutYearOfBirth > 2020)) {
                    System.out.println("This isn't a valid age to join the scouts, Try again!");
                    System.out.print("Enter the scout's year of birth: ");
                    scoutYearOfBirth = input.nextInt();
                }
            }
            catch(Exception e) { // If error occurs run this segment (Exit program)
                System.out.println("---------------------------------------------");
                System.out.println("You did not enter a number. Exiting Program!");
                System.out.println("---------------------------------------------");
                System.exit(0);
            }

            int currentYear = 0;
            try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                System.out.print("Enter the current year: ");
                currentYear = input.nextInt();
                while (currentYear < 1990) {
                    System.out.println("This isn't a valid year, Try again!");
                    System.out.print("Enter the current year: ");
                    currentYear = input.nextInt();
                }
            }
            catch(Exception e) { // If error occurs run this segment (Exit program)
                System.out.println("---------------------------------------------");
                System.out.println("You did not enter a number. Exiting Program!");
                System.out.println("---------------------------------------------");
                System.exit(0);
            }

            int scoutAge = currentYear - scoutYearOfBirth;
            while (scoutAge < 6) {
                System.out.print("Enter the scout's year of birth (Please ensure the year entered is valid): ");
                scoutYearOfBirth = input.nextInt();
                    }
            int scoutDivisionNum = 0;
            try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                System.out.println("Enter the division number you would like to add the scout to from the list below. (Index number): ");
                System.out.println(divisionList.listOfDivisions());
                System.out.print("==> ");
                scoutDivisionNum = input.nextInt();
                while (scoutDivisionNum > divisionList.numberOfDivisions()) {
                    System.out.println("This isn't a valid division index number, Try again!");
                    System.out.println("Enter the division number you would like to add the scout to from the list below. (Index number): ");
                    System.out.println(divisionList.listOfDivisions());
                    System.out.print("==> ");
                    scoutDivisionNum = input.nextInt();
                }
            }
            catch (Exception e){ // If error occurs run this segment (Exit program)
                    System.out.println("---------------------------------------------");
                    System.out.println("You did not enter a number. Exiting Program!");
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                   }
            Division scoutDivision = divisionList.getDivision(scoutDivisionNum);
            scoutlist.addScout(new Scout(firstName.toUpperCase(), surName.toUpperCase(), scoutAddress, scoutDay, scoutMonth, scoutYearOfBirth,
                                scoutGender.toUpperCase(), scoutDivision));
            System.out.println("-------------------------");
            System.out.println("Scout successfully added.");
            System.out.println("-------------------------");
        }
    }

    /**
     *This method allows for the deletion of a scout chosen by the user.
     */
    private void deleteScout() {
        System.out.println(scoutlist.listOfScouts());
        int optionToRemove = 0;
        try {// Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
            if (scoutlist.numberOfScouts() >= 0) {//only ask user to choose product to delete if any exist
                System.out.print("Enter the index number of the scout you would like to remove: "); //Ask user to enter index of product to be deleted
                optionToRemove = input.nextInt();
            }
            while (optionToRemove >= scoutlist.numberOfScouts()) {
                System.out.println("This is not a valid index, Try Again!");
                System.out.print("Enter the index number of the scout you would like to remove: ");
                optionToRemove = input.nextInt();
            }
        } catch (Exception e) { // If error occurs run this segment (Exit program)
            System.out.println("---------------------------------------------");
            System.out.println("You did not enter a number. Start Again!");
            System.out.println("---------------------------------------------");
            System.exit(0);
        }
            scoutlist.removeScout(optionToRemove);
            System.out.println("scout: " + optionToRemove + " removed.");
        }

    /**
     *This method allows the user to update the information stored on a scout chosen by the user.
     *Includes Exception Handling in case user enters wrong data type.
     */
    private void updateScout() {
        //list scouts
        System.out.println(scoutlist.listOfScouts());
        if (scoutlist.numberOfScouts() > 0) {

            System.out.print("Enter the index of the scout you wish to update ==> ");
            int index = input.nextInt();
            if(index > scoutlist.numberOfScouts()){
                System.out.println("There is no scout for this index number");
            }

            else if ((index >= 0) && (index <= scoutlist.numberOfScouts())){ // gather new details for each field from the user
                input.nextLine();
                System.out.print("Enter the scout's first name (40 Chars Max): ");
                String firstName = input.nextLine();
                while (firstName.length() > 40 || firstName.contentEquals("invalid")) { // validation -- if user enters over 40 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                    System.out.println("This is not a valid name. Try Again!");
                    System.out.print("Enter the scout's name (40 Chars Max): ");
                    firstName = input.nextLine();
                }
                System.out.print("Enter the scout's surname (40 Chars Max): ");
                String surName = input.nextLine();
                while (surName.length() > 40 || surName.contentEquals("invalid")) { // validation -- if user enters over 40 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                    System.out.println("This is not a valid name. Try Again!");
                    System.out.print("Enter the scout's surname (40 Chars Max): ");
                    surName = input.nextLine();
                }
                System.out.print("Enter the scout's address: ");
                String scoutAddress = input.nextLine();
                while (scoutAddress.length() > 60 || scoutAddress.contentEquals("invalid")) { // validation -- if user enters over 60 chars, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                    System.out.println("This is not a valid address. Try Again!");
                    System.out.print("Enter the scout's address (60 Chars Max): ");
                    scoutAddress = input.nextLine();
                }

                System.out.print("Enter the scout's gender (M <==> F <==> Unspecified): ");
                String scoutGender = input.nextLine();
                while (!scoutGender.contains("Unspecified") && !scoutGender.contains("unspecified") && !scoutGender.contains("m") // validation -- if user enters anything but required genders, will be set to invalid from constructor -- if invalid, loop until valid choice entered
                        && !scoutGender.contains("M") && !scoutGender.contains("f") && !scoutGender.contains("F") || scoutAddress.contentEquals("invalid")) {
                    System.out.println("This is not a valid gender. Try Again!");
                    System.out.print("Enter the scout's gender (M <==> F <==> Unspecified): ");
                    scoutGender = input.nextLine();
                }
                int scoutDay = 0;
                try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                    System.out.print("Enter the scouts day of birth (Between 1 and 31): ");
                    scoutDay = input.nextInt();
                    while ((scoutDay < 1) || (scoutDay > 31)) { // Validation -- valid day
                        System.out.println("This isn't a valid day, Try again!");
                        System.out.print("Enter the scouts day of birth (Between 1 and 31): ");
                        scoutDay = input.nextInt();
                    }
                }
                catch(Exception e) { // If error occurs run this segment (Exit program)
                    System.out.println("---------------------------------------------");
                    System.out.println("You did not enter a number. Exiting Program!");
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }


                int scoutMonth = 0;
                try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                    System.out.print("Enter the scouts month of birth (Between 1 and 12): ");
                    scoutMonth = input.nextInt();
                    while ((scoutMonth < 1) || (scoutMonth > 12)) {
                        System.out.println("This isn't a valid month, Try again!");
                        System.out.print("Enter the scouts month of birth (Between 1 and 31): ");
                        scoutMonth = input.nextInt();
                    }
                }
                catch(Exception e) { // If error occurs run this segment (Exit program)
                    System.out.println("---------------------------------------------");
                    System.out.println("You did not enter a number. Exiting Program!");
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }

                int scoutYearOfBirth = 0;
                try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                    System.out.print("Enter the scout's year of birth: ");
                    scoutYearOfBirth = input.nextInt();
                    while ((scoutYearOfBirth < 1990) || (scoutYearOfBirth > 2020)) {
                        System.out.println("This isn't a valid age to join the scouts, Try again!");
                        System.out.print("Enter the scout's year of birth: ");
                        scoutYearOfBirth = input.nextInt();
                    }
                }
                catch(Exception e) { // If error occurs run this segment (Exit program)
                    System.out.println("---------------------------------------------");
                    System.out.println("You did not enter a number. Exiting Program!");
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }

                int currentYear = 0;
                try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                    System.out.print("Enter the current year: ");
                    currentYear = input.nextInt();
                    while (currentYear < 1990) {
                        System.out.println("This isn't a valid year, Try again!");
                        System.out.print("Enter the current year: ");
                        currentYear = input.nextInt();
                    }
                }
                catch(Exception e) { // If error occurs run this segment (Exit program)
                    System.out.println("---------------------------------------------");
                    System.out.println("You did not enter a number. Exiting Program!");
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }

                int scoutAge = currentYear - scoutYearOfBirth;
                while (scoutAge < 6) {
                    System.out.print("Enter the scout's year of birth (Please ensure the year entered is valid): ");
                    scoutYearOfBirth = input.nextInt();
                }
                int scoutDivisionNum = 0;
                try { // Error Handling -- if user enters anything but an int catch will exit with a message, rather than crash program
                    System.out.println("Enter the division number you would like to add the scout to from the list below. (Index number): ");
                    System.out.println(divisionList.listOfDivisions());
                    System.out.print("==> ");
                    scoutDivisionNum = input.nextInt();
                    while (scoutDivisionNum > divisionList.numberOfDivisions()) {
                        System.out.println("This isn't a valid division index number, Try again!");
                        System.out.println("Enter the division number you would like to add the scout to from the list below. (Index number): ");
                        System.out.println(divisionList.listOfDivisions());
                        System.out.print("==> ");
                        scoutDivisionNum = input.nextInt();
                    }
                }
                catch (Exception e){ // If error occurs run this segment (Exit program)
                    System.out.println("---------------------------------------------");
                    System.out.println("You did not enter a number. Exiting Program!");
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }
                Division scoutDivision = divisionList.getDivision(scoutDivisionNum);
                Scout scout = scoutlist.getScout(index);
                scout.setFirstName(firstName.toUpperCase());
                scout.setSurname(surName);
                scout.setAddress(scoutAddress);
                scout.setDayOfBirth(scoutDay);
                scout.setMonthOfBirth(scoutMonth);
                scout.setYearOfBirth(scoutYearOfBirth);
                scout.setGender(scoutGender);
                scout.setDivision(scoutDivision);
                System.out.println("---------------------------");
                System.out.println("Scout successfully updated.");
                System.out.println("---------------------------");
            }
        }
    }

         /**
          *This method allows the listing of scouts by their assigned Division.
          */
         private void listScoutByDivision() {
             if (divisionList.numberOfDivisions() == 0) {
                 System.out.println("There are no divisions in the list.");
             } else {
                 System.out.println("Below are the list of divisions which you may select");
                 System.out.println(divisionList.listOfDivisions());
                 input.nextLine();
                 System.out.println("Enter a division name to search by: ");
                 String divisionChoice = input.nextLine();
                 System.out.println(scoutlist.listScoutsBySpecificDivision(divisionChoice));
             }
         }

         /**
          *This method allows the listing of scouts by their assigned Gender.
          */
         private void listScoutByGender() {
             input.nextLine();
             System.out.println("Enter a gender to search by (M <==> F <==> Unspecified): ");
             String genderChoice = input.nextLine();
             System.out.println(scoutlist.listScoutsBySpecificGender(genderChoice));
         }

         /**
          *This method allows the user to search for a scout by name.
          */
         private void searchScoutByFirstName() {
             input.nextLine();
             System.out.println("Enter a name to search by: ");
             String nameChoice = input.nextLine();
             System.out.println(scoutlist.searchScoutByFirstName(nameChoice));
         }

    /**
     *This method saves both the scout ArrayList and division ArrayList to separate .xml files.
     */
    public void save(){
        try {
            divisionList.save();
            scoutlist.save();
        }
        catch(Exception e){
            System.out.println("Error writing to file: " + e);
        }
    }

    /**
     *This method loads both the scout ArrayList and division ArrayList from the .xml files produced when the user uses the save option.
     */
    public void load() {
        try {
            divisionList.load();
            scoutlist.load();
        }
        catch(Exception e){
                System.out.println("Error reading from file: " + e);
            }
        }
    }
