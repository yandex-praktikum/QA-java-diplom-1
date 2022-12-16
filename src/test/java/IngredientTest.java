import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;


public class IngredientTest {

    Ingredient ingredient;

    @Test
    public void getPriceTest(){
        ingredient = new Ingredient(IngredientType.SAUCE, "продукт", 200F);
        float actual = ingredient.getPrice();
        System.out.println(actual);
        assertEquals(200.0, actual, 0);
    }

    @Test
    public void getNameTest(){
        ingredient = new Ingredient(IngredientType.SAUCE, "продукт", 200F);
        String actual = ingredient.getName();
        assertThat( actual, containsString("продукт"));
    }

    @Test
    public void getTypeTest(){
        ingredient = new Ingredient(IngredientType.SAUCE, "продукт", 200F);
        String actual = String.valueOf(ingredient.getType());
        assertThat( actual, containsString("SAUCE"));
    }
}
