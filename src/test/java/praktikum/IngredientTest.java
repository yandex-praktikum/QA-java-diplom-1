package praktikum;

import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public  void createIngredientObject(){

        ingredient = new Ingredient(IngredientType.SAUCE,"Фирменный", 80f);
    }

    @Test
    public void getNameReturnsCorrectIngredientNameTest(){

        String actual = ingredient.getName();
        String expected = "Фирменный";
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceReturnCorrectIngredientPriceTest(){

        float actual = ingredient.getPrice();
        float expected = 80f;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getTypeReturnsCorrectTypeTest(){

        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, actual);
    }

}