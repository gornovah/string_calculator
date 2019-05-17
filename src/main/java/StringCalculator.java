import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        return sumNumbers(numbers);
    }

    private int sumNumbers(String numbers) {
        return parseInput(numbers).sum();
    }

    private StringCalculator parseInput(String input) {
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String header = parts[0];
            return new StringCalculator(parseDelimiter(header), parts[1]);
        } else {
            return new StringCalculator(",|\n", input);
        }
    }

    private String parseDelimiter(String header) {
        String delimiter = header.substring(2);
        if (delimiter.startsWith("[")){
            delimiter = delimiter.substring(1, delimiter.length() -1);
            return Stream.of(delimiter.split("]\\["))
                    .map(Pattern::quote)
                    .collect(Collectors.joining("|"));
        }
        return Pattern.quote(delimiter);
    }

    private int sum() {
        if (numbers.isEmpty()){
            return IntStream.empty().sum();
        }
        existNegativesNumbers();
        return obtainSumOfNumbers();
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

    private int obtainSumOfNumbers() {
        return getNumbers().stream().mapToInt(Integer::parseInt).filter(n -> n < 1000).sum();
    }


}
