/**
 * CubScout is an extension of Scout
 * Allows for the creation of a CubScout Object
 * @author Ben Capper
 */
public class CubScout extends Scout {

    /**
     * cubPhoneNumber initialized
     */
    protected String cubPhoneNumber;

    /**
     * Constructor using attributes from Scout and CubScout Classes
     * @param name,county,dateOfBirth,address,phoneNumber,cubPhoneNumber
     */
    public CubScout (String name, String county, String dateOfBirth, String address, String phoneNumber, String cubPhoneNumber) {
        super(name,county,dateOfBirth,address,phoneNumber);
        this.cubPhoneNumber = cubPhoneNumber;
    }

    /**
     * Returns CubScout Phone Number
     * @return beaverPhoneNumber
     */
    public String getCubPhoneNumber() {
        return cubPhoneNumber;
    }

    /**
     * Sets BeaverScout Phone Number
     * @param cubPhoneNumber
     */
    public void setCubPhoneNumber(String cubPhoneNumber) {
        this.cubPhoneNumber = cubPhoneNumber;
    }

    /**
     * Returns Registration cost for a CubScout
     * @Override Scout calcRegistrationFee
     * @return 150.00
     */
    @Override
    public double calcRegistrationFee() {
        return 150.00;
    }

    /**
     * Returns the CubScout toString (Scout toString + CubScout toString)
     * @Override Scout toString
     * @return CubScout toString
     */
    @Override
    public String toString(){
        String cub = ("\n-----------CubScout------------");
        String str = ("Cubs Phone Number: " + cubPhoneNumber);
        str += ("\n-------------------------------");
        return cub + super.toString() + str + "\n";
    }

}
