/**
 * Donator allows the creation of a donator object
 * @author Ben Capper
 */
public class Donator {

    /**
     * Donator attributes initialized
     */
    protected String name, phone, address, email;
    protected double donation;

    /**
     * Special Interest constructor
     * @param name,phone,address,email,donation
     */
    public Donator (String name, String phone, String address, String email, double donation){
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.donation = donation;
    }

    /**
     * Returns Donator name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Donator name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns Donator phone number
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets Donator phone number
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns Donator address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets Donator address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns Donator email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets Donator email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns Donator donation amount
     * @return donation
     */
    public double getDonation() {
        return donation;
    }

    /**
     * Sets Donator donation amount
     * @param donation
     */
    public void setDonation(double donation) {
        this.donation = donation;
    }

    /**
     * Returns the Donator toString
     * @return Donator
     */
    @Override
    public String toString() {
        String str = "";
        str += ("\n------------Donator------------\n");
        str += ("Name: " + name + "\n");
        str += ("Phone Number: " + phone + "\n");
        str += ("Address: " + address + "\n");
        str += ("Email: " + email + "\n");
        str += ("Donation: " + donation + " euro\n");
        str += ("-------------------------------\n");
        return str;
    }
}
