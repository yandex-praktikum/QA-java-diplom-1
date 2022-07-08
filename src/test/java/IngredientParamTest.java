import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Used ingredients and price: {0} {1} {2}")
    public static Object[] ingredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "with sauce", 50},
                {IngredientType.FILLING, "with filling", 99},
        };
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        System.out.println(ingredient);
        System.out.println(ingredient.getPrice());
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        System.out.println(ingredient);
        System.out.println(ingredient.getName());
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        System.out.println(ingredient);
        System.out.println(ingredient.getType());
        Assert.assertEquals(type, ingredient.getType());
    }
}