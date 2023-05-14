import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getTypeTest() {
        IngredientType expectedIngredientType = IngredientType.SAUCE;
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(expectedIngredientType, actualIngredientType);
    }
    @Test
    public void getNameTest() {
        String expectedName = "hot sauce";
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 100F;
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0F);
    }
}
