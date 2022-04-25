import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.text.MessageFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private final String testName;
    private final float testPrice;
    private Bun bun;

    @Parameterized.Parameters(name = "{index}: \"testName\": {0}; \"testPrice\": {1};")
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Easyname", 10.0f},
                {"Name with blanket", 10.25f},
                {"VeryLongNameBusQWERTYUIOPASDFGHJKLZXCVBNMQWERTYUIOPASDFGHJKLZXCVBNM", -10.0f},
                {"!@#$%^&*()_?<>.,~/`'\"\\ symbols", 15},
                {"", 0},
                {null, 0},
        };
    }

    public BunParameterizedTest(String testName, float testPrice) {
        this.testName = testName;
        this.testPrice = testPrice;
    }

    @Before
    public void setUp() {
        bun = new Bun(testName, testPrice);
    }

    @Test
    public void checkBanConstructor() {
        //исхожу из того, что поля name и price класса Bun сделаны публичными сознательно, в соответсвии с требованиями,
        //поэтому для максимального покрытия кода тестами и не зависимости проверки конструктора от реализации get-методов дергаю именно их
        String actualName = bun.name;
        float actualPrice = bun.price;
        String message = MessageFormat.format("Объект Bun() имеет НЕ верные значения полей \"name\"=\"{0}\" или \"price\"={1}", actualName, actualPrice);
        if (testName == null) {
            assertTrue(message, (actualName == testName) && (testPrice == actualPrice));
        } else {
            assertTrue(message, actualName.equals(testName) && testPrice == actualPrice);
        }
    }

    @Test
    public void checkGetName() {
        String actualName = bun.getName();
        assertEquals("Метод getName() вернул не верное значение", testName, actualName);
    }

    @Test
    public void checkGetPrice() {
        float actualPrice = bun.getPrice();
        assertEquals("Метод getPrice() вернул не верное значение", testPrice, actualPrice, 0);
    }

}