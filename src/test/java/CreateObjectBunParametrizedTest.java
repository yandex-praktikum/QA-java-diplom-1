import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class CreateObjectBunParametrizedTest {

    private final String bunName;
    private final float bunPrice;
    private Bun bun;

    public CreateObjectBunParametrizedTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    //Параметры для создания объекта класса Bun
    @Parameterized.Parameters(name = "Тестовые данные: \"{0}\"; {1};")
    public static Object[][] getData() {
        return new Object[][]{
                {"Тестовая булочка", 1000.11f},
                {"", 1.11f},
                {null, 1.11f},
                {" ", 1.11f},
                {"Тестовая булочка", Float.MAX_VALUE},
                {"Тестовая булочка", Float.MIN_VALUE},
                {"Тестовая булочка", 0},
                {"Тестовая булочка", -1},
        };
    }

    @Test
    public void createNewObjectBun_WithParameters_ExpectedNotNull() {
        bun = new Bun(bunName, bunPrice);
        assertNotNull(bun);
    }
}
