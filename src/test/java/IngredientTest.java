import static praktikum.IngredientType.SAUCE;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void createNewIngredient(){
        ingredient = new Ingredient(SAUCE, "hot sauce", 100.0f);
    }

    @Test
    public void testGetPrice() {
        float expected = 100.0f;
        float actual = ingredient.getPrice();

        Assert.assertEquals(expected, actual, 0.0f);
    }

    @Test
    public void testGetName() {
        String expected = "hot sauce";
        String actual = ingredient.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetType() {
        Enum<IngredientType> actual = ingredient.getType();

        Assert.assertEquals(SAUCE, actual);
    }

}
