package W1D3.partA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Reducer {

    private final int id;
    private List<GroupByPair> groupByPairs;
    private List<Pair<String, Integer>> mappedData;
    private List<Pair<String, Integer>> reducedList;

    public Reducer(int index) {
        id = index;
        reducedList = new ArrayList<>();
        mappedData = new ArrayList<>();
        groupByPairs = new ArrayList<>();
    }

    public void groupingByPairs(Pair<String, Integer> item) {
        Optional<GroupByPair> el = groupByPairs.stream().filter(x -> x.getKey().equals(item.getKey())).findFirst();
        if (!el.isPresent()) {
            groupByPairs.add(new GroupByPair(item.getKey(), item.getValue()));
        } else {
            el.get().addValue(item.getValue());
        }
        mappedData.add(item);
    }

    public void reduce(GroupByPair pair) {
        int sum = pair.getValue().stream().mapToInt(i -> i).sum();
        reducedList.add(new Pair<>(pair.getKey(), sum));
    }

    public List<GroupByPair> getGroupByPairs() {
        return groupByPairs;
    }

    public void reduceGroups() {
        groupByPairs.forEach(this::reduce);
    }

    public List<Pair<String, Integer>> getReducedList() {
        return reducedList;
    }

    public List<Pair<String, Integer>> getMappedData() {
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
