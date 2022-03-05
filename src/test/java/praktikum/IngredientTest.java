package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Test", 3234f);

    @Test
    public void getPrice() {

        float actualResult = ingredient.getPrice();
        float expectedResult = 3234;

        assertEquals("The price is not correct",expectedResult,actualResult,0);
    }

    @Test
    public void getName() {

        String actualResult = ingredient.getName();
        String expectedResult = "Test";

        assertEquals("The name is not correct",expectedResult,actualResult);
    }

    @Test
    public void getType() {

        IngredientType actualResult = ingredient.getType();
        IngredientType expectedResult = IngredientType.SAUCE;

        assertEquals("The type is not correct",expectedResult,actualResult);
    }
}

