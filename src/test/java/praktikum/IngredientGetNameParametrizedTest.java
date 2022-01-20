package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class IngredientGetNameParametrizedTest {
    private static final Object SAUCE = IngredientType.SAUCE;
    private static final Object FILLING = IngredientType.FILLING;
    private final Object type;
    private final String name;
    private final float price;
    private final String expected;

    public IngredientGetNameParametrizedTest(Object type, String name, float price, String expected){
        this.type = type;
        this.name = name;
        this.price = price;
        this.expected = expected;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "sour cream", 200, "sour cream"},
                {FILLING, "sausage", 300, "sausage"},
        };
    }

    @Test
    public void getName() {
        //Arrange
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);
        //Act
        String actualName = ingredient.getName();
        //Assert
        assertEquals("Название не совпадает!",expected, actualName);
    }
}
