package W1D2.partB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapper {

    private List<Pair<String, Integer>> splits;
    private String scapeRegex = "[\\W+,-.]|(\\w+[\\._]\\w+)|\\\"|([A-Za-z]+[\\d]+[\\w]*)|\\d";
    private String fileName;
    private List<String> stringLines;
    private int id;

    public Mapper(String fileName, int index) {
        id = index;
        this.fileName = fileName;
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
        splits = stringLines.stream().map(x -> x.split(scapeRegex))
                .flatMap(Arrays::stream)
                .filter(x -> !x.isEmpty())
                .map(x -> new Pair<>(x, 1))
                //.sorted(Comparator.comparing(x -> x.getKey().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Pair<String, Integer>> getSplits() {
        return splits;
    }

    public void sort() {
        splits.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }

    public int getId() {
        return id;
    }
}
