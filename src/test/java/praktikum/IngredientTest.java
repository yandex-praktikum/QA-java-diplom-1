package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        float expectedPrice = 100;
        assertEquals(" цена для Souce не совпала", expectedPrice, ingredient.getPrice());
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "sour cream", 200);
        String expectedName = "sour cream";
        assertEquals("имя для Souce не совпал", expectedName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "chili sauce", 300);
        IngredientType expectedType = SAUCE;
        assertEquals(expectedType, ingredient.getType());
    }
}
