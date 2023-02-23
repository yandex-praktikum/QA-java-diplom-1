import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTests {
    private final IngredientType type = IngredientType.FILLING;
    private final String name = "dinosaur";
    private final float price = 200;

    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(type, ingredient.getType());
    }
}
