import java.util.Arrays;

public class StringCalculator {

    private String delimiter;
    private String numbers;

    public StringCalculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    public StringCalculator() {

    }

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return sumNumbers(numbers);
    }

    private int sum() {
        return Arrays.stream(numbers.split(delimiter)).mapToInt(Integer::parseInt).sum();
    }

    private int sumNumbers(String numbers) {
        return parseInput(numbers).sum();
    }

    private StringCalculator parseInput(String numbers) {
        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            return new StringCalculator(parts[0].substring(2), parts[1]);
        } else {
            return new StringCalculator(",|\n", numbers);
        }
    }
}
