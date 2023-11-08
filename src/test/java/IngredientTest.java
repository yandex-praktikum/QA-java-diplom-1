import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    @Mock
    Ingredient ingredient;

    @Test
    public void testgetPrice()
        {
        ingredient = new Ingredient(SAUCE, "hot sauce", 100);
      float actual = ingredient.getPrice();
        assertEquals(100, ingredient.getPrice(),1);
    }

    @Test
    public void testgetName()
    {
        ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        String actual = ingredient.getName();
        assertEquals("hot sauce", actual);
    }

    @Test
    public void testgetType() {
        ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        IngredientType actual = ingredient.getType();
        assertEquals(SAUCE, ingredient.getType());
    }

}
