package progetto.type;

public interface Type {

    /*
     * Check whether a value of type 'other' can be used where a current type value is required.
     */
    boolean isCompatible(Type other);
}

