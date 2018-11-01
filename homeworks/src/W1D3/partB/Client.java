package W1D3.partB;

public class Client {

    public static void main(String[] args) {
        InMapperWordCount wordCount = new InMapperWordCount(4, 3, new String[]{"src/W1D3/partB/input/input0.txt", "src/W1D3/partB/input/input1.txt", "src/W1D3/partB/input/input2.txt", "src/W1D3/partB/input/input3.txt"});

        wordCount.shuffleAndSort();

        wordCount.reduce();

        wordCount.print();

        System.out.println("end....");
    }
}