package praktikum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)

public class IngredientGetTypeParametrizedTest {

    private static final Object SAUCE = IngredientType.SAUCE;
    private static final Object FILLING = IngredientType.FILLING;
    private final Object type;
    private final String name;
    private final float price;
    private final Object expected;

    public IngredientGetTypeParametrizedTest(Object type, String name, float price, Object expected){
        this.type = type;
        this.name = name;
        this.price = price;
        this.expected = expected;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "sour cream", 200, SAUCE},
                {FILLING, "sausage", 300, FILLING},
        };
    }

    @Test
    public void getType() {
        //Arrange
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);
        //Act
        IngredientType actualType = ingredient.getType();
        //Assert
        assertEquals("Тип не совпадает!",expected, actualType);
    }

}
