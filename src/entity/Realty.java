package entity;

import java.util.List;

public class Realty {

    private long id;
    private String type;
    private String address;
    private int intersections = 0;

    public int getIntersections() {
        return intersections;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public void setIntersections(int intersections) {
        this.intersections = intersections;
    }
    public Realty(long id, String type, String address) {
        this.id = id;
        this.type = type;
        this.address = address;
    }

    public Realty() {
    }

    public static Realty findById(List<Realty> employees, long id) {
        return employees.stream()
                .filter(r -> r.id == id)
                .findFirst().orElse(new Realty());
    }
}
