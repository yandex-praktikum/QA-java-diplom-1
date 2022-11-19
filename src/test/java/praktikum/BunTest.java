package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;

    private final float bunPrice;

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static List<?> parametersForShouldMoveIngredients() {
        return Arrays.asList(new Object[][]{
                {"Звездная булочка", Float.MAX_VALUE},
                {"Звездная булочка", Float.MIN_VALUE},
                {"Звездная булочка", 10.000000000001f},
                {"з", 20},
                {"Зве;!№;*(?()*)%);%(?№__++к4а", 200},
                {"ЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗззззззззвввввввввввввввввеееееееееееееееееееезззззззззззздддддддддднннннннннннаааааааааааааяяяяяяяяяяяяяя ббббббббббббббббббббббббббббббббббууууууууууууууууууууууууууууулллллллллллллллллллллллооооооооооооооооооооооочччччччччччччччччччкккккккккккккккккккккааааааааааааааааааааааа", 20}
        });
    }

    @Test
    public void getName() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}