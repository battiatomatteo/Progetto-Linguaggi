package progetto.value;

import progetto.exception.CastException;
import progetto.type.ExpType;
import progetto.type.SimpleType;
import progetto.utils.FormattedLogs;

public class BoolValue extends ExpValue<Boolean> {

    public BoolValue(Boolean value) {
        super(value);
    }

    public ExpValue<?> cast(ExpType type) {
        if (!checkCast(type)) {
            return null;
        }
        return switch (type) {
            case SimpleType.BOOL -> this;
            case SimpleType.CHAR -> castToCharValue();
            case SimpleType.STRING -> castToStringValue();
            case SimpleType.DEC -> castToDecValue();
            case SimpleType.INT -> castToIntValue();
            default -> null;
        };
    }

    private boolean checkCast(ExpType destType) {
        SimpleType thisType = SimpleType.fromValue(this);
        if (!thisType.isCastable(destType)) {
            return false;
        }
        if (!isSafeCast(destType)) {
            FormattedLogs.println(FormattedLogs.YELLOW,"Unsafe cast from " + thisType + " to " + destType);
        }
        return true;
    }
    private boolean isSafeCast(ExpType type) {
        return switch (type) {
            case SimpleType.BOOL, SimpleType.INT, SimpleType.DEC, SimpleType.STRING -> true;
            case SimpleType.CHAR -> false;
            default -> throw new CastException("type not supported");
        };

    }

    private StringValue castToStringValue(){
        return new StringValue(this.toString());
    }


    private IntValue castToIntValue(){
        return switch(this.toString()){
            case "false" -> new IntValue(0);
            case "true" -> new IntValue(1);
            default -> null;  // tecnicamente irraggiungibile visto che i valori sono true o false
        };
    }

    private DecValue castToDecValue(){
        return switch(this.toString()){
            case "false" -> new DecValue(0.0);
            case "true" -> new DecValue(1.0);
            default -> null;  // tecnicamente irraggiungibile visto che i valori sono true o false
        };
    }
    private CharValue castToCharValue(){
        return switch (this.toString()){
            case "true"-> new CharValue('1');
            case "false" ->  new CharValue('0');
            default -> null;  // caso irraggiungibile
        };
    }
}