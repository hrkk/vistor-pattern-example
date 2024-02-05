package dk.roninit;

public class AcquirerHierarchyVisitorImpl implements AcquirerHierarchyVisitor {

    private Acquirer inherited;

    public AcquirerHierarchyVisitorImpl(Acquirer child) {
        this.inherited = child;
    }

    public Acquirer getInherited() {
        return inherited;
    }

    @Override
    public Acquirer visit(Acquirer acquirer) {
        if (inherited.getId() == acquirer.getId()) {
            // self
            return inherited;
        }
        if (inherited.getStreetName1() == null && acquirer.getStreetName1() != null) {
            System.out.println("Inherit from ancestors = " + acquirer.getName());
            inherited.setStreetName1(acquirer.getStreetName1());
        } else if (inherited.getStreetName1() != null) {
            System.out.println("Field present on child - no inherit from ancestors = " + acquirer.getName());
        }
        return inherited;
    }
}
