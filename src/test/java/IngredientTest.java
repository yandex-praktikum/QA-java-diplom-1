import org.junit.Before;

import org.mockito.Spy;

import praktikum.Ingredient;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;
    @Spy
    IngredientType type ;

    @Before
    public void setUp(){
         ingredient = new Ingredient(type, "горчица", 34.6f);
    }


    @Test
    public void getNameIngredientReturnString(){


        String expectedNameIngredient = "горчица";
        String actualNameIngredient = ingredient.getName();

        assertEquals("Name ingredient should be String", expectedNameIngredient, actualNameIngredient);
    }

    @Test
    public void getPriceIngredientReturnFloat(){


        float expectedPriceIngredient = 34.6f;
        float actualPriceIngredient = ingredient.getPrice();

        assertEquals("Price ingredient should be float", expectedPriceIngredient, actualPriceIngredient, 0.01);
    }

    @Test
    public void getTypeIngredientReturnEnum(){

        assertEquals("Type ingredient should be Enum", type, ingredient.getType());
    }
}
