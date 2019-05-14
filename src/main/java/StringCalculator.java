public class StringCalculator {

    public int add(String numbers) {
        return numbers.equals("") ? 0: Integer.valueOf(numbers);
    }
}
