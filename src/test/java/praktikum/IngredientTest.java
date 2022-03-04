package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    // Dummy tests data:
    private final String name = "hot sauce";
    private final float price = 100f;
    IngredientType type = IngredientType.FILLING;

    @Spy
    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void testGetPrice() {
        float delta = 0.0f;
        float actualPrice = ingredient.getPrice();

        Mockito.verify(ingredient).getPrice();
        assertEquals(price, actualPrice, delta);
    }

    @Test
    public void testGetName() {
        String actualName = ingredient.getName();

        Mockito.verify(ingredient).getName();
        assertEquals(name, actualName);
    }

    @Test
    public void testGetType() {
        IngredientType actualType = ingredient.getType();

        Mockito.verify(ingredient).getType();
        assertEquals(type, actualType);
    }
}