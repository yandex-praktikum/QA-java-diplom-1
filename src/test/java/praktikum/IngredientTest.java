package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;
import static org.junit.Assert.assertEquals;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] IngredientTestParam() {
        return new Object[][]{
                {SAUCE, "sour cream", 200},
                {FILLING, "dinosaur", 300},
        };
    }

    @Test
    public void ingrTest(){
        Ingredient testIngr = new Ingredient(type, name, price);
        assertEquals(testIngr.getType(), type);
        assertEquals(testIngr.getName(), name);
        assertEquals(testIngr.getPrice(), price, 0.0);

    }

}



