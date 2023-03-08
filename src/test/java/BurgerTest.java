import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

   @Mock
   Bun bun;

   @Mock
   Ingredient ingredient;

    @Test
    public void addingIngredientsTest() {
        burger.addIngredient(ingredient);
        int ingredientSize = burger.ingredients.size();
        boolean actual = ingredientSize > 0;
        assertTrue(actual);
    }

    @Test
    public void removingIngredientsTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0,burger.ingredients.size());
    }

    @Test
    public void movingIngredientsTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(1,2);
        assertEquals(3, burger.ingredients.size());
    }


    @Test
    public void gettingBurgerRecipeTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getName()).thenReturn("Краторная булка N-200i");
        when(ingredient.getType()).thenReturn(FILLING);
        when(ingredient.getName()).thenReturn("Биокотлета из марсианской Магнолии");
        when(bun.getPrice()).thenReturn(300f);
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                        ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        String actual = burger.getReceipt();
        assertEquals(expectedReceipt, actual);
    }
}


