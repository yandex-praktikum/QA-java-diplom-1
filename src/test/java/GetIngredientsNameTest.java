import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class GetIngredientsNameTest {
    @Test
    public void canGetIngredientName(){
        String name = RandomString.make(10);
        Ingredient ingredient = new Ingredient(SAUCE, name, 123);
        assertEquals(name, ingredient.getName());
    }
}