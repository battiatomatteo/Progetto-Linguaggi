package progetto.type;

import progetto.value.*;
import java.util.ArrayList;

public enum ArrayType implements ExpType {
    INT("int[]"),
    DEC("dec[]"),
    BOOL("bool[]"),
    STRING("string[]"),
    CHAR("char[]");

    private final String name;

    ArrayType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ArrayType." + name();
    }

    public static ArrayType fromString(String str) {
        return switch (str) {
            case "int[]" -> INT;
            case "dec[]" -> DEC;
            case "bool[]" -> BOOL;
            case "string[]" -> STRING;
            case "char[]" -> CHAR;
            default -> null;
        };
    }

    // nuova funzione utile al nuovo visitDecl
    public static ArrayType fromSimpleType(SimpleType st) {
        return switch (st) {
            case SimpleType.INT -> ArrayType.INT;
            case SimpleType.DEC -> ArrayType.DEC;
            case SimpleType.BOOL -> ArrayType.BOOL;
            case SimpleType.STRING -> ArrayType.STRING;
            case SimpleType.CHAR -> ArrayType.CHAR;
        };
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isCompatible(Type type) {
        return this == type;
    }

    @Override
    public boolean isCastable(ExpType type) {
       return type instanceof ArrayType;
    }

    /*public static ArrayType fromValue(ExpValue<?> value) {
        if (value instanceof ArrayIntValue)
            return ArrayType.INT;
        if (value instanceof ArrayDecValue)
            return ArrayType.DEC;
        if (value instanceof ArrayBoolValue)
            return ArrayType.BOOL;
        if (value instanceof ArrayStringValue)
            return ArrayType.STRING;

        return null;
    }*/

    public static ArrayType fromValue(ExpValue<?> value) {

        //System.out.println("determino il tipo di  " + value.toString());
        if (!(value instanceof ArrayValue<?> arr)){
            System.out.println("Il tipo di  " + value + " non e' arrayValue");
            return null;
        }
        //System.out.println("Il tipo di  " + value + " e' arrayValue");

        ArrayList<?> list = arr.toJavaValue(); //

        if (list.isEmpty())
            return null; // oppure un tipo "unknown"

        Object first = list.get(0);

        if (first instanceof IntValue) return INT;
        if (first instanceof DecValue) return DEC;
        if (first instanceof BoolValue) return BOOL;
        if (first instanceof StringValue) return STRING;
        if (first instanceof CharValue) return CHAR;

        return null;
    }
    public static SimpleType toSimpleType(ArrayType type) {
         return switch (type) {
            case INT -> SimpleType.INT;
            case DEC -> SimpleType.DEC;
            case BOOL -> SimpleType.BOOL;
            case STRING ->SimpleType.STRING;
            case CHAR -> SimpleType.CHAR;
            default -> null;
        };
    }

}
