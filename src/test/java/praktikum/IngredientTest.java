package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    public static IngredientType type;
    public static String name;
    public static float price;

    public IngredientTest(IngredientType type, String name, float price){
        IngredientTest.type = type;
        IngredientTest.name = name;
        IngredientTest.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientParams() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "chili sauce", 0},
                {FILLING, "cutlet", -10},
                {FILLING, "dinosaur", Float.MAX_VALUE},
                {FILLING, "sausage", Float.MIN_VALUE}
        };
    }
    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }
    @Test
    public void getPriceReturnPrice(){
        assertEquals(ingredient.getPrice(), price, 0);
    }
    @Test
    public void getNameReturnName(){
        assertEquals(ingredient.getName(), name);
    }
    @Test
    public void getIngredientPriceReturnPrice(){
        assertEquals(ingredient.getType(), type);
    }
}
