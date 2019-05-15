import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return sumNumbers(numbers);
    }

    private int sumNumbers(String numbers) {
        Stream<String> numbersArray = Arrays.stream(numbers.split(",|\n"));
        return numbersArray.mapToInt(Integer::parseInt).sum();
    }
}
