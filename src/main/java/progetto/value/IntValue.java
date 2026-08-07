package progetto.value;

import progetto.type.ExpType;
import progetto.type.SimpleType;

public class IntValue extends NumValue<Integer> {

    public IntValue(Integer value) {
        super(value);
    }

    public ExpValue<?> cast(ExpType type){
        if(!super.checkCast(type)) {
            return null;
        }
        return switch (type){
            case SimpleType.STRING -> super.castToStringValue();
            case SimpleType.CHAR -> super.castToCharValue();
            case SimpleType.BOOL -> super.castToBoolValue() ;
            case SimpleType.DEC -> castToDecValue();
            case SimpleType.INT -> this;
            default -> null;
        };
    }

    private ExpValue<?> castToDecValue() {
           return new DecValue(Double.valueOf(this.toJavaValue()));
    }
}