package dk.roninit;

public interface AcquirerHierarchyVisitor {

    Acquirer visit(Acquirer acquirer);

    Acquirer getInherited();



}
