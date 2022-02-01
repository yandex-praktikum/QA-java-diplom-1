import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void ingredientGetPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        Assert.assertEquals(90, ingredient.getPrice(), 0);
    }

    @Test
    public void ingredientGetNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337);
        Assert.assertEquals("Мясо бессмертных моллюсков Protostomia", ingredient.getName());
    }

    @Test
    public void ingredientGetTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }


}
