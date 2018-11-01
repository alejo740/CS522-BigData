package W1D3.partB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapper {

    private Map<String, Pair<Integer, Integer>> outputMap;
    private List<Pair<String, Pair<Integer, Integer>>> splits;
    private String scapeRegex = "[\\W+,-.]|(\\w+[\\._]\\w+)|\\\"|([A-Za-z]+[\\d]+[\\w]*)|\\d";
    private String fileName;
    private List<String> stringLines;
    private int id;

    public Mapper(String fileName, int index) {
        id = index;
        this.fileName = fileName;
        outputMap = new HashMap<>();
        readFile();
        stringLines.forEach(x -> System.out.println(x));
    }

    private void readFile() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stringLines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void map() {
        stringLines.stream().map(x -> x.split(scapeRegex))
                .flatMap(Arrays::stream)
                .filter(x -> !x.isEmpty())
                .forEach(x -> outputMap.merge(String.valueOf(x.charAt(0)).toLowerCase(), new Pair<>(x.length(), 1), (a, b) -> {
                    int k = a.getKey() + b.getKey();
                    int v = a.getValue() + b.getValue();
                    return new Pair<>(k, v);
                }));
    }

    public void close() {
        splits = outputMap.entrySet().stream()
                .map(x -> new Pair<>(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }

    public List<Pair<String, Pair<Integer, Integer>>> getSplits() {
        return splits;
    }

    public void sort() {
        splits.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }

    public int getId() {
        return id;
    }
}
