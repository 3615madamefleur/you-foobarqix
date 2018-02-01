package fbq;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.IntStream.*;
import static org.assertj.core.api.Assertions.*;

/**
 * FooBarQix test class
 */
public class FooBarQixTest {
    private final int min = 1;
    private final int max = 100;
    private FooBarQix fbq;
    private Map<Integer, String> mock;

    @Before
    public void arrange() {
        fbq = new FooBarQix(min, max);
        mock = new LinkedHashMap<>();
        range(min, max + 1)
                .forEach(i -> mock.put(i, fbq.transform(i)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void should_throw_exception_when_args_are_under_zero() {
        new FooBarQix(-5, 68);
    }

    @Test (expected = IllegalArgumentException.class)
    public void should_throw_exception_when_args_are_reversed() {
        new FooBarQix(156, 42);
    }

    @Test
    public void should_contains_foo_when_divisible_by_3() {
        range(min, max + 1)
                .filter(i -> i % FooBarQix.FOO == 0)
                .forEach(i -> assertThat(mock.get(i))
                        .contains("Foo"));
    }

    @Test
    public void should_contains_bar_when_divisible_by_5() {
        range(min, max + 1)
                .filter(i -> i % FooBarQix.BAR == 0)
                .forEach(i -> assertThat(mock.get(i))
                        .contains("Bar"));
    }

    @Test
    public void should_contains_qix_when_divisible_by_7() {
        range(min, max + 1)
                .filter(i -> i % FooBarQix.QIX == 0)
                .forEach(i -> assertThat(mock.get(i))
                        .contains("Qix"));
    }

    @Test
    public void should_contains_foo_when_a_digit_equals_3() {
        range(min, max + 1)
                .forEach(i -> String.valueOf(i)
                .chars()
                .mapToObj(Character::getNumericValue)
                .filter(e -> e == FooBarQix.FOO)
                .forEach(e -> assertThat(mock.get(i))
                        .contains("Foo")));
    }

    @Test
    public void should_contains_bar_when_a_digit_equals_5() {
        range(min, max + 1)
                .forEach(i -> String.valueOf(i)
                .chars()
                .mapToObj(Character::getNumericValue)
                .filter(e -> e == FooBarQix.BAR)
                .forEach(e -> assertThat(mock.get(i))
                        .contains("Bar")));
    }

    @Test
    public void should_contains_qix_when_a_digit_equals_7() {
        range(min, max + 1)
                .forEach(i -> String.valueOf(i)
                .chars()
                .mapToObj(Character::getNumericValue)
                .filter(e -> e == FooBarQix.QIX)
                .forEach(e -> assertThat(mock.get(i))
                        .contains("Qix")));
    }
}
