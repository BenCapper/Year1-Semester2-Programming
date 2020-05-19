/**
 * BeaverScout is an extension of Scout
 * Allows for the creation of a BeaverScout Object
 * @author Ben Capper
 */
public class BeaverScout extends Scout {

    /**
     * beaverPhoneNumber initialized
     */
    protected String beaverPhoneNumber;

    /**
     * Constructor using attributes from Scout and BeaverScout Classes
     * @param name,county,dateOfBirth,address,phoneNumber,beaverPhoneNumber
     */
    public BeaverScout (String name, String county, String dateOfBirth, String address, String phoneNumber,  String beaverPhoneNumber) {

        super(name, county, dateOfBirth, address, phoneNumber);
        this.beaverPhoneNumber = beaverPhoneNumber;
    }

    /**
     * Returns BeaverScout Phone Number
     * @return beaverPhoneNumber
     */
    public String getBeaverPhoneNumber() {
        return beaverPhoneNumber;
    }

    /**
     * Sets BeaverScout Phone Number
     * @param beaverPhoneNumber
     */
    public void setBeaverPhoneNumber(String beaverPhoneNumber) {
        this.beaverPhoneNumber = beaverPhoneNumber;
    }

    /**
     * Returns Registration cost for a BeaverScout
     * @Override Scout calcRegistrationFee
     * @return 100.00
     */
    @Override
    public double calcRegistrationFee() {
        return 100.00;
    }

    /**
     * Returns the BeaverScout toString (Scout toString + BeaverScout toString)
     * @Override Scout toString
     * @return BeaverScout toString
     */
    @Override
    public String toString() {
                String beaver = ("\n----------BeaverScout----------");
                String str = ("Beavers Phone Number: " + beaverPhoneNumber);
                str += ("\n-------------------------------");
        return beaver + super.toString() + str + "\n";


    }
}
