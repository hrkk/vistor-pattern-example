package dk.roninit;

public class Acquirer implements AcquirerHierarchy {

    private int id;
    private String name;

    private String streetName1;

    public Acquirer(int id, String name, String streetName1) {
        this.id = id;
        this.name = name;
        this.streetName1 = streetName1;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreetName1() {
        return streetName1;
    }

    public void setStreetName1(String streetName1) {
        this.streetName1 = streetName1;
    }

    @Override
    public void accept(AcquirerHierarchyVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Acquirer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", streetName1='" + streetName1 + '\'' +
            '}';
    }
}
