import dk.roninit.Acquirer;
import dk.roninit.AcquirerHierarchy;
import dk.roninit.AcquirerHierarchyVisitor;
import dk.roninit.AcquirerHierarchyVisitorImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Example with NO inherits");
        Acquirer acquirerChild = new Acquirer(1, "Acquirer Child", "Child Street");
        Acquirer parent = new Acquirer(2, "Acquirer Parent", "Parent Street");
        Acquirer grandParent = new Acquirer(3, "Acquirer GrandParent", "Grand parent street");
        AcquirerHierarchy[] acquirers = new AcquirerHierarchy[]{acquirerChild, parent, grandParent};
        Acquirer childWithInheritance = performInherits(acquirerChild, acquirers);
        System.out.println("Acquirer child has NO inherited fields = " + childWithInheritance);


        System.out.println("Example with inherits from parent");
        acquirerChild = new Acquirer(1, "Acquirer Child", null); // empty street name
        parent = new Acquirer(2, "Acquirer Parent", "Parent Street");
        grandParent = new Acquirer(3, "Acquirer GrandParent", "Grand parent street");
        acquirers = new AcquirerHierarchy[]{acquirerChild, parent, grandParent};
        childWithInheritance = performInherits(acquirerChild, acquirers);
        System.out.println("Acquirer child with inherited fields from parent = " + childWithInheritance);

        System.out.println("Example with inherits from grand parent");
        acquirerChild = new Acquirer(1, "Acquirer Child", null); // empty street name
        parent = new Acquirer(2, "Acquirer Parent", null); // empty street name
        grandParent = new Acquirer(3, "Acquirer GrandParent", "Grand parent street");
        acquirers = new AcquirerHierarchy[]{acquirerChild, parent, grandParent};
        childWithInheritance = performInherits(acquirerChild, acquirers);
        System.out.println("Acquirer child with inherited fields from grandparent = " + childWithInheritance);
    }


    private static Acquirer performInherits(Acquirer acquirerChild, AcquirerHierarchy[] acquierHierarchy) {
        AcquirerHierarchyVisitor visitor = new AcquirerHierarchyVisitorImpl(acquirerChild);
        for (AcquirerHierarchy item : acquierHierarchy) {
            item.accept(visitor);
        }
        return visitor.getInherited();
    }
}
