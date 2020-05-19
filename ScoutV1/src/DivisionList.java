import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *The DivisionList class constructs and adds functionality to the division arrayList.
 * @author Ben Capper
 */

public class DivisionList {
    private ArrayList<Division> divisions = new ArrayList<Division>();

     /**
     *This method allows the user to add an object to the division arrayList.
     */
    public void addDivision(Division division) {
        divisions.add(division);
    }

     /**
     *This method returns the specified Division object from the arrayList.
      * @param divisionIndex
     */
    public Division getDivision(int divisionIndex) {
        if ((divisionIndex >= 0) && (divisionIndex <= divisions.size())) {
            return divisions.get(divisionIndex);
        } else {
            return null;
        }
    }

     /**
     *This method returns an int which represents the amount of objects in the arrayList.
      * @return numberOfDivisions
     */
    public int numberOfDivisions() {
        return divisions.size();
    }

     /**
     *This method removes the specified Division object from the arrayList of divisions.
      * @param divisionIndex
     */
    public boolean removeDivision(int divisionIndex) {
        divisions.remove(divisionIndex);
        return false;
    }
     /**
     *This method returns a String of Division objects built from the Division class toString.
      * @return listOfDivisions.
     */
    public String listOfDivisions() {
        if (divisions.size() == 0) {
            return "There are no divisions in the list.";
        }
        else{ // Loops through arrayList and returns each object
            String listOfDivisions = "";
            for (int i = 0; i < divisions.size(); i++) {
                listOfDivisions = listOfDivisions + "Index: " + i + " | " + divisions.get(i) + "\n";
            }
            return listOfDivisions;
        }
    }
    /**
     *This method searches the divisions array and returns the String of Division objects whose names match the user input.
     * @return Divisions Matching User Input.
     */
    public String searchDivisionByName(String divisionName) {
        String divName = "";
        if (divisions.size() != 0) {
            for (int i = 0; i < divisions.size(); i++) {
                if (divisions.get(i).getDivisionName().toUpperCase().contentEquals(divisionName.toUpperCase())) { //if there are male scouts, how many.
                    divName = divName + divisions.get(i) + "\n"; //creates string to be returned
                } else {
                    return "There are no divisions with that name.";
                }
            }
        }
        return divName;
    }
     /**
     *This method saves the current list of divisions to divisions.xml
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("divisions.xml"));
        out.writeObject(divisions);
        out.close();
    }

     /**
     *This method loads the current list of divisions from divisions.xml
     */
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("divisions.xml"));
        divisions = (ArrayList<Division>) is.readObject();
        is.close();
    }

}
