/**
 * Special Interest allows the creation of a Special Interest object
 * @author Ben Capper
 */
public class SpecialInterest {

    /**
     * Special Interest attributes initialized
     */
    private String interestCategory, details, dateBadgeReceived;

    /**
     * Special Interest constructor
     * @param interestCategory,details,dateBadgeRecieved
     */
    public SpecialInterest (String interestCategory, String details, String dateBadgeReceived){
        this.interestCategory = interestCategory;
        this.details = details;
        this.dateBadgeReceived = dateBadgeReceived;
    }

    /**
     * Returns Special Interest Interest Category
     * @return interestCategory
     */
    public String getInterestCategory() {
        return interestCategory;
    }

    /**
     * Sets Special Interest Interest Category
     * @param interestCategory
     */
    public void setInterestCategory(String interestCategory) {
        this.interestCategory = interestCategory;
    }

    /**
     * Returns Special Interest Details
     * @return details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets Special Interest Details
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Returns Special Interest Badge Received Date
     * @return dateBadgeReceived
     */
    public String getDateBadgeReceived() {
        return dateBadgeReceived;
    }

    /**
     * Sets Special Interest Received Date
     * @param dateBadgeReceived
     */
    public void setDateBadgeReceived(String dateBadgeReceived) {
        this.dateBadgeReceived = dateBadgeReceived;
    }

    /**
     * Returns the Special Interest toString
     * @return Special Interest
     */
    @Override
    public String toString() {
        String interest = "";
        interest += ("\n----Special Interest----" + "\n");
        interest += (" Interest Category: " + interestCategory + "\n");
        interest += (" Details: " + details + "\n");
        interest += (" Badge Received on: " + dateBadgeReceived + "\n");
        interest += ("------------------------" + "\n");
        return interest;
    }
}
