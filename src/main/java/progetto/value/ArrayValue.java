package progetto.value;

import progetto.exception.CastException;
import progetto.type.ArrayType;
import progetto.type.ExpType;
import progetto.type.SimpleType;
import progetto.utils.FormattedLogs;

import java.util.ArrayList;

public class ArrayValue<T extends ExpValue<?>> extends ExpValue<ArrayList<T>> {

    public ArrayValue() {
        super(new ArrayList<>());
    }
    //Deve essere un contenitore di ArrayList<ExpValue<?>>, non di un singolo valore.
    @Override
    public ArrayList<T> toJavaValue() {
        return super.toJavaValue();
    }

    ArrayValue(ArrayList<T> array) {
        super(array);
    }

    @Override
    public ExpValue<?> cast(ExpType type) {
        if (!checkCast(type)) {
            return null;
        }
        SimpleType st = ArrayType.toSimpleType((ArrayType) type);
        if (st == null) {
            return null;
        }
        else{
            return castTo(st);
        }
    }


    private boolean checkCast(ExpType destType) {
        ArrayType thisType = ArrayType.fromValue(this);
        if (!thisType.isCastable(destType)) {
            return false;
        }
        if (!isSafeCast(destType)) {
            FormattedLogs.println(FormattedLogs.YELLOW,"Unsafe cast from " + thisType + " to " + destType);
        }
        return true;
    }

    private boolean isSafeCast(ExpType type) {
        return true;
    }


    private ArrayValue<ExpValue<?>> castTo(SimpleType type) {
        ArrayValue<ExpValue<?>> array = new ArrayValue<>();
        ArrayList<T> value = this.toJavaValue();
        //System.out.println("Il tipo dell'array e' " + type);
        for (int i = 0; i < value.size(); i++) {

            try{
                ExpValue<?> element = value.get(i);
                //System.out.println("guardo l'elemento " + i + " " + element);
                ExpValue<?> casted = element.cast(type);
                //System.out.println("elemento " + i + " convertito in  " + casted);
                array.toJavaValue().add(casted);
                //System.out.println("elemento " + i + " salvato nel nuovo oggetto  " + array.toJavaValue().get(i));
            }
            catch(Exception e){
                //System.out.println("errore nella conversione a indice" + i);
                //System.out.println(e.getMessage());
                return null;
            }
        }
        //System.out.println("array convertito in  " + array.toJavaValue());
        return array;
    }


}
