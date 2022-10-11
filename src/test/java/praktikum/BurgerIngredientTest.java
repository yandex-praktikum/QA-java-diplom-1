package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTest {

    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient anotherIngredient;
    @Mock
    private Burger burger;
    @Mock
    private Bun bun;

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void checkRemoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }

    @Test
    public void checkMoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(0,1);
        Mockito.verify(burger).moveIngredient(0, 1);
    }
}
