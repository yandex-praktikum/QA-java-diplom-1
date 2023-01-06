package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMoveIngredientsTest {

    private final Ingredient ingredient1 = mock(Ingredient.class);
    private final Ingredient ingredient2 = mock(Ingredient.class);

    private final Burger burger = new Burger();

    @Before
    public void setUp() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }

    @Test
    public void burgerMoveIngredientTest() {

        burger.moveIngredient(0, 1);

        assertEquals(2, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void burgerRemoveIngredientTest() {

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }
}
