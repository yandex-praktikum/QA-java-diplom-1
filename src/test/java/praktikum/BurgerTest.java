package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    private final int ingredientIndexToRemove = 0;
    private final int ingredientIndexMoveFrom = 0;
    private final int ingredientIndexMoveTo = 1;

    @Mock
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(ingredientIndexToRemove);
        Mockito.verify(burger).removeIngredient(ingredientIndexToRemove);
    }

    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(ingredientIndexMoveFrom, ingredientIndexMoveTo);
        Mockito.verify(burger).moveIngredient(ingredientIndexMoveFrom, ingredientIndexMoveTo);
    }
}
