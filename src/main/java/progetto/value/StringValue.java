package progetto.value;

import progetto.exception.CastException;
import progetto.type.*;
import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;


public class StringValue extends ExpValue<String> {

    public StringValue(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public ExpValue<?> cast(ExpType type){
        if (!checkCast(type)) {
            return null;
        }
        return switch ((SimpleType) type) {
            case SimpleType.STRING -> this;
            case SimpleType.CHAR -> castToCharValue();
            case SimpleType.INT -> castToIntValue();
            case SimpleType.DEC -> castToDecValue();
            case SimpleType.BOOL -> castToBoolValue();
            default -> null;
        };
    }


    private boolean checkCast(ExpType destType) {
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
            case  SimpleType.BOOL,SimpleType.STRING, SimpleType.INT, SimpleType.DEC -> true;
            case SimpleType.CHAR -> false;
            default -> throw new CastException("type not supported");
        };
    }

    private ExpValue<?> castToCharValue() {
        return new CharValue(this.toJavaValue().charAt(0));
        /*
        if(this.toJavaValue().length() == 1){
            return new CharValue(this.toJavaValue().charAt(0));
        }
        else{
            System.out.println("La stringa deve avere lunghezza 1 per essere convertita in char");
            return null;
        }*/
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
           //default -> throw new RuntimeException("La stringa " + this.toJavaValue() + " non puo' essere convertita in valore booleano " );
       };
    }

    //stringa senza gli apici agli estremi che causano problemi con la conversione
    private String stringForCasting(){

        //return this.toJavaValue().substring(1,this.toJavaValue().length()-1);
        //Nuovo
        return this.toJavaValue();
        //
    }
}
