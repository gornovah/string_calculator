import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;


public class stringCalculatorTest {
    @Test
    public void simple_calculator() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("");
        assertThat(result, Matchers.is(0));
    }

    @Test
    public void simple_calculator_various_parameters() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("4,2");
        assertThat(resultAdd, Matchers.is(6));
    }
    
    @Test
    public void given_arbitrary_number_size_then_return_the_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("1,2,3,4,5,6,7,8,9");
        assertThat(resultAdd, Matchers.is(45));
    }
    
    @Test
    public void given_new_line_separator_then_return_the_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("1\n2,3");
        assertThat(resultAdd, Matchers.is(6));
    }

    @Test
    public void given_new_delimiter_then_return_the_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("//;\n1;2");
        assertThat(resultAdd, Matchers.is(3));
    }
}
