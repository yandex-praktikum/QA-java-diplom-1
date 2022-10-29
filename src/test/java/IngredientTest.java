import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


public class IngredientTest {

    private Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getPriceReturnRightPrice(){
        float expectedResult = ingredient.getPrice();
        assertEquals(100, expectedResult, 0);
    }
    @Test
    public void getNameReturnRightName(){
        String actualResult = ingredient.getName();
        assertEquals("hot sauce", actualResult);
    }
    @Test
    public void getTypeReturnRightType(){
        IngredientType actualResult = ingredient.getType();
        assertEquals(IngredientType.SAUCE, actualResult);
    }

}
