package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameter()
    public IngredientType type;

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameters(name = "IngredientType: {0}, IngredientName: {1}, IngredientPrice: {2}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "sour cream", 200},
                {IngredientType.SAUCE, "cutlet", 100}
        });
    }

    @Test
    public void ingredientTypeReturnSAUCE() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингридиента не верный", type, ingredient.getType());
    }

}
