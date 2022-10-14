package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Random;
import static org.junit.Assert.assertEquals;

/**
 * Юнит-тесты геттера класса Ingredient
 * (с параметризацией)
 */
@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    // Объявляем объекты для тестовых данных
    private final String name;
    private final float price;
    private IngredientType type;

    // Создаем конструктор для параметризации
    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    // Создаем тестовые данные со случайными значениями
    @Parameterized.Parameters
    public static Object[][] getIngredientParametrizedTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "KolyaevBun" + new Random().nextInt(10), new Random().nextFloat()},
                {IngredientType.FILLING, "KolyaevBun" + new Random().nextInt(10), new Random().nextFloat()}
        };
    }

    // Проверяем что геттер GetType возвращает тип ингредиента
    @Test
    public void checkGetTypeReturnsTypeFromParameters() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expectedType = ingredient.getType();
        assertEquals(expectedType, type);
    }
}
