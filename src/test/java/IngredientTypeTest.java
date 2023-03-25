import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTypeTest {

    public static int ingredientFillingPrice = 100;
    public static String ingredientFillingName = "cutlet";
    public static int ingredientSaucePrice = 300;
    public static String ingredientSauceName = "chili sauce";

    @Test
    public void getSauceType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientSauceName, ingredientSaucePrice);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void getFillingType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, ingredientFillingName, ingredientFillingPrice);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
