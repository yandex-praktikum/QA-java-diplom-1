import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

   private final IngredientType type;
   private final String name;
   private final float price;
   Ingredient ingredient;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Дано: {0} {1}")
    public static Object[][] getData() {
        return new Object[][] {
            {SAUCE, "hot sauce", 100},
            {SAUCE, "sour cream", 200},
            {SAUCE, "chili sauce", 300},
            {FILLING, "cutlet", 100},
            {FILLING, "dinosaur", 200},
            {FILLING, "sausage", 300}
        };
    }

    @Before
    public void start() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkTypeTest() {
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void checkNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0);
    }


}
