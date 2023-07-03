package praktikum;

import junit.framework.TestCase;
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

    @Parameterized.Parameters(name = "Стоимость и наименование булочки. Тестовые данные: {0} {1}")
    public static List<Object[]> getData() {

        return Arrays.asList(new Object[][] {

                {"Булочка", Float.MAX_VALUE},
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