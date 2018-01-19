import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * FooBarQix test class
 */
public class FooBarQixTest {
    private FooBarQix test;

    @Before
    public void reload() {
        test = new FooBarQix(1, 100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExceptions() {
        test = new FooBarQix(-5, 68);
        test = new FooBarQix(156, 42);
    }

    @Test
    public void test() {
        Assert.assertEquals("FooFooFoo", test.transform(33));
        Assert.assertEquals("QixQix", test.transform(7));
        Assert.assertEquals("FooBarQix", test.transform(57));
    }
}
