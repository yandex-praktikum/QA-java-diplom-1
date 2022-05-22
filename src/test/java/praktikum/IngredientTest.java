package praktikum;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Test
    public void getPriceTest() {
        String ingredientName1 = "ingredientTestName1";
        float expected = 10F;
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, ingredientName1, expected );
        float actual = ingredient1.getPrice();
        assertEquals(expected, actual, 1.0F);
    }

    @Test
    public void getNameTest() {
        String expected = "ingredientTestName1";
        float ingredientPrice = 10F;
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, expected, ingredientPrice);
        String actual = ingredient1.getName();
        assertEquals(expected, actual);
    }
}
