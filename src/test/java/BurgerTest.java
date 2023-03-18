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

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void whenCallSetBunsThenBunInitialize() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void whenCallAddIngredientThenListAddElement() {
        burger.addIngredient(ingredient);

        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void whenCallRemoveIngredientThenListRemoveElement() {
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void whenCallRemoveMoveIngredientThenListMoveElement() {
        Ingredient ingredientOne = new Ingredient(IngredientType.FILLING, "xxx", 1);
        Ingredient ingredientTwo = new Ingredient(IngredientType.SAUCE, "yyy", 2);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        burger.moveIngredient(0, 1);

        assertEquals(burger.ingredients.get(0), ingredientTwo);
    }

    @Test
    public void whenCallGetPriceThenReturnPrice() {
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expected = 30f;

        float actual = burger.getPrice();

        assertEquals(expected, actual, 0);
    }
}

