package W1D2.partA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapper {

    private List<Pair<String, Integer>> fileLines;
    private String scapeRegex = "[\\W+,-.]|(\\w+[\\._]\\w+)|\\\"|([A-Za-z]+[\\d]+[\\w]*)|\\d";
    private String fileName;
    private List<String> stringLines;

    public Mapper(String fileName) {
        this.fileName = fileName;
        readFile();
        stringLines.forEach(x -> System.out.println(x));
        System.out.println("---");
    }

    private void readFile() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stringLines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void map() {
        fileLines = stringLines.stream().map(x -> x.split(scapeRegex))
                .flatMap(Arrays::stream)
                .filter(x -> !x.isEmpty())
                .map(x -> new Pair<>(x, 1))
                //.sorted(Comparator.comparing(x -> x.getKey().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Pair<String, Integer>> getFileLines() {
        return fileLines;
    }

    public void sort() {
        fileLines.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }
}
