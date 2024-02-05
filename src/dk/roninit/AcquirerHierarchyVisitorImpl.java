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
        System.out.println("Acquirer Name::" + acquirer.getName() + " id =" + acquirer.getId() + " streetName1=" + acquirer.getStreetName1());
        if (inherited.getStreetName1() == null) {
            inherited.setStreetName1(acquirer.getStreetName1());
        }
        return inherited;
    }
}
