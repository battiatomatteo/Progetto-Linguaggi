package progetto.value;

import progetto.exception.CastException;
import progetto.type.ExpType;
import progetto.type.SimpleType;
import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public class CharValue extends ExpValue<Character> {

    public CharValue(Character value) {
        super(value);
    }

    @Override
    public ExpValue<?> cast(ExpType type) {
        if (!checkCast(type)) {
            return null;
        }
        return switch ((SimpleType) type) {
            case SimpleType.CHAR -> this;
            case SimpleType.STRING -> castToStringValue();
            case SimpleType.INT -> castToIntValue();
            case SimpleType.DEC -> castToDecValue();
            case SimpleType.BOOL -> castToBoolValue();
            default -> null;
        };
    }


    private boolean checkCast(ExpType destType) {
        SimpleType thisType = SimpleType.fromValue(this);
        //System.out.println("tipo destinazione: " + thisType);
        if (!thisType.isCastable(destType)) {
            return false;
        }
        if (!isSafeCast(destType)) {
            FormattedLogs.println(OutputColor.YELLOW,"Unsafe cast from " + thisType + " to " + destType);
        }
        return true;
    }

    private boolean isSafeCast(ExpType type) {
        return switch (type) {
            case SimpleType.CHAR, SimpleType.STRING -> true;
            case SimpleType.BOOL, SimpleType.INT, SimpleType.DEC -> false;
            default -> throw new CastException("type not supported");
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
