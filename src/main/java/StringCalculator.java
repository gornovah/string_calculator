public class StringCalculator {

    public int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }
        return sumNumbers(numbers);
    }

    private int sumNumbers(String numbers) {
        String[] numbersArray = numbers.split(",|\n");
        int result = 0;
        for (String number: numbersArray){
            result += Integer.valueOf(number);
        }
        return result;
    }
}
