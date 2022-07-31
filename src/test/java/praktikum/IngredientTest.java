package praktikum;

import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private static final String INCORRECT_TYPE_MESSAGE = "Тип указан не правильно";
    private static final String INCORRECT_NAME_MESSAGE = "Название указано не правильно";
    private static final String INCORRECT_PRICE_MESSAGE = "Цена указана не правильно";

    private Ingredient ingredient;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;
    float delta = 0;

    public IngredientTest(IngredientType type, String name, float price) {
        expectedType = type;
        expectedName = name;
        expectedPrice = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Parameterized.Parameters(name = "Тестовые данные{index}: Тип: {0}, Название: {1}, Цена: {2}")
    public static Object[][] setIngredient() {
        return new Object[][]{
                {SAUCE, "Острый", 1f},
                {SAUCE, "Кисло-сладкий", -1f},
                {FILLING, "", 0.1f},
                {FILLING, null, 0},
        };
    }

    @Test
    @Description("Проверяем тип")
    public void testGetType() {
        IngredientType actualType = ingredient.getType();
        assertEquals(INCORRECT_TYPE_MESSAGE, expectedType, actualType);
        System.out.println(expectedType);
    }

    @Test
    @Description("Проверяем название")
    public void testGetName() {
        String actualName = ingredient.getName();
        assertEquals(INCORRECT_NAME_MESSAGE, expectedName, actualName);
    }

    @Test
    @Description("Проверяем цену")
    public void testGetPrice() {
        float actualPrice = ingredient.getPrice();
        assertEquals(INCORRECT_PRICE_MESSAGE, expectedPrice, actualPrice, delta);
    }
}
