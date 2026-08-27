package progetto.value;

import progetto.type.ExpType;
import progetto.type.SimpleType;


public class StringValue extends ExpValue<String> {

    public StringValue(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public ExpValue<?> cast(ExpType type){
        if (!(type instanceof SimpleType simpleType)) {
            return null;
        }
        return switch (simpleType) {
            case SimpleType.STRING -> this;
            case SimpleType.CHAR -> castToCharValue();
            case SimpleType.INT -> castToIntValue();
            case SimpleType.DEC -> castToDecValue();
            case SimpleType.BOOL -> castToBoolValue();
            default -> null;
        };
    }


    private ExpValue<?> castToCharValue() {
        String value = this.toJavaValue();
        if (value == null) {
            return null;
        }
        return new CharValue(value.charAt(0));
    }

    private IntValue castToIntValue(){
        try {
            int i = Integer.parseInt(stringForCasting());
            return new IntValue(i);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    private DecValue castToDecValue(){
        try {
            double i = Double.parseDouble(stringForCasting());
            return new DecValue(i);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    private BoolValue castToBoolValue(){
        return switch (stringForCasting()) {
            case "true" ->  new BoolValue(true);
            case "false" ->  new BoolValue(false);
            default -> null;
        };
    }

    //stringa senza gli apici agli estremi che causano problemi con la conversione
    private String stringForCasting(){
        return this.toJavaValue();
    }
}
