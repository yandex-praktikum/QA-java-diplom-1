import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private final String name = "Капуста";
    private final float price = 3.50f;

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, price);

    @Test
    public void getNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredirntTypeTest() {
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }

}
