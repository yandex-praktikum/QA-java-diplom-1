import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Mock
    private Ingredient mockIngredient;
    @Test
    public void testConstructor() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Beef", 10.0f);
        assertEquals(IngredientType.FILLING, ingredient.getType());
        assertEquals("Beef", ingredient.getName());
        assertEquals(10.0f, ingredient.getPrice(), 0.0f);
    }
    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Carrot", 2.5f);
        assertEquals(2.5f, ingredient.getPrice(), 0.0f);
    }
    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 1.0f);
        assertEquals("Ketchup", ingredient.getName());
    }
    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cheddar", 3.0f);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @Test
    public void testMockGetPrice() {
        Mockito.when(mockIngredient.getPrice()).thenReturn(5.0f);
        assertEquals(5.0f, mockIngredient.getPrice(), 0.0f);
    }
    @Test
    public void testMockGetName() {
        Mockito.when(mockIngredient.getName()).thenReturn("Mushrooms");
        assertEquals("Mushrooms", mockIngredient.getName());
    }
    @Test
    public void testMockGetType() {
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        assertEquals(IngredientType.FILLING, mockIngredient.getType());
    }
}
