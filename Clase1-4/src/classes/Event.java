package classes;
import classes.Location;

import java.util.Objects;


public class Event {
    private int idEvent;
    private String name;
    private Location location;


    public Event(int idEvent,String name,Location location){
        this.idEvent=idEvent;
        this.name=name;
        this.location=location;

    }

    public Event(){

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", name='" + name + '\'' +
                ", location=" + location.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getIdEvent() == event.getIdEvent() &&
                Objects.equals(getName(), event.getName()) &&
                Objects.equals(getLocation(), event.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEvent(), getName(), getLocation());
    }

    public int compareTo(Event b){

        return name.compareTo(b.getName());
    }


}
