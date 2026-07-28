package progetto.value;

import progetto.type.ExpType;
import progetto.type.SimpleType;

public class DecValue extends NumValue<Double> {

    public DecValue(Double value) {
        super(value);
    }

    public ExpValue<?> cast(ExpType type){
        if(!super.checkCast(type)){
            return null;
        }
        return switch (type){
            case SimpleType.STRING -> super.castToStringValue();
            case SimpleType.CHAR -> super.castToCharValue();
            case SimpleType.BOOL -> super.castToBoolValue();
            case SimpleType.DEC -> this;
            case SimpleType.INT -> castToIntValue();
            default -> null;
        };
    }

    private ExpValue<?> castToIntValue() {
        return new IntValue((int)Math.floor(this.toJavaValue()));
    }
}