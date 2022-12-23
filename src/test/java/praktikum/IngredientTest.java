package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    private final String name = RandomStringUtils.randomAlphabetic(1, 5);
    private final float price = new Random().nextFloat();
    private final IngredientType type = mock(IngredientType.class);

    private final Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void ingredientGetTypeTest() {

        assertEquals(type, ingredient.getType());
    }

    @Test
    public void ingredientGetNameTest() {

        assertEquals(name, ingredient.getName());
    }

    @Test
    public void ingredientGetPriceTest() {

        assertEquals(price, ingredient.getPrice(), 0.0f);
    }
}