package praktikum;

import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Before
    public void createNewInstance() {
        burger = new Burger();
    }
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Test
    public void getPriceTest() {
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(1255.0f);

        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.  FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(ingredient.getPrice()).thenReturn(1255.0f);

        burger.addIngredient(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n",
                    ingredient.getType().name().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        String expected = receipt.toString();
        String actual = burger.getReceipt();
        assertEquals("Итоговая стоимость зависит от рецепта", expected, actual);
    }
}