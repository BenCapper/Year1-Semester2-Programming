/**
 *This Class creates an instance of a division with user input information
 * includes getters and setters to edit information from other classes.
 *@author Ben Capper
 */
public class Division {
    /**
     *These fields are used to create a division object and are assigned values by the user.
     */
    private String divisionName, divisionAddress, divisionPhone, divisionLeader, divisionEmail;

    /**
     *This constructor method constructs a Division object and includes validation to ensure user adheres to Division creation standards.
     * @param divisionName, divisionAddress, divisionPhone, divisionLeader, divisionEmail
     */
    public Division(String divisionName, String divisionAddress, String divisionPhone, String divisionLeader, String divisionEmail) {
        this.divisionName = divisionName;
        if (this.divisionName.length() > 40) { // if division name is more than 40 chars, store invalid
            this.divisionName = "invalid";
        }
        this.divisionAddress = divisionAddress;
        if (this.divisionAddress.length() > 60) { // if division name is more than 60 chars, store invalid
            this.divisionAddress = "invalid";
        }
        this.divisionPhone = divisionPhone;
        if (!divisionPhone.matches("[0-9]+")) { // if user input is not a number, store Unknown Number
            this.divisionPhone = "Unknown Number.";
        }
        this.divisionLeader = divisionLeader;

        this.divisionEmail = divisionEmail;
        if (!divisionEmail.contains("@") || !divisionEmail.contains(".")) { // if division email does not contain @ and . , store Unknown Email Format.
            this.divisionEmail = "Unknown Email Format.";
        }
    }
    /**
     *Returns division name.
     * @return divisionName
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     *Sets new division name.
     * @param divisionName
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    /**
     *Returns division address.
     * @return divisionAddress
     */
    public String getDivisionAddress() {
        return divisionAddress;
    }

    /**
     *Sets new division address.
     * @param divisionAddress
     */
    public void setDivisionAddress(String divisionAddress) {
        this.divisionAddress = divisionAddress;
    }

    /**
     *Returns division phone number.
     * @return divisionPhone
     */
    public String getDivisionPhone() {
        return divisionPhone;
    }

    /**
     *Sets new division phone number.
     * @param divisionPhone
     */
    public void setDivisionPhone(String divisionPhone) {
        this.divisionPhone = divisionPhone;
    }

    /**
     *Returns division leader.
     * @return divisionLeader
     */
    public String getDivisionLeader() {
        return divisionLeader;
    }

    /**
     *Sets new division leader.
     * @param divisionLeader
     */
    public void setDivisionLeader(String divisionLeader) {
        this.divisionLeader = divisionLeader;
    }

    /**
     *Returns division email address.
     * @return divisionEmail
     */
    public String getDivisionEmail() {
        return divisionEmail;
    }

    /**
     *Sets new division email.
     * @param divisionEmail
     */
    public void setDivisionEmail(String divisionEmail) {
        this.divisionEmail = divisionEmail;
    }

    /**
     *Return Division toString.
     * @return Division toString
     */
    public String toString() {
        return  "Division Name = " + divisionName  +
                " | Division Address = " + divisionAddress +
                " | Division Phone = " + divisionPhone  +
                " | Division Leader = " + divisionLeader +
                " | Division Email = " + divisionEmail ;
    }
}

