import dk.roninit.Acquirer;
import dk.roninit.AcquirerHierarchy;
import dk.roninit.AcquirerHierarchyVisitor;
import dk.roninit.AcquirerHierarchyVisitorImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Acquirer acquirerChild = new Acquirer(1, "Acquirer Child", "1.street");
        AcquirerHierarchy[] acquirers = new AcquirerHierarchy[]{acquirerChild,new Acquirer(2, "Acquirer Parent", "Street 2")};
        Acquirer total = performInherits(acquirerChild, acquirers);
        System.out.println("Total Cost = "+total);
    }


    private static Acquirer performInherits(Acquirer acquirerChild, AcquirerHierarchy[] acquierHierarchy) {
        AcquirerHierarchyVisitor visitor = new AcquirerHierarchyVisitorImpl(acquirerChild);
        Acquirer sum=null;
        for(AcquirerHierarchy item : acquierHierarchy){
            sum = item.accept(visitor);
        }
        return sum;
    }
}
