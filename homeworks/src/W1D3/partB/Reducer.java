package W1D3.partB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Reducer {

    private final int id;
    private List<GroupByPair> groupByPairs;
    private List<Pair<String, Pair<Integer, Integer>>> mappedData;
    private List<Pair<String, Double>> reducedList;

    public Reducer(int index) {
        id = index;
        reducedList = new ArrayList<>();
        mappedData = new ArrayList<>();
        groupByPairs = new ArrayList<>();
    }

    public void groupingByPairs(Pair<String, Pair<Integer, Integer>> item) {
        Optional<GroupByPair> el = groupByPairs.stream().filter(x -> x.getKey().equals(item.getKey())).findFirst();
        if (!el.isPresent()) {
            groupByPairs.add(new GroupByPair(item.getKey(), item.getValue()));
        } else {
            el.get().addValue(item.getValue());
        }
        mappedData.add(item);
    }

    public void reduce(GroupByPair pair) {
        double sumK = pair.getValue().stream().mapToInt(i -> i.getKey()).sum();
        double sumV = pair.getValue().stream().mapToInt(i -> i.getValue()).sum();
        double value = sumV == 0 ? 0 : sumK / sumV;
        reducedList.add(new Pair<>(pair.getKey(), value));
    }

    public List<GroupByPair> getGroupByPairs() {
        return groupByPairs;
    }

    public void reduceGroups() {
        groupByPairs.forEach(this::reduce);
    }

    public List<Pair<String, Double>> getReducedList() {
        return reducedList;
    }

    public List<Pair<String, Pair<Integer, Integer>>> getMappedData() {
        return mappedData;
    }

    public int getId() {
        return id;
    }

    public void sortGroupedPairs() {
        groupByPairs.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }

    public void sortMappedData() {
        mappedData.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }
}
