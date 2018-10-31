package W1D2.partB;

public class Client {

    public static void main(String[] args) {
        WordCount wordCount = new WordCount(3, 4, new String[]{"src/W1D2/partB/input/input0.txt", "src/W1D2/partB/input/input1.txt", "src/W1D2/partB/input/input2.txt"});

        wordCount.shuffleAndSort();

        wordCount.reduce();

        wordCount.print();

        System.out.println("end....");
    }
}