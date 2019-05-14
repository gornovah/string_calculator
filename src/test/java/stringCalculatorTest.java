import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


public class stringCalculatorTest {
    @Test
    public void simple_calculator() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("");
        MatcherAssert.assertThat(result, Matchers.is(0));
    }

    @Test
    public void simple_calculator_various_parameters() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultAdd = stringCalculator.add("4");
        MatcherAssert.assertThat(resultAdd, Matchers.is(4));
    }
}
