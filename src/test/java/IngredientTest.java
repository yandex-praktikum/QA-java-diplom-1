import junit.framework.TestCase;
import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

@RunWith(Parameterized.class)
public class IngredientTest extends TestCase {

    private IngredientType ingredientType;
    private IngredientType ingredientTypeExpected;

    public IngredientTest(IngredientType type, IngredientType ingredientTypeExpected) {
        this.ingredientType = type;
        this.ingredientTypeExpected = ingredientTypeExpected;
    }

    @Parameterized.Parameters
    public static Object[] getIngredientType() {
        return new Object[][] {
                {IngredientType.FILLING, IngredientType.FILLING},
                {IngredientType.SAUCE, IngredientType.SAUCE},

        };
    }

    /*
    Проверка метода getType() класса Ingredient.java
    */
    @Test
    public void testGetTypeSomeNameReturnIngredientType() throws Exception {

        String name = RandomStringUtils.randomAlphabetic(10);

        Random random = new Random();
        Float price = random.nextFloat();

        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        IngredientType ingredientType = ingredient.getType();

        assertEquals(ingredientTypeExpected, ingredientType);

    }

    /*
    Проверка метода getName() класса Ingredient.java
    */
    @Test
    public void testGetNameSomeNameReturnString() throws Exception {

        IngredientType ingredientType = IngredientType.FILLING;

        String name = RandomStringUtils.randomAlphabetic(10);

        Random random = new Random();
        Float price = random.nextFloat();

        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        String actualName = ingredient.getName();

        assertEquals(name, actualName);

    }

    /*
    Проверка метода getPrice() класса Ingredient.java
    */
    @Test
    public void testGetPriceSomeNameReturnFloat() throws Exception {

        IngredientType ingredientType = IngredientType.FILLING;

        String name = RandomStringUtils.randomAlphabetic(10);

        Random random = new Random();
        Float price = random.nextFloat();

        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        Float actualPrice = ingredient.getPrice();

        assertEquals(price, actualPrice);

    }

}
