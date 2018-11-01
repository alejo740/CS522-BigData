package W1D3.partA;

public class Client {

    public static void main(String[] args) {
        InMapperWordCount wordCount = new InMapperWordCount(3, 4, new String[]{"src/W1D2/partB/input/input0.txt", "src/W1D2/partB/input/input1.txt", "src/W1D2/partB/input/input2.txt"});

        wordCount.shuffleAndSort();

        wordCount.reduce();

        wordCount.print();

        System.out.println("end....");
    }
}