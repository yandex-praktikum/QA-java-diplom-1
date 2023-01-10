import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient newIngredient;

    @Before
    public void setUp(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float expectedResult = 300;
        assertEquals(expectedResult, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(ingredient.getName()).thenReturn("Ingredient");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        assertTrue(burger.getReceipt().contains(bun.getName()));
        assertTrue(burger.getReceipt().contains(ingredient.getName()));
    }

    @Test
    public void testRemoveIngredient() {
        int expectedResult = 0;
        burger.removeIngredient(0);
        assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(newIngredient);
        Mockito.when(ingredient.getName()).thenReturn("Sauce");
        Mockito.when(newIngredient.getName()).thenReturn("Filling");
        burger.moveIngredient(0, 1);
        String expectedResult = "Sauce";
        assertEquals(expectedResult, burger.ingredients.get(1).getName());
    }
}
