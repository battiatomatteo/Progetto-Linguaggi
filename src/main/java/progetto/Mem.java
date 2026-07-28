package progetto;

import progetto.type.ArrayType;
import progetto.type.ExpType;
import progetto.type.SimpleType;
import progetto.value.*;

import java.util.HashMap;
import java.util.Map;

public class Mem {

    private final Map<String, ExpValue<?>> values = new HashMap<>();
    private final Map<String, ExpType> types = new HashMap<>();

    public boolean contains(String id) {
        return values.containsKey(id) && values.get(id) != null;
    }

    public ExpValue<?> getValue(String id) {
        return values.get(id);
    }

    public ExpType getType(String id) {
        return types.get(id);
    }

    public void updateValue(String id, ExpValue<?> v) { values.put(id, v); }

    public void add(String id, ExpValue<?> v) {
        values.put(id, v);

        //simple data
        if (v instanceof BoolValue)
            types.put(id, SimpleType.BOOL);
        else if (v instanceof IntValue)
            types.put(id, SimpleType.INT);
        else if (v instanceof DecValue)
            types.put(id, SimpleType.DEC);
        else if (v instanceof StringValue)
            types.put(id, SimpleType.STRING);

        // array data
        /*if (v instanceof ArrayBoolValue)
            types.put(id, ArrayType.BOOL);
        if (v instanceof ArrayIntValue)
            types.put(id, ArrayType.INT);
        if (v instanceof ArrayDecValue)
            types.put(id, ArrayType.DEC);
        if (v instanceof ArrayStringValue)
            types.put(id, ArrayType.STRING);*/
        else if (v instanceof ArrayValue<?> arr) {
            ArrayType t = ArrayType.fromValue(arr);
            types.put(id, t);
        }
    }

    public void add(String id, ExpType t) {
        values.put(id, null);
        types.put(id, t);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (String var : values.keySet())
            sb.append(var).append("[").append(types.get(var).getName()).append("]:").append(values.get(var)).append(" ");
        sb.append("}");
        return sb.toString();
    }
}
