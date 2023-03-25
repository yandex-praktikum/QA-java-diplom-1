import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientFillingTest {

    public static int ingredientFillingPrice = 100;
    public static String ingredientFillingName = "cutlet";

    @Test
    public void getFillingName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, ingredientFillingName, ingredientFillingPrice);
        Assert.assertEquals(ingredientFillingName, ingredient.getName());
    }

    @Test
    public void getFillingPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, ingredientFillingName, ingredientFillingPrice);
        Assert.assertEquals(ingredientFillingPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getFillingType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, ingredientFillingName, ingredientFillingPrice);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
