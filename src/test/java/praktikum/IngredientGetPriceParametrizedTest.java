package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class IngredientGetPriceParametrizedTest {

    private static final Object SAUCE = IngredientType.SAUCE;
    private static final Object FILLING = IngredientType.FILLING;
    private final Object type;
    private final String name;
    private final float price;
    private final float expected;

    public IngredientGetPriceParametrizedTest(Object type, String name, float price, float expected){
        this.type = type;
        this.name = name;
        this.price = price;
        this.expected = expected;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "sour cream", 200, 200},
                {FILLING, "sausage", 300, 300},
        };
    }



    @Test
    public void getPrice() throws Exception {
        //Arrange
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);
        //Act
        float actualPrice = ingredient.getPrice();
        //Assert
        assertEquals("Цена не совпадает!",expected, actualPrice, 0);

    }


}