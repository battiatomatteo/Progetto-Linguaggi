package progetto.value;

import progetto.type.ExpType;
import progetto.type.SimpleType;

public class NumValue<T extends Number> extends ExpValue<T> {

    public NumValue(T value) {
        super(value);
    }

    public ExpValue<?> cast(ExpType type){
        if (!(type instanceof SimpleType simpleType)) {
            return null;
        }
        return switch (simpleType){
            case SimpleType.BOOL -> castToBoolValue();
            case SimpleType.STRING -> castToStringValue();
            case SimpleType.CHAR -> castToCharValue() ;
            case SimpleType.DEC, SimpleType.INT -> this;
            default -> null;
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
        };
    }


}
