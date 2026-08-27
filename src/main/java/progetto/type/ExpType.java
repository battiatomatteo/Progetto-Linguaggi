package progetto.type;

import progetto.value.ExpValue;

public interface ExpType extends Type {

    String getName();
    boolean isCastable(ExpType type);
    boolean isSafeCast(ExpType type);
    static ExpType fromValue(ExpValue<?> value){
        SimpleType type = SimpleType.fromValue(value);
        if (type != null) {
            return type;
        }
        ArrayType arrayType = ArrayType.fromValue(value);
        if (arrayType != null) {
            return arrayType;
        }
        System.out.println("tipo non esistente");
        return null;
    }
}
