package praktikum.burger.test.suit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerAddIngredientTest {
    @Mock
    Ingredient testIngredient;

    @Test
    public void burgerAddIngredientTest() {
        Burger testBurger = new Burger();
        int countBeforeAdd = testBurger.ingredients.size();
        testBurger.addIngredient(testIngredient);
        int countAfterAdd = testBurger.ingredients.size();
        assertEquals(1,
                countAfterAdd - countBeforeAdd);
    }
}
