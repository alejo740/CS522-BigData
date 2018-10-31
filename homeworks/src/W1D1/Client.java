package W1D1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {

    List<Pair> fileLines;
    private String scapeRegex = "[\\W+,-.]|(\\w+[\\._]\\w+)|\\\"|([A-Za-z]+[\\d]+[\\w]*)|\\d";

    public Client() {
    }

    private void readFile(String fileName) {

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            fileLines = stream.map(x -> x.split(scapeRegex))
                    .flatMap(Arrays::stream)
                    .filter(x -> !x.isEmpty())
                    .map(x -> new Pair<>(x, 1))
                    .sorted(Comparator.comparing(x -> x.getKey().toLowerCase()))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
        c.readFile("src/input/test.txt");
        System.out.println(Arrays.deepToString(c.fileLines.toArray()));
        System.out.println("Total: " + c.fileLines.size());
        System.out.println("end...");
    }
}


/*
* fileLines = Arrays.stream(stream.map(x -> x.split(scapeRegex))
                    //.flatMap(Arrays::stream)
                    .reduce(new String[]{}, (x, y) -> Stream.concat(Arrays.stream(x), Arrays.stream(y)).toArray(String[]::new)))
                    .filter(x -> !x.isEmpty())
                    .map(x -> new Pair<>(x, 1))
                    .sorted(Comparator.comparing(x -> x.getKey().toLowerCase()))
                    .collect(Collectors.toList());
* */