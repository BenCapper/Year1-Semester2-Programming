import java.util.ArrayList;

/**
 * Scout is an abstract Class which implements iScoutMember
 * iScoutMember forces each extension of Scout to have a calcRegistrationFee method
 * allows for the creation of Scout subClasses
 * @author Ben Capper
 */
public abstract class Scout implements iScoutMember {

    /**
     * Scout attributes initialized
     * Each Scout has an arrayList of Special Interests
     */
    private String name, county, dateOfBirth, address, phoneNumber;
    private ArrayList<SpecialInterest> specialInterests;

    /**
     * Scout constructor
     * @param name,county,dateOfBirth,address,phoneNumber
     */
    public Scout(String name, String county, String dateOfBirth, String address, String phoneNumber) {
        this.name = name;
        this.county = county;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialInterests = new ArrayList<>();
    }

    /**
     * Returns Scout Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Scout Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns Scout County
     * @return county
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets Scout County
     * @param county
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * Returns Scout Date of Birth
     * @return dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets Scout Date of Birth
     * @param dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns Scout Address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets Scout address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns Scout Phone Number
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets Scout Phone Number
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Cycles through arrayList of specialInterests and adds each SpecialInterest object toString to a variable
     * then returns the String of SpecialInterests
     * @param specialInterests
     * @return interest
     */
    public String display(ArrayList specialInterests){
        String interest = "";
        for (int i = 0; i < specialInterests.size(); i++) {
            interest = interest + specialInterests.get(i).toString();
        }
        return interest;
    }

    /**
     * Returns Scout Special Interest arrayList
     * @return specialInterests
     */
    public ArrayList<SpecialInterest> getSpecialInterests() {
        return specialInterests;
    }

    /**
     * Sets Scout Special Interests
     * @param specialInterests
     */
    public void setSpecialInterests(ArrayList<SpecialInterest> specialInterests) {
        this.specialInterests = specialInterests;
    }

    /**
     * Adds a Special Interest to the specialInterest arrayList
     * @param specialInterest
     */
    public void addSpecialInterest(SpecialInterest specialInterest) {
        specialInterests.add(specialInterest);
    }


    /**
     * Returns the Scout toString
     * @return Scout
     */
    public String toString() {
        String str = "";
        str += ("\n" + "Name: " + name + "\n");
        str += ("County: " + county + "\n");
        str += ("Date of Birth: " + dateOfBirth + "\n");
        str += ("Address: " + address + "\n");
        str += ("Home Phone Number: " + phoneNumber + "\n");
        str += (display(getSpecialInterests()));
        return str;
    }
}