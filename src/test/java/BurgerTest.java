import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Before
    public void setUp() {
        Mockito.when(bun.getPrice()).thenReturn(DataForTests.BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(DataForTests.INGREDIENT_PRICE);
        Mockito.when(ingredient.getName()).thenReturn(DataForTests.INGREDIENT_NAME);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        int ingredientSize = burger.ingredients.size();
        boolean actual = ingredientSize > 0;

        assertTrue("The size of the ingredients list must be greater than 0", actual);
    }
    @Test
    public void removeIngredientTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(DataForTests.FIRST_INGREDIENT);

        Assert.assertEquals(DataForTests.EXPECTED_BURGER_PRICE_AFTER_DELETION, burger.getPrice(), 0);
    }
    @Test
    public void moveIngredientTest() {
        Ingredient newIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        burger.moveIngredient(0, 1);

        assertEquals(DataForTests.INGREDIENT_NAME, burger.ingredients.get(1).getName());
    }
    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(DataForTests.EXPECTED_BURGER_PRICE, burger.getPrice(), 0);
    }
}
