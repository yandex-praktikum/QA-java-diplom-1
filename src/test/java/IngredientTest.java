import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Mock
    private IngredientType mockType;

    private String testName = RandomStringUtils.randomAlphabetic(10);
    private float testPrice =  RandomUtils.nextFloat();

    private Ingredient ingredient;

    @Before
    public void setUp() {
        mockType = IngredientType.FILLING;

        // Создаем ингредиент с тестовыми значениями
        ingredient = new Ingredient(mockType, testName, testPrice);
    }

    @Test
    public void testGetPrice() {
        // Проверяем, что метод getPrice возвращает ожидаемую цену
        assertEquals(testPrice, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testGetName() {
        // Проверяем, что метод getName возвращает ожидаемое название
        assertEquals(testName, ingredient.getName());
    }

    @Test
    public void testGetType() {
        // Проверяем, что метод getType возвращает ожидаемый тип
        assertEquals(mockType, ingredient.getType());
    }

    @Test
    public void testConstructor() {
        // Проверяем, что конструктор устанавливает переданные значения
        assertEquals(mockType, ingredient.getType());
        assertEquals(testName, ingredient.getName());
        assertEquals(testPrice, ingredient.getPrice(), 0.01);
    }
}
