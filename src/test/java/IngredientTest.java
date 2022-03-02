import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void testGetNameReturnsName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337F);
        String actual = ingredient.getName();
        String expected = "Мясо бессмертных моллюсков Protostomia";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90F);
        float actual = ingredient.getPrice();
        float expected = 90F;
        Assert.assertEquals(expected, actual, 0);
    }
}