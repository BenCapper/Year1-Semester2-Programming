import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * InterestList stores methods to be used on an ArrayList of Special Interests
 * @author Ben Capper
 */
public class InterestList {

    /**
     * Initializes ArrayList of Special Interests
     */
    private ArrayList<SpecialInterest> interests = new ArrayList<SpecialInterest>();

    /**
     * Adds a Special Interest object to the ArrayList
     * @param specialInterest
     */
    public void addSpecialInterest(SpecialInterest specialInterest) {
        interests.add(specialInterest);
    }

    /**
     * Returns the amount of Special Interests in the ArrayList
     * @return numberOfInterests
     */
    public int numberOfInterests() {
        return interests.size();
    }

    /**
     * Returns a Special Interest in the ArrayList, specified by User
     * @param interestIndex
     * @return SpecialInterest
     */
    public SpecialInterest getSpecialInterest(int interestIndex) {
        if (interests.contains(interestIndex)) {
            return interests.get(interestIndex);
        } else {
            return null;
        }
    }

    /**
     * Removes a Special Interest from the ArrayList, specified by User
     * @param interestIndex
     */
    public boolean removeInterest(int interestIndex) {
        if (interests.size() < interestIndex) {
            return false;
        } else {
            interests.remove(interestIndex);
            return true;
        }
    }


    /**
     * Lists toStrings of all Special Interests contained in the ArrayList
     * @return allInterests
     */
    public String listAllInterests() {
        if (interests.size() != 0) {
            String str = "";
            for (int i = 0; i < interests.size(); i++) {
                str = str + i + ": " + interests.get(i) + "\n";
            }
            return str;
        } else {
            return "-----------------------------------------\n" + "There are no interests in the list\n" + "-----------------------------------------\n";
        }
    }

    /**
     * Saves all Special Interests in ArrayList to .xml file
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("interests.xml"));
        out.writeObject(interests);
        out.close();
    }

    /**
     * Loads all Special Interests in ArrayList from .xml file
     */
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("interests.xml"));
        interests = (ArrayList<SpecialInterest>) is.readObject();
        is.close();
    }
}
