package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.Constant.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.Message.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTypeTest (IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Name ingredient: {1}")
    public static Object[][] ingredientTypTest() {
        return new Object[][]{
                {SAUCE, HOT_SAUCE, HOT_SAUCE_PRICE},
                {SAUCE,CHILI_SAUCE, CHILI_SAUCE_PRICE},
                {SAUCE,SOUR_CREAM, SOUR_CREAM_PRICE},
                {FILLING, CUTLET, CUTLET_PRICE},
                {FILLING,DINOSAUR,DINOSAUR_PRICE},
                {FILLING,SAUSAGE,SAUSAGE_PRICE}
        };
    }

    @Test
    public void checkIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ERROR_TYPE_FILLING_MSG , type, ingredient.getType());
    }
    @Test
    public void checkIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(WRONG_NAME_MSG , name, ingredient.getName());
    }
    @Test
    public void checkIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(WRONG_PRICE_MSG , price, ingredient.getPrice(),DELTA);
    }

}
