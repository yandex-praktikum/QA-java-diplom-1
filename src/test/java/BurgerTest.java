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

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private final Bun bun = new Bun("test bun name", 13.37f);
    private final IngredientType ingredientType = FILLING;
    private final Ingredient ingredient = new Ingredient(ingredientType, "test ingredient name", 17.03f);

    @Mock
    Bun bunMock;
    Burger burgerMock;
    Ingredient ingredientMock;

    @Before
    public void createBurger() {
        burger = new Burger();
        bunMock = Mockito.spy(bun);
        ingredientMock = Mockito.spy(ingredient);
        burgerMock = Mockito.spy(burger);
    }

    @Test
    public void shouldSetBuns() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }
    @Test
    public void shouldAddIngredient() {
        int i = burger.ingredients.size();
        burger.addIngredient(ingredientMock);
        assertEquals(i+1, burger.ingredients.size());
    }
    @Test
    public void shouldRemoveIngredient() {
        burger.addIngredient(ingredientMock);
        int i = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals(i-1, burger.ingredients.size());
    }
    @Test
    public void shouldMoveIngredient() {
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredientMock);
        burger.moveIngredient(0,1);
        assertEquals(ingredient, burger.ingredients.get(1));
        burger.moveIngredient(1, 0);
        assertEquals(ingredientMock, burger.ingredients.get(1));
    }
}
