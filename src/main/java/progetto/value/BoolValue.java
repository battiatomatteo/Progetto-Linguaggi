package progetto.value;

import progetto.type.ExpType;
import progetto.type.SimpleType;

public class BoolValue extends ExpValue<Boolean> {

    public BoolValue(Boolean value) {
        super(value);
    }

    public ExpValue<?> cast(ExpType type) {
        if (!(type instanceof SimpleType simpleType)) {
            return null;
        }
        return switch (simpleType) {
            case SimpleType.BOOL -> this;
            case SimpleType.CHAR -> castToCharValue();
            case SimpleType.STRING -> castToStringValue();
            case SimpleType.DEC -> castToDecValue();
            case SimpleType.INT -> castToIntValue();
            default -> null;
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