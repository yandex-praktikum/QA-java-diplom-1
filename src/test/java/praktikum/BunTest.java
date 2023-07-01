package praktikum;

import junit.framework.TestCase;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class BunTest extends TestCase {

    @Parameterized.Parameter
    public String name;

    @Parameterized.Parameter(1)
    public float price;

    @Parameterized.Parameters
    public static List<Object[]> getData() {

        return Arrays.asList(new Object[][] {

                {RandomStringUtils.randomAlphabetic(6), Float.MAX_VALUE},
                {"", -Float.MAX_VALUE}
        });
    }

    @Test
    public void testGetName() {

        Bun bun = new Bun(name, price);
        assertThat("Значение name не валидно",
                bun.getName(), is(name));
    }

    @Test
    public void testGetPrice() {

        Bun bun = new Bun(name, price);
        assertThat("Значение price не валидно",
                bun.getPrice(), is(price));
    }
}