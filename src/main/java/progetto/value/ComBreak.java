package progetto.value;

public class ComBreak extends ComValue {
    public static final ComBreak INSTANCE = new ComBreak();

    private ComBreak() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ComBreak;
    }
}
