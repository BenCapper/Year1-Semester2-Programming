/**
 * Scouter is an extension of Scout
 * Allows for the creation of a Scouter Object
 * @author Ben Capper
 */
public class Scouter extends Scout {

    /**
     * scouterPhoneNumber initialized
     */
    protected String scouterPhoneNumber;

    /**
     * Constructor using attributes from Scout and Scouter Classes
     * @param name,county,dateOfBirth,address,phoneNumber,scouterPhoneNumber
     */
    public Scouter (String name, String county, String dateOfBirth, String address, String phoneNumber,  String scouterPhoneNumber) {
        super(name, county, dateOfBirth, address, phoneNumber);
        this.scouterPhoneNumber = scouterPhoneNumber;
    }

    /**
     * Returns Scouter Phone Number
     * @return scouterPhoneNumber
     */
    public String getScouterPhoneNumber() {
        return scouterPhoneNumber;
    }

    /**
     * Sets Scouter Phone Number
     * @param scouterPhoneNumber
     */
    public void setScouterPhoneNumber(String scouterPhoneNumber) {
        this.scouterPhoneNumber = scouterPhoneNumber;
    }

    /**
     * Returns Registration cost for a Scouter

     * @return 10.00
     */
    @Override
    public double calcRegistrationFee() {
        return 10.00;
    }

    /**
     * Returns the Scouter toString (Scout toString + Scouter toString)
     * @Override Scout toString
     * @return Scouter toString
     */
    @Override
    public String toString() {
        String scouter = ("\n-----------Scouter-------------");
        String str = ("Scouters Phone Number: " + scouterPhoneNumber);
        str += ("\n-------------------------------");
        return scouter + super.toString() + str + "\n";
    }
}
