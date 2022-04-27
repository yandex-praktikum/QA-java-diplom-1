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
    private String ingredientTypeExpected;

    public IngredientTest(IngredientType type, String ingredientTypeExpected) {
        this.ingredientType = type;
        this.ingredientTypeExpected = ingredientTypeExpected;
    }

    @Parameterized.Parameters (name = "Тестовые данные: {0} {1}")
    public static Object[] getIngredientType() {
        return new Object[][] {
                {IngredientType.FILLING, "FILLING"},
                {IngredientType.SAUCE, "SAUCE"},

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

        assertEquals("Error in Ingredient class getType() method", IngredientType.valueOf(ingredientTypeExpected), ingredientType);

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

        assertEquals("Error in Ingredient class getName() method",name, actualName);

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

        assertEquals("Error in Ingredient class getPrice() method", price, actualPrice);

    }

}
