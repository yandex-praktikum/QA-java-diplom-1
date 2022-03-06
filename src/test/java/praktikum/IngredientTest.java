package praktikum;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static junit.framework.TestCase.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Test
    @DisplayName("Тест на получение цены ингридиента")
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        float expectedPrice = 100;
        assertEquals(expectedPrice, ingredient.getPrice());
    }

    @Test
    @DisplayName("Тест на получение название ингридиента")
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "sour cream", 200);
        String expectedName = "sour cream";
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    @DisplayName("Тест на получение типа ингридиента")
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "chili sauce", 300);
        IngredientType expectedType = SAUCE;
        assertEquals(expectedType,ingredient.getType());
    }
}
