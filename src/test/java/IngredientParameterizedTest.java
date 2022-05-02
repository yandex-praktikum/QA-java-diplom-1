import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.text.MessageFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    private Ingredient ingredient;

    public IngredientParameterizedTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index}: \"testType\": {0}; \"testName\": {1}; \"testPrice\": {2};")
    public static Object[][] getBunData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Easyname", 10.0f},
                {IngredientType.FILLING, "Name with blanket", 10.25f},
                {IngredientType.SAUCE, "VeryLongNameBusQWERTYUIOPASDFGHJKLZXCVBNMQWERTYUIOPASDFGHJKLZXCVBNM", -10.0f},
                {IngredientType.FILLING, "!@#$%^&*()_?<>.,~/`'\"\\ symbols", 15},
                {IngredientType.SAUCE, "", 0},
                {IngredientType.FILLING, null, 0},
                {null, "", 0},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Test
    public void checkIngredientConstructor() {
        //исхожу из того, что поля name, price, type класса Ingredient сделаны публичными сознательно, в соответсвии с требованиями,
        //поэтому для максимального покрытия кода тестами и не зависимости проверки конструктора от реализации get-методов дергаю именно поля
        IngredientType actualType = ingredient.type;
        String actualName = ingredient.name;
        float actualPrice = ingredient.price;
        String message = MessageFormat.format("Объект Ingredient() имеет НЕ верные значения полей \"type\"=\"{0}\" или \"name\"=\"{1}\" или \"price\"={2}", actualType, actualName, actualPrice);
        if (expectedName == null) {
            assertTrue(message, (actualName == null) && (expectedPrice == actualPrice) && (expectedType == actualType));
        } else {
            assertTrue(message, actualName.equals(expectedName) && (expectedPrice == actualPrice) && (expectedType == actualType));
        }
    }

    @Test
    public void checkGetName() {
        String actualName = ingredient.getName();
        assertEquals("Метод getName() вернул не верное значение", expectedName, actualName);
    }

    @Test
    public void checkGetPrice() {
        float actualPrice = ingredient.getPrice();
        assertEquals("Метод getPrice() вернул не верное значение", expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetType() {
        IngredientType actualType = ingredient.getType();
        assertEquals("Метод getType() вернул не верное значение", expectedType, actualType);
    }

}