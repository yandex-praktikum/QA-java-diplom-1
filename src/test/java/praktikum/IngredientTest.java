package praktikum;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 10.0f},
                {IngredientType.FILLING, "sausage", 20.5f},
                {null, null, 0.0f}
        };
    }

    @Test
    public void getIngredientPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualIngredientPrice = ingredient.getPrice();
        assertEquals(price, actualIngredientPrice, 0.0f);
    }

    @Test
    public void getIngredientNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualIngredientName = ingredient.getName();
        assertEquals(name, actualIngredientName);
    }

    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(type, actualIngredientType);
    }
}