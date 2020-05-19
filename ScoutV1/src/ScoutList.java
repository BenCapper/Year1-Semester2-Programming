import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
 *The ScoutList class contains methods which can be called in the ScoutingSystem class to interact with and add functionality to the arrayList
 *of scouts
 * @author Ben Capper
 */

public class ScoutList {
    private ArrayList<Scout> scouts = new ArrayList<Scout>();

     /**
      *Allows the user to add a scout object to the arrayList of scouts.
      */
    public void addScout(Scout scout) {
        scouts.add(scout);
    }

    /**
     *Allows the user to get a scout object from the arrayList, at the user defined index.
     * @param scoutIndex
     * @return userScout
     */
    public Scout getScout(int scoutIndex) {
        if ((scoutIndex >= 0) && (scoutIndex <= scouts.size())) { // If user input is more than 0, and less than or equal to size of arrayList
            Scout userScout = scouts.get(scoutIndex); // Get the scout at the index of user input
            return userScout;
        } else {
            return null;
        }
    }

    /**
     *Allows the user to remove a scout object from the arrayList of scouts, at the user defined index.
     * @param scoutIndex
     */
    public boolean removeScout(int scoutIndex) {
            scouts.remove(scoutIndex); // Else remove the scout at the index which the user entered
        return false;
    }

    /**
     *Returns the number of scouts currently in the scouts arrayList.
     * @return numberOfScouts
     */
    public int numberOfScouts() {
        return scouts.size();
    } // Returns the amount of objects in the arrayList.

     /**
      *If there are scouts in the arrayList, this method builds a string which lists each scout object in the arrayList.
      * @return listOfScouts
      */
    public String listOfScouts() {
        if (scouts.size() != 0) {
            String str = "";
            for (int i = 0; i < scouts.size(); i++) {
                str = str + "Scout " + i + ": " + scouts.get(i) + "\n";
            }
            return str;
        } else {
            return "There are no scouts in the list.";
        }
    }

    /**
     *This method allows the listing of scout objects based off the user assigned gender value.
     * Searches for M,F,UNSPECIFIED, builds a string containing each scout with the specified gender.
     * If none are found, returns relevant no scout string.
     * @param specificGender
     */
    public String listScoutsBySpecificGender(String specificGender) {
        String genderMale = "";
        String genderFemale = "";
        String genderUnspecified = "";
        if (scouts.size() != 0) {
            if (specificGender.toUpperCase().contentEquals("M")) { //if the user input is M or m, run this section
                for (int i = 0; i < scouts.size(); i++) {
                    if (scouts.get(i).getGender().toUpperCase().equals("M")) { //if there are male scouts, how many.
                        genderMale = genderMale + scouts.get(i) + "\n"; //creates string to be returned
                    } else if (!scouts.get(i).getGender().toUpperCase().equals("M")) { // If there are no male scouts.
                        return "There are no male scouts.";
                    }
                }
                return genderMale;
            } // End of Male section
            // Start of Female section
            else if (specificGender.toUpperCase().contentEquals("F")) { //if the user input is F or f, run this section
                for (int i = 0; i < scouts.size(); i++) {
                    if (scouts.get(i).getGender().toUpperCase().equals("F")) { //if there are female scouts, how many.
                        genderFemale = genderFemale + scouts.get(i) + "\n";
                    } else if (!scouts.get(i).getGender().toUpperCase().equals("F")) { // If there are no Female scouts.
                        return "There are no Female scouts.";
                    }
                }
                return genderFemale;
            } // End of Female section
            // Start of Unspecified section
            else if (specificGender.toUpperCase().contentEquals(specificGender.toUpperCase())) { //if the user input is Unspecified or unspecified, run this section
                for (int i = 0; i < scouts.size(); i++) {
                    if (scouts.get(i).getGender().toUpperCase().contentEquals(specificGender.toUpperCase())) { //if there are unspecified scouts, how many.
                        genderUnspecified = genderUnspecified + scouts.get(i) + "\n";
                    } else if  (!scouts.get(i).getGender().toUpperCase().contentEquals("UNSPECIFIED")){
                        return "There are no scouts with an unspecified gender.";
                    }
                }
                return genderUnspecified;
            } // End of Unspecified section
            else {
                return "Invalid -- Please enter: M / m <==> F / f <==> Unspecified";
            }
        } else {
            return "There are no scouts in the list.";
        }
    }

    /**
     * This method allows the listing of scout objects based off the user assigned division name.
     * Searches scout arrayList for a scout whose division name matches the user input then builds a string containing each scout with the specified division name.
     * If none are found, returns relevant no scout for division message
     * @param specificDivision
     */
    public String listScoutsBySpecificDivision(String specificDivision) {
        String chosenDivision = "";
        for (int i = 0; i < scouts.size(); i++) { // Loop to cycle through arrayList

            if (scouts.get(i).getDivision().getDivisionName().toUpperCase().contentEquals(specificDivision.toUpperCase())) { // If a scouts divisionName is same as user input
                chosenDivision = chosenDivision + scouts.get(i) + "\n"; // Forms string inside variable to be returned
            }

            else if(!scouts.get(i).getDivision().getDivisionName().toUpperCase().contentEquals(specificDivision.toUpperCase())) {
                return "There are no scouts for the division: " + specificDivision;
            }
        }
        return chosenDivision;
    }

    /**
     *This method searches the scouts array and returns the String of Scout objects whose names match the user input.
     * @return Scouts Matching User Input.
     */
    public String searchScoutByFirstName(String scoutFirstName) {
        String scoutName = "";
        if (scouts.size() != 0) {
            for (int i = 0; i < scouts.size(); i++) {
                if (scouts.get(i).getFirstName().toUpperCase().contentEquals(scoutFirstName.toUpperCase())) { //if there are male scouts, how many.
                    scoutName = scoutName + scouts.get(i) + "\n"; //creates string to be returned
                } else {
                    return "There are no scouts with that name.";
                }
            }
        }
        return scoutName;
    }
    /**
     *This method allows the user to save the scouts which have been created to a file named scouts.xml
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("scouts.xml"));
        out.writeObject(scouts);
        out.close();
    }

    /**
     *This method allows the user to load the scouts which have previously been created from a file named scouts.xml
     */
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("scouts.xml"));
        scouts = (ArrayList<Scout>) is.readObject();
        is.close();
    }


    private double toTwoDecimalPlaces(double num){
        return(int)(num*100) / 100.0;
    }

}
