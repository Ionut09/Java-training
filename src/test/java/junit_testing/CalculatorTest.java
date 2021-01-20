package junit_testing;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyVararg;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @InjectMocks
    private Calculator sut;

    @Mock
    private ArithmeticCalculator arithmeticCalculator;

    @Test
    public void operation_givenInputWithNumbersAndLetters_whenCalculationIsPerformed_thenZeroIsReturned() {
        //Given
        var input = "*-1A";

        //When
        var result = sut.operation(input);

        //Then
        verify(arithmeticCalculator).multiply(anyVararg());
        //is like
        verify(arithmeticCalculator, times(1)).multiply(anyVararg());
    }

    @Test
    public void operation_givenBadInput_whenCalculationIsPerformed_thenZeroIsReturned() {
        //Given
        var input = "*-";

        //When
        var result = sut.operation(input);

        //Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void operation_givenNullInput_whenCalculationIsPerformed_thenExceptionIsThrown() {
        //Given
        var input = "12";

        //When
        var thrown = catchThrowable(() -> sut.operation(input));

        //Then
        assertThat(thrown).isNotNull();
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown).hasMessage("Unsuported operation");
    }

    @Test
    public void operation_givenNoOperationInput_whenCalculationIsPerformed_thenZeroIsReturned() {
        //When
        var result = sut.operation(null);

        //Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void operation_givenSumInput_whenCalculationIsPerformed_thenResultIsReturned() {
        //Given
        var input = "1+2+3";
        String[] matcher = Matchers.anyVararg();
        given(arithmeticCalculator.sum(matcher)).willReturn(6);

        //When
        var result = sut.operation(input);

        //Then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void operation_givenMultiplyInput_whenCalculationIsPerformed_thenResultIsReturned() {
        //Given
        var input = "1*2*3";
        String[] matcher = Matchers.anyVararg();
        given(arithmeticCalculator.multiply(matcher)).willReturn(6);

        //When
        var result = sut.operation(input);

        //Then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void operation_givenDivisionInput_whenCalculationIsPerformed_thenResultIsReturned() {
        //Given
        var input = "1/2/3";
        String[] matcher = Matchers.anyVararg();
        var expectedResult = 0;
        given(arithmeticCalculator.division(matcher)).willReturn(expectedResult);

        //When
        var result = sut.operation(input);

        //Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void operation_givenSubtractionInput_whenCalculationIsPerformed_thenResultIsReturned() {
        //Given
        var input = "1-2-3";
        String[] matcher = Matchers.anyVararg();
        var expectedResult = -4;
        given(arithmeticCalculator.substraction(matcher)).willReturn(expectedResult);

        //When
        var result = sut.operation(input);

        //Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void operation_givenInvalidOperationInput_whenCalculationIsPerformed_thenExceptionIsThrown() {
        //Given
        var input = "1%2%3";

        //When
        var thrown = catchThrowable(() -> sut.operation(input));

        //Then
        assertThat(thrown).isNotNull();
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown).hasMessage("Unsuported operation");
        verifyNoMoreInteractions(arithmeticCalculator);
    }
}
