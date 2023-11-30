import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private static final RandomStringUtils randomStringUtils = new RandomStringUtils();
    private static final Random random = new Random();
    private Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price){
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] createIngredient() {
        return  new Object[][] {
                {IngredientType.FILLING, randomStringUtils.randomAlphabetic(10), random.nextFloat()},
                {IngredientType.SAUCE, randomStringUtils.randomAlphabetic(10), random.nextFloat()}
        };
    }

    @Test
    public void getPriceTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }
}
