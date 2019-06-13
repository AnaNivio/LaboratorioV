package classes;
import classes.City;

public class Location {
    private int idLocation;
    private String name;
    private City city;

    public Location(int idLocation, String name, City city) {
        this.idLocation = idLocation;
        this.name = name;
        this.city = city;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "idLocation=" + idLocation +
                ", name='" + name + '\'' +
                ", city=" + city.toString() +
                '}';
    }
}
