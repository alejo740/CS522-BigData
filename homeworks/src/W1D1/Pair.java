package W1D1;

public class Pair<T> {

    private T key;
    private int value;

    public Pair(T key, int value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return new StringBuilder().append("(").append(key).append(", ").append(value).append(")\n").toString();
    }
}
