package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{IngredientType.SAUCE, "hot sauce", 100},
                new Object[]{IngredientType.SAUCE, "sour cream", 200},
                new Object[]{IngredientType.SAUCE, "chili sauce", 300},
                new Object[]{IngredientType.FILLING, "cutlet", 100},
                new Object[]{IngredientType.FILLING, "dinosaur", 200},
                new Object[]{IngredientType.FILLING, "sausage", 300}
        );
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}
