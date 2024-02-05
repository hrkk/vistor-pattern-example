package dk.roninit;

public interface AcquirerHierarchy {

    public Acquirer accept(AcquirerHierarchyVisitor visitor);
}
