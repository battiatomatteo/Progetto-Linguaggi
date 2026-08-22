package progetto.value;

import progetto.exception.CastException;
import progetto.type.ExpType;
import progetto.type.SimpleType;
import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public class NumValue<T extends Number> extends ExpValue<T> {

    public NumValue(T value) {
        super(value);
    }

    public ExpValue<?> cast(ExpType type){
        if(!checkCast(type)) {
            return null;
        }
        return switch (type){
            case SimpleType.BOOL -> castToBoolValue();
            case SimpleType.STRING -> castToStringValue();
            case SimpleType.CHAR -> castToCharValue() ;
            case SimpleType.DEC, SimpleType.INT -> this;

            default -> null;
        };
    }

    protected boolean checkCast(ExpType destType) {
        SimpleType thisType = SimpleType.fromValue(this);
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
            case SimpleType.INT, SimpleType.DEC, SimpleType.STRING-> true;
            case SimpleType.CHAR, SimpleType.BOOL  -> false;
            default -> throw new CastException("type not supported");
        };

    }

    protected ExpValue<?> castToCharValue() {
        double i;
        try {
            i = Double.parseDouble(this.toString());
        } catch (NumberFormatException e) {
            return null;
        }
        i = Math.floor(i);
        if( i >= 0 && i <= 9 ){
           return new CharValue(String.valueOf(i).charAt(0));
        }
        else {
            return null;
        }
    }

    protected StringValue castToStringValue(){
        return new StringValue(this.toString());
    }

    protected BoolValue castToBoolValue() {
        double num;
        try {
            num = Double.parseDouble(this.toString());
        }catch (NumberFormatException e){
            return null;
        }
        int i = (int) num;
        return switch (i) {
            case 0 -> new BoolValue(false);
            case 1 -> new BoolValue(true);
            default -> null;
            //default -> throw new RuntimeException("La stringa " + this.toJavaValue() + " non puo' essere convertita in valore booleano ");
        };
    }


}
