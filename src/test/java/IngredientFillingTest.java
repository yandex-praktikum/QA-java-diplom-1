import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientFillingTest {
    @Test
    public void getFillingName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Assert.assertEquals("cutlet", ingredient.getName());
    }

    @Test
    public void getFillingPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Assert.assertEquals(100, ingredient.getPrice(), 0);
    }

    @Test
    public void getFillingType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
