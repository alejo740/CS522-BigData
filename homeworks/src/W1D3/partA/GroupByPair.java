package W1D3.partA;

import java.util.ArrayList;
import java.util.List;

public class GroupByPair extends Pair<String, List<Integer>> {

    public GroupByPair(String key) {
        super(key, new ArrayList<>());
    }

    public GroupByPair(String key, int value) {
        super(key, new ArrayList<>());
        addValue(value);
    }

    public void addValue(Integer p) {
        this.getValue().add(p);
    }
}
