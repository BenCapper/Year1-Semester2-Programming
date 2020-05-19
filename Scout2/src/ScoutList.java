import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * ScoutList stores methods to be used on an ArrayList of Scouts
 * @author Ben Capper
 */
public class ScoutList {

    /**
     * Initializes ArrayList of Scouts
     */
    private ArrayList<Scout> scouts = new ArrayList<Scout>();

    /**
     * Adds a Scout object to the ArrayList
     * @param scout
     */
    public void addScout(Scout scout) {
        scouts.add(scout);
    }

    /**
     * Adds Special Interest to a Scout object, specified by user
     * @param scoutPhone,interest
     */
    public void addInterest(String scoutPhone, SpecialInterest interest) {
        for (int i = 0; i < scouts.size(); i++) {
            if ((scouts.get(i) instanceof CubScout) && ((CubScout) scouts.get(i)).getCubPhoneNumber().contentEquals(scoutPhone)) { // if the Scout is a Cub and matches specified phone number
                scouts.get(i).addSpecialInterest(interest);
            } else if ((scouts.get(i) instanceof BeaverScout) && ((BeaverScout) scouts.get(i)).getBeaverPhoneNumber().contentEquals(scoutPhone)) {
                scouts.get(i).addSpecialInterest(interest);
            } else if ((scouts.get(i) instanceof Scouter) && ((Scouter) scouts.get(i)).getScouterPhoneNumber().contentEquals(scoutPhone)) {
                scouts.get(i).addSpecialInterest(interest);
            }
        }
    }

    /**
     * Removes a Scout from the ArrayList, specified by User
     * @param scoutIndex
     */
    public boolean removeScout(int scoutIndex) {
        if (scouts.size() < scoutIndex) {
            return false;
        } else {
            scouts.remove(scoutIndex);
            return true;
        }
    }

    /**
     * Returns the amount of Scouts in the ArrayList
     * @return numberOfScouts
     */
    public int numberOfScouts() {
        return scouts.size();
    }


    //---------------------------------GET METHODS--------------------------------//

    /**
     * Get Scout object, specified by User
     * @param scoutIndex
     * @return Scout
     */
    public Scout getScout(int scoutIndex) {
        if ((scoutIndex >= 0) && (scoutIndex <= scouts.size())) {
            Scout userScout = scouts.get(scoutIndex);
            return userScout;
        } else {
            return null;
        }
    }

    /**
     * Gets Cub object, specified by User
     * @param cubPhoneNumber
     * @return Cub
     */
    public Scout getCubByPhone(String cubPhoneNumber ) {
        Scout cubMatch = new CubScout(null, null, null, null, null, null);
            for (int i = 0; i < scouts.size(); i++) {
                if ( scouts.get(i) instanceof CubScout && ((CubScout) scouts.get(i)).getCubPhoneNumber().contentEquals(cubPhoneNumber)) {
                    cubMatch = scouts.get(i);
                }
            }
        return cubMatch;
    }

    /**
     * Gets Beaver object, specified by User
     * @param beaverPhoneNumber
     * @return Beaver
     */
    public Scout getBeaverByPhone(String beaverPhoneNumber ) {
        Scout beaverMatch = new BeaverScout(null, null, null, null, null, null);
        for (int i = 0; i < scouts.size(); i++) {
            if ( scouts.get(i) instanceof BeaverScout && ((BeaverScout) scouts.get(i)).getBeaverPhoneNumber().contentEquals(beaverPhoneNumber)) {
                beaverMatch = scouts.get(i);
            }
        }
        return beaverMatch;
    }

    /**
     * Gets Scouter object, specified by User
     * @param scouterPhoneNumber
     * @return Scouter
     */
    public Scout getScouterByPhone(String scouterPhoneNumber ) {
        Scout scouterMatch = new Scouter(null, null, null, null, null, null); //construct new Scouter
        for (int i = 0; i < scouts.size(); i++) {
            if ( scouts.get(i) instanceof Scouter && ((Scouter) scouts.get(i)).getScouterPhoneNumber().contentEquals(scouterPhoneNumber)) {
                scouterMatch = scouts.get(i);
            }
        }
        return scouterMatch;
    }

    /**
     * Gets Scout object in ArrayList, specified by User
     * @param scoutName
     * @return Scout toString
     */
    public String getScoutByName(String scoutName) {
        String str = "";
        int count = 0;
        if (scouts.size() != 0) {
            for (int i = 0; i < scouts.size(); i++) {
                if (scouts.get(i).getName().contentEquals(scoutName)) {
                    str += scouts.get(i);
                }
            }
            for (int i = 0; i < scouts.size(); i++) {
                if (!scouts.get(i).getName().contentEquals(scoutName)){ //if count  = scouts.size then no objects matched
                    count++;
                }
            }
            if (count >= scouts.size()){
                str += "\n------------------------\nNo Results Found for " + scoutName + "\n------------------------\n";
            }
        }
        return str;
    }

    //---------------------------------GET END--------------------------------//


    //------------------------------List Methods------------------------------//

    /**
     * Lists all Scout objects in the ArrayList
     * @return allScouts
     */
    public String listAllScouts() {
        if (scouts.size() != 0) {
            String list = "";
            for (int i = 0; i < scouts.size(); i++) {
                list = list + i + ": " + scouts.get(i) + "\n";
            }
            return list;
        } else {
            return "\n---------------------------------\nThere are no Scouts Registered\n---------------------------------";
        }
    }

    /**
     * Lists all Cub objects in the ArrayList
     * @return cubList
     */
    public String listCubScout(){
        String list = "";
        if (scouts.size() != 0) {
            for (int i = 0; i < scouts.size(); i++) {
                if (scouts.get(i) instanceof CubScout) {
                    list = list + i + ": " + scouts.get(i) + "\n";
                }
            }
        }
        else{
            return "\n---------------------------------\nThere are no Cubs Registered\n---------------------------------";
        }
        return list;
    }

    /**
     * Lists all Beaver objects in the ArrayList
     * @return beaverList
     */
    public String listBeaverScout(){
        String list = "";
        if(scouts.size() != 0) {
            for (int i = 0; i < scouts.size(); i++) {
                if (scouts.get(i) instanceof BeaverScout) {
                    list = list + i + ": " + scouts.get(i) + "\n";
                }
            }
        }
        else {
            return "\n---------------------------------\nThere are no Beavers Registered\n---------------------------------";
        }
        return list;
    }

    /**
     * Lists all Scouter objects in the ArrayList
     * @return scouterList
     */
    public String listScouter(){
        String list = "";
        if (scouts.size() != 0) {
            for (int i = 0; i < scouts.size(); i++) {
                if (scouts.get(i) instanceof Scouter) {
                    list = list + i + ": " + scouts.get(i) + "\n";
                }
            }
        }
        else {
            return "\n---------------------------------\nThere are no Scouters Registered\n---------------------------------";
        }
        return list;
    }

    //------------------------------End of Lists------------------------------//

    //------------------------------Update Methods------------------------------//

    /**
     * Updates a Cub, specified by User
     * @param index,scoutName,scoutCounty,dateOfBirth,address,phoneNumber,cubNumber
     */
    public void updateCubScout(int index, String scoutName, String scoutCounty, String dateOfBirth, String address, String phoneNumber,String cubNumber) {
        Scout c = scouts.get(index);
        c.setName(scoutName);
        c.setCounty(scoutCounty);
        c.setDateOfBirth(dateOfBirth);
        c.setAddress(address);
        c.setPhoneNumber(phoneNumber);
        ((CubScout)c).setCubPhoneNumber(cubNumber);
    }

    /**
     * Updates a Beaver, specified by User
     * @param index,scoutName,scoutCounty,dateOfBirth,address,phoneNumber,beaverNumber
     */
    public void updateBeaverScout(int index, String scoutName, String scoutCounty, String dateOfBirth, String address, String phoneNumber,String beaverNumber) {
        Scout b = scouts.get(index);
        b.setName(scoutName);
        b.setCounty(scoutCounty);
        b.setDateOfBirth(dateOfBirth);
        b.setAddress(address);
        b.setPhoneNumber(phoneNumber);
        ((BeaverScout)b).setBeaverPhoneNumber(beaverNumber);
    }

    /**
     * Updates a Scouter, specified by User
     * @param index,scoutName,scoutCounty,dateOfBirth,address,phoneNumber,scouterNumber
     */
    public void updateScouter(int index, String scoutName, String scoutCounty, String dateOfBirth, String address, String phoneNumber,String scouterNumber) {
        Scout s = scouts.get(index);
        s.setName(scoutName);
        s.setCounty(scoutCounty);
        s.setDateOfBirth(dateOfBirth);
        s.setAddress(address);
        s.setPhoneNumber(phoneNumber);
        ((Scouter)s).setScouterPhoneNumber(scouterNumber);
    }

    //------------------------------End of Updates------------------------------//


    //------------------------------Persistence---------------------------------//

    /**
     * Saves all Scouts in ArrayList to .xml file
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("scouts.xml"));
        out.writeObject(scouts);
        out.close();
    }

    /**
     * Loads all Scouts in ArrayList from .xml file
     */
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("scouts.xml"));
        scouts = (ArrayList<Scout>) is.readObject();
        is.close();
    }

}

