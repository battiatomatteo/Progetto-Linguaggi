package progetto.value;

import progetto.type.ArrayType;
import progetto.type.ExpType;
import progetto.type.SimpleType;

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
        if (!(type instanceof ArrayType arrayType)) {
            return null;
        }
        SimpleType st = ArrayType.toSimpleType(arrayType);
        if (st == null) {
            return null;
        }
        return castTo(st);
    }


    private ArrayValue<ExpValue<?>> castTo(SimpleType type) {
        ArrayValue<ExpValue<?>> array = new ArrayValue<>();
        ArrayList<T> value = this.toJavaValue();
        for (T t : value) {
            ExpValue<?> casted = t.cast(type);
            if (casted == null) {
                return null;
            }
            array.toJavaValue().add(casted);
        }
        return array;
    }


}
