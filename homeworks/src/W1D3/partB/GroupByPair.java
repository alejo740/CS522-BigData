package W1D3.partB;

import java.util.ArrayList;
import java.util.List;

public class GroupByPair extends Pair<String, List<Pair<Integer, Integer>>> {

    public GroupByPair(String key) {
        super(key, new ArrayList<>());
    }

    public GroupByPair(String key, Pair<Integer, Integer> value) {
        super(key, new ArrayList<>());
        addValue(value);
    }

    public void addValue(Pair<Integer, Integer> p) {
        this.getValue().add(p);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getKey()).append(" , ").append(getValue()).toString();
    }
}
