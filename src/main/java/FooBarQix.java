import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class used to convert a series of numbers into FooBarQix formatted strings
 */
public final class FooBarQix {
    private static final String SEPARATOR = "\n";
    private final int min;
    private final int max;

    private final Map<Integer, String> pairs = new LinkedHashMap<Integer, String>() {{
        put(3, "Foo");
        put(5, "Bar");
        put(7, "Qix");
    }};

    /**
     * FooBarQix constructor
     * @param min minimum range value (inclusive)
     * @param max maximum range value (inclusive)
     */
    public FooBarQix(int min, int max) {
        if (min < 1 || max < min) {
            throw new IllegalArgumentException();
        }
        this.min = min;
        this.max = max;
    }

    /**
     * Convert the range of specified numbers into FooBarQix formatted strings
     * @return a string representation of the formatted strings list
     */
    public String foobarqix() {
        return IntStream.range(min, max + 1)
                .mapToObj(e -> e + " --> " + transform(e)).collect(Collectors.joining(SEPARATOR));
    }

    /**
     * Convert a number into FooBarQix formatted string
     * @param number number to convert
     * @return a FooBarQix representation of the number
     */
    public String transform(int number) {
        String result = pairs.keySet().stream()
                .filter(p -> number % p == 0)
                .map(pairs::get)
                .collect(Collectors.joining());

        result += String.valueOf(number).chars()
                .mapToObj(c -> pairs.getOrDefault(Character.getNumericValue(c), ""))
                .collect(Collectors.joining());

        return result.isEmpty() ? String.valueOf(number) : result;
    }
}