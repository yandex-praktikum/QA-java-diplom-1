package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 0.6f);
    }

    @Test
    public void testGetPrice() {
        assertEquals(0.6f, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testGetName() {
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}