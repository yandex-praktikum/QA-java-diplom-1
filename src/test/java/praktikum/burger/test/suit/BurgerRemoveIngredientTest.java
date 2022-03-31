package praktikum.burger.test.suit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class BurgerRemoveIngredientTest {
    @Mock
    Ingredient testIngredient;

    @Test
    public void removeIngredientTest() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(testIngredient);
        int countBeforeRemove = testBurger.ingredients.size();
        testBurger.removeIngredient(--countBeforeRemove);
        int countAfterRemove = testBurger.ingredients.size();
        Assert.assertEquals(1, countBeforeRemove - countAfterRemove);
    }
}