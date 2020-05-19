import java.util.ArrayList;

/**
 * Event is an abstract Class which implements iEventMember
 * iEventMember forces each extension of Event to have a calcLocationCost and calcEquipCost methods
 * allows for the creation of Event subClasses
 * @author Ben Capper
 */
public abstract class Event implements iEventMember {

    /**
     * Event attributes initialized
     * Each Event has an arrayList of Equipment
     */
    protected String date, location, duration;
    protected double cost;
    protected ArrayList<Equipment> equipment;

    /**
     * Event constructor
     * @param date,location,duration,cost
     */
    public Event(String date, String location, String duration, double cost) {
        this.date = date;
        this.location = location;
        this.duration = duration;
        this.cost = cost;
        this.equipment = new ArrayList<>();
    }

    /**
     * Returns Event Date
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets Event Date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns Event Location
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets Event Location
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns Event Duration
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets Event Duration
     * @param duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Returns Event Cost
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets Event Cost
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns Event Equipment
     * @return equipment
     */
    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    /**
     * Sets Event Equipment
     * @param equipment
     */
    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }

    /**
     * Adds Equipment object to equipment arrayList
     * @param equipment
     */
    public void addEquipmentToList(Equipment equipment) {
        this.equipment.add(equipment);
    }

    /**
     * Cycles through arrayList of equipment and adds each equipment object toString to a variable
     * then returns the String of Equipment
     * @param equipment
     * @return equip
     */
    public String displayEquipment(ArrayList equipment) {
        String equip = "";
        for (int i = 0; i < equipment.size(); i++) {
            equip += equipment.get(i).toString();
        }
        return equip;
    }

    /**
     * Returns the Event toString
     * @return Event
     */
    @Override
    public String toString() {
        String str = "";
        str += ("Date: " + date + "\n");
        str += ("Location: " + location + "\n");
        str += ("Duration: " + duration + "\n");
        str += ("Location Cost: " + cost + " euro\n");
        str += (displayEquipment(getEquipment()));
        return str;
    }
}
