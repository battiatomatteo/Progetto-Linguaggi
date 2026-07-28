package progetto.type;

import progetto.value.*;

public enum SimpleType implements ExpType {
    INT("int"),
    DEC("dec"),
    BOOL("bool"),
    STRING("string"),
    CHAR("char");

    private final String name;

    SimpleType(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public String toString() {
        return "SimpleType." + name();
    }

    @Override
    public boolean isCompatible(Type type) {
        return this == type;
    }

    @Override
    public boolean isCastable(ExpType type) {
       return type instanceof SimpleType;
    }

    public static SimpleType fromString(String str) {
        return switch (str) {
            case "int" -> SimpleType.INT;
            case "dec" -> SimpleType.DEC;
            case "bool" -> SimpleType.BOOL;
            case "string" -> SimpleType.STRING;
            case "char" -> SimpleType.CHAR;
            default -> null;
        };
    }

    public static SimpleType fromValue(ExpValue<?> value) {
        if (value instanceof IntValue)
            return SimpleType.INT;
        if (value instanceof DecValue)
            return SimpleType.DEC;
        if (value instanceof BoolValue)
            return SimpleType.BOOL;
        if (value instanceof StringValue)
            return SimpleType.STRING;
        if (value instanceof CharValue)
            return SimpleType.CHAR;
        //System.out.println("Il tipo di  " + value + " non e' SimpleType");
        return null;
    }
}
