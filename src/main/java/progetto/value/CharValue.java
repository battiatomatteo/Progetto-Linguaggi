package progetto.value;

import progetto.type.ExpType;
import progetto.type.SimpleType;

public class CharValue extends ExpValue<Character> {

    public CharValue(Character value) {
        super(value);
    }

    @Override
    public ExpValue<?> cast(ExpType type) {
        if (!(type instanceof SimpleType simpleType)) {
            return null;
        }
        return switch (simpleType){
            case SimpleType.CHAR -> this;
            case SimpleType.STRING -> castToStringValue();
            case SimpleType.INT -> castToIntValue();
            case SimpleType.DEC -> castToDecValue();
            case SimpleType.BOOL -> castToBoolValue();
            default -> null;
        };
    }

    private ExpValue<?> castToBoolValue() {
        return switch (this.toJavaValue()) {
            case '0', 'F', 'f', 'N', 'n' -> new BoolValue(false);
            case '1', 'T', 't', 'Y', 'y' -> new BoolValue(true);
            default -> null;
        };
    }

    private ExpValue<?> castToDecValue() {
        try {
            double i = Double.parseDouble(this.toString());
            return new DecValue(i);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private ExpValue<?> castToIntValue() {
        try {
            int i = Integer.parseInt(this.toString());
            return new IntValue(i);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private ExpValue<?> castToStringValue() {
        return new StringValue(this.toString());
    }
}
