package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static junit.framework.TestCase.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Test
    public void getPriceTest() {

        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        float actualPrice = ingredient.getPrice();
        float expectedPrice = 100;

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void getNameTest() {

        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        String actualName = ingredient.getName();
        String expectedName = "hot sauce";

        assertEquals("Expected name is " + expectedName + ". But method returned " + actualName,
                expectedName, actualName);
    }

    @Test
    public void getTypeTest() {

        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        IngredientType actualType = ingredient.getType();
        IngredientType expectedType = SAUCE;

        assertEquals("Expected name is " + expectedType + ". But method returned " + actualType,
                expectedType, actualType);
    }

}
