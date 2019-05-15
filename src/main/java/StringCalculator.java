import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        existNegativesNumbers();
        return obtainSumOfNumbers();
    }

    private int obtainSumOfNumbers() {
        return getNumbers().stream().mapToInt(Integer::parseInt).sum();
    }

    private void existNegativesNumbers() {
        String negativeNumbersCollect = getNumbers().stream()
                .filter(n -> n.contains("-"))
                .collect(Collectors.joining(","));
        if (!negativeNumbersCollect.isEmpty()) {
            throw new IllegalArgumentException("negatives are not allowed:" + negativeNumbersCollect);
        }
    }

    private List<String> getNumbers() {
        return Arrays.asList(numbers.split(delimiter));
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
