import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringCalculatorTest {
    @Test
    public void simple_calculator() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("");
        assertThat(result, is(0));
    }

    @Test
    public void simple_calculator_various_parameters() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("4,2");
        assertThat(resultAdd, is(6));
    }
    
    @Test
    public void given_arbitrary_number_size_then_return_the_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("1,2,3,4,5,6,7,8,9");
        assertThat(resultAdd, is(45));
    }
    
    @Test
    public void given_new_line_separator_then_return_the_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("1\n2,3");
        assertThat(resultAdd, is(6));
    }

    @Test
    public void given_new_delimiter_then_return_the_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("//;\n1;2");
        assertThat(resultAdd, is(3));
        resultAdd = stringCalculator.add("//.\n1.2.3");
        assertThat(resultAdd, is(6));
    }

    @Test
    public void given_negatives_numbers_then_return_an_exception() {
        StringCalculator stringCalculator = new StringCalculator();
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1, -2, 3, -4"));
        assertTrue(illegalArgumentException.getMessage().contains("negatives are not allowed: -2, -4"));
    }
    
    @Test
    public void given_number_major_1000_then_ignore_the_numbers() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("1000");
        assertThat(resultAdd, is(0));
    }
    
    @Test
    public void given_arbitrary_length_separators_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("//[***]\n1***2***3");
        assertThat(resultAdd, is(6));
    }

    @Test
    public void given_multiple_single_length_separators_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("//[*][%]\n1*2%3");
        assertThat(resultAdd, is(6));
    }
}
