package W1D2.partA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Reducer {

    private List<GroupByPair> groupByPairs;
    private List<Pair<String, Integer>> reducedList;

    public Reducer(List<Pair<String, Integer>> mappedData) {
        reducedList = new ArrayList<>();
        groupByPairs = new ArrayList<>();
        groupingByPairs(mappedData);
    }

    public void groupingByPairs(List<Pair<String, Integer>> mappedData) {
        for (Pair<String, Integer> item : mappedData) {
            Optional<GroupByPair> el = groupByPairs.stream().filter(x -> x.getKey().equals(item.getKey())).findFirst();
            if (!el.isPresent()) {
                groupByPairs.add(new GroupByPair(item.getKey(), item.getValue()));
            } else {
                el.get().addValue(item.getValue());
            }
        }
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
}
