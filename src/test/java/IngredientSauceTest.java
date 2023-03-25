import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientSauceTest {

    public static int ingredientSaucePrice = 300;
    public static String ingredientSauceName = "chili sauce";

    @Test
    public void getSauceName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientSauceName, ingredientSaucePrice);
        Assert.assertEquals(ingredientSauceName, ingredient.getName());
    }

    @Test
    public void getSaucePrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientSauceName, ingredientSaucePrice);
        Assert.assertEquals(ingredientSaucePrice, ingredient.getPrice(), 0);
    }

}
