import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void getNameIngredientTest() {
        {
            Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
            String actual = ingredient.getName();
            String expected = "hot sauce";

            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void getPriceIngredientTest() {
        {
            Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
            float actual = ingredient.getPrice();
            float expected = 100;

            Assert.assertEquals(actual, expected, 0);
        }
    }
}
