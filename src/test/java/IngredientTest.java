import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Mini salad Exo-Plantago",4400);
    private IngredientType ingredientType;

    public IngredientTest(IngredientType ingredientType) {

        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][] {
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void getIngredientTest(){
        Ingredient ingredient = new Ingredient(ingredientType, RandomString.make(10), new Random().nextFloat());
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void getIngredientPrice(){
        float actual = ingredient.getPrice();
        float expected = 4400;
        assertEquals(0, expected, actual);
    }

    @Test
    public void getIngredientNameTest(){
        String actual = ingredient.getName();
        String expected = "Mini salad Exo-Plantago";
        assertEquals("we don't have this topping name", expected, actual);
    }

    @Test
    public void getIngredientTypeTest(){
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.FILLING;
        assertEquals("we don't have this topping", expected, actual);
    }

}
