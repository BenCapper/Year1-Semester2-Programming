import java.util.ArrayList;

/**
 * FundraiseEvent is an extension of Event
 * Allows for the creation of a FundraiseEvent Object
 * @author Ben Capper
 */
public class FundraiseEvent extends Event {

    /**
     * name and donator arrayList initialized
     */
    protected String name;
    protected ArrayList <Donator> donators;

    /**
     * Constructor using attributes from Event and FundraiseEvent Classes
     * @param name,location,duration,cost,date
     */
    public FundraiseEvent (String name, String location, String duration, double cost, String date){
        super(date,location,duration,cost);
        this.name = name;
        this.donators = new ArrayList<>();
    }

    /**
     * Returns Donators Invited to the Event
     * @return donators
     */
    public ArrayList<Donator> getDonators() {
        return donators;
    }

    /**
     * Sets Donators Invited to the Event
     * @param donators
     */
    public void setDonators(ArrayList<Donator> donators) {
        this.donators = donators;
    }

    /**
     * Cycles through arrayList of Donators and adds each Donator object toString to a variable
     * then returns the String of Donators
     * @param donators
     * @return donator
     */
    public String displayDonator(ArrayList donators) {
        String donator = "";
        for (int i = 0; i < donators.size(); i++) {
            donator += donator + donators.get(i).toString();
        }
        return donator;
    }

    /**
     * Adds Donator object to donators arrayList
     * @param donator
     */
    public void addDonatorToList(Donator donator) {
        this.donators.add(donator);
    }

    /**
     * Returns Event name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Event name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns Event Location Cost
     * @return cost
     */
    @Override
    public double calcLocationCost() {
        return getCost();
    }

    /**
     * Cycles through each equipment object
     * Multiplies the cost by amount
     * Returns the cost of all equipment
     * @return cost
     */
    @Override
    public double calcEquipCost() {
        double cost = 0;
        for (int i = 0; i < equipment.size() ; i++) {
            cost += getEquipment().get(i).getCost();
        }
        return cost;
    }

    /**
     * Returns FundraiseEvent toString (Event toString + FundraiseEvent toString)
     * @return FundraiseEvent
     * @Override Event toString
     */
    @Override
    public String toString() {
        String str="";
        String str2="";
        String end = "";
        str += ("\n--------Fundraise Event--------\n");
        str += ("Name: " + name + "\n");
        str2 += ("\n"+ displayDonator(getDonators()));

        str2 += ("-------------------------------");
        return str + super.toString() + str2;
    }
}
