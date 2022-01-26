import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

public class BurgerRemoveIngredientTest {
    Burger burger;
    @Mock
    Ingredient ingredient1;
    @Before
    public void before(){
        burger = new Burger();
    }
    @Test
    public void testThatIngredientWasRemoved(){
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals("Ингредиент удалён",0,burger.ingredients.size());
    }
}
