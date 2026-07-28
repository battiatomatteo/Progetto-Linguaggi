package progetto.type;

public class ComType implements Type {

    public static final ComType INSTANCE = new ComType();

    private ComType() { }

    @Override
    public boolean isCompatible(Type type) {
        return type instanceof ComType;
    }
}
