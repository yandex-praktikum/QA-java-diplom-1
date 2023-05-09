import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedUnitTests {

    private String name;
    private float price;
    public IngredientType type;

    public void IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientType() {
        return new Object[][]{
                {IngredientType.FILLING, "Кристаллы марсианских альфа-сахаридов", 762},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15}
        };
    }

    @Test
    public void getPriceIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }
}