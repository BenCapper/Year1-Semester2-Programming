import java.util.ArrayList;

/**
 * ScoutEvent is an extension of Event
 * Allows for the creation of a ScoutEvent Object
 * @author Ben Capper
 */
public class ScoutEvent extends Event {

    /**
     * activity and scoutsInvited arrayList initialized
     */
    protected String activity;
    protected ArrayList<Scout> scoutsInvited;

    /**
     * Constructor using attributes from Event and ScoutEvent Classes
     * @param date,location,duration,cost,activity
     */
    public ScoutEvent(String date, String location, String duration, double cost, String activity) {
        super(date, location, duration, cost);
        this.activity = activity;
        this.scoutsInvited = new ArrayList<>();
    }

    /**
     * Returns Scouts Invited to the Event
     * @return scoutsInvited
     */
    public ArrayList<Scout> getScoutsInvited() {
        return scoutsInvited;
    }

    /**
     * Sets Scouts Invited to the Event
     * @param scoutsInvited
     */
    public void setScoutsInvited(ArrayList<Scout> scoutsInvited) {
        this.scoutsInvited = scoutsInvited;
    }

    /**
     * Cycles through arrayList of Scouts and adds each Scout object toString to a variable
     * then returns the String of Scouts
     * @param scoutsInvited
     * @return invited
     */
    public String display(ArrayList scoutsInvited){
        String invited = "";
        for (int i = 0; i < scoutsInvited.size(); i++) {
            invited = invited + scoutsInvited.get(i).toString();
        }
        return invited;
    }

    /**
     * Adds Scout object to scoutsInvited arrayList
     * @param scoutGroup
     */
    public void addScoutGroup(Scout scoutGroup) {
        scoutsInvited.add(scoutGroup);
    }

    /**
     * Returns Event activity
     * @return activity
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Sets Event activity
     * @param activity
     */
    public void setActivity(String activity) {
        this.activity = activity;
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
            cost += getEquipment().get(i).getCost() * getEquipment().get(i).getAmount();
        }
        return cost;
    }

    /**
     * Returns ScoutEvent toString (Event toString + ScoutEvent toString)
     * @return ScoutEvent
     * @Override Event toString
     */
    @Override
    public String toString() {
        String str = "";
        String end = "";
        str += ("\n-----------Scout Event-----------\n");
        str += ("Activity: " + activity + "\n");
        end += ("\n\n --------Scouts Invited------- \n" + display(getScoutsInvited()));
        end += ("-------------------------------\n");
        return str + super.toString() + end;
    }


}