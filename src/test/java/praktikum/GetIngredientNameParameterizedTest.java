package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GetIngredientNameParameterizedTest {
    private static final IngredientType SAUCE = IngredientType.SAUCE;
    private static final IngredientType FILLING = IngredientType.FILLING;
    private final Object type;
    private final String name;
    private final float price;
    private final String expectedName;

    public GetIngredientNameParameterizedTest(Object type, String name, float price, String expectedName) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100, "hot sauce"},
                {SAUCE, "sour cream", 200, "sour cream"},
                {SAUCE, "chili sauce", 200, "chili sauce"},
                {FILLING, "cutlet", 100, "cutlet"},
                {FILLING, "dinosaur", 200, "dinosaur"},
                {FILLING, "sausage", 300, "sausage"}
        };
    }

    @Test
    public void getName() {
        // Создаем объект
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);
        // Сохраняем в переменную название ингредиента
        String actualName = ingredient.getName();
        // Проверяем, что полученное название совпадает с ожидаемым
        assertEquals("Ожидаемое название " + expectedName + ". Фактическое " + actualName,
                expectedName, actualName);
    }

}