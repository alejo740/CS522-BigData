package W1D2.partA;

import java.util.List;

public class Client {


    public Client() {
    }


    public static void main(String[] args) {
        Mapper mapper = new Mapper("src/W1D2/partA/input/test.txt");
        mapper.map();
        mapper.sort();
        List<Pair<String, Integer>> mappedData = mapper.getFileLines();


        System.out.println("\n\n");
        System.out.println("Mapper Output");
        System.out.println("\n\n");
        mappedData.forEach(x -> System.out.println("< " + x.getKey() + " , " + x.getValue() + " >"));


        Reducer reducer = new Reducer(mappedData);
        System.out.println("\n\n");
        System.out.println("Reducer Input");
        System.out.println("\n\n");
        reducer.getGroupByPairs().forEach(x -> System.out.println("< " + x.getKey() + " , " + x.getValue() + " >"));



        reducer.reduceGroups();
        List<Pair<String, Integer>> result = reducer.getReducedList();
        System.out.println("\n\n");
        System.out.println("Reducer Output");
        System.out.println("\n\n");
        result.forEach(x -> System.out.println("< " + x.getKey() + " , " + x.getValue() + " >"));


        System.out.println("end...");
    }
}