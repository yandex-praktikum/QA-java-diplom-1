import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getPriceTest() {
        float extendedPrice = 100;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(extendedPrice, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String extendedName = "hot sauce";
        String actualName = ingredient.getName();
        Assert.assertEquals("There should be another name", extendedName, actualName);
    }

    @Test
    public void getTypeTest() {
        String extendedType = IngredientType.SAUCE.toString();
        String actualType = String.valueOf(ingredient.getType());
        Assert.assertEquals("There should be another type", extendedType, actualType);
    }
}
