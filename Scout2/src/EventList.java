import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * EventList stores methods to be used on an ArrayList of Events
 * @author Ben Capper
 */
public class EventList {

    /**
     * Initializes ArrayList of Events
     */
    protected ArrayList<Event> events = new ArrayList<>();

    /**
     * Adds an Event object to the ArrayList
     * @param event
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Removes an Event from the ArrayList, specified by user
     * @param eventIndex
     */
    public boolean removeEvent(int eventIndex) {
        if (events.size() < eventIndex) {
            return false;
        } else {
            events.remove(eventIndex);
            return true;
        }
    }

    /**
     * Returns the amount of Event objects in the ArrayList
     * @return numberOfEvents
     */
    public int numberOfEvents() {
        return events.size();
    }

    /**
     * Returns an Event object in the ArrayList, specified by User
     * @param eventIndex
     * @return Event
     */
    public Event getEvent(int eventIndex) {
        if ((eventIndex >= 0) && (eventIndex <= events.size())) {
            Event userEvent = events.get(eventIndex);
            return userEvent;
        } else {
            return null;
        }
    }



    //----------------------------------------------LISTS------------------------------------------------//

    /**
     * Lists toStrings of all Events contained in the ArrayList
     * @return allEvents
     */
    public String listAllEvents() {
        if (events.size() != 0) {
            String list = "";
            for (int i = 0; i < events.size(); i++) {
                list = list + i + ": " + events.get(i) + "\n";
            }
            return list;
        } else {
            return "\n-------------------------------\nThere are no Scheduled Events\n-------------------------------\n";
        }
    }

    /**
     * Lists all Fundraise Events in the ArrayList
     * @return fundraiseEvents
     */
    public String listFundEvent() {
        String list = "";
        if (events.size() != 0) {
            for (int i = 0; i < events.size(); i++) {
                if (events.get(i) instanceof FundraiseEvent) {
                    list = list + i + ": " + events.get(i) + "\n";
                }
            }
        } else {
            return "\n-------------------------------\nThere are no Scheduled Fundraising Events\n-------------------------------\n";
        }
        return list;
    }

    /**
     * Lists all Scout Events in the ArrayList
     * @return scoutEvents
     */
    public String listScoutEvent() {
        String list = "";
        if (events.size() != 0) {
            for (int i = 0; i < events.size(); i++) {
                if (events.get(i) instanceof ScoutEvent) {
                    list = list + i + ": " + events.get(i) + "\n";
                }
            }
        } else {
            return "\n-------------------------------\nThere are no Scheduled Scout Events\n-------------------------------\n";
        }
        return list;
    }

    /**
     * Lists all Donators in the ArrayList
     * @return donators
     */
    public String listDonators() {
        String list = "";
        if (events.size() != 0) {
            for (int i = 0; i < events.size(); i++) {
                if (events.get(i) instanceof FundraiseEvent)
                list = list + i + ": " + ((FundraiseEvent) events.get(i)).getDonators() + "\n";
            }
        } else {
            return "\n-------------------------------\nThere are no Donators Registered\n-------------------------------\n";
        }
        return list;
    }

    //------------------------------------------LISTS END------------------------------------------------//



    //------------------------------------------UPDATE---------------------------------------------------//

    /**
     * Updates a Fundraise Event, specified by User
     * @param index,name,date,location,duration,cost
     */
    public void updateFundEvent(int index, String name, String date, String location, String duration, int cost) {
        Event e = events.get(index);
        ((FundraiseEvent) e).setName(name);
        e.setDate(date);
        e.setLocation(location);
        e.setDuration(duration);
        e.setCost(cost);
    }

    /**
     * Updates a Scout Event, specified by User
     * @param index,activity,date,location,duration,cost
     */
    public void updateScoutEvent(int index, String activity, String date, String location, String duration, int cost) {
        Event b = events.get(index);
        ((ScoutEvent) b).setActivity(activity);
        b.setDate(date);
        b.setLocation(location);
        b.setDuration(duration);
        b.setCost(cost);
    }
  //-----------------------------------------UPDATE END------------------------------------------------//

  //----------------------------------------PERSISTENCE------------------------------------------------//
    /**
     * Saves all Events to .xml file
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("events.xml"));
        out.writeObject(events);
        out.close();
    }

    /**
     * Loads all Events from .xml file
     */
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("events.xml"));
        events = (ArrayList<Event>) is.readObject();
        is.close();
    }
}


