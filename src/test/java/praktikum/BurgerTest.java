package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static praktikum.TestUtils.getMockedIngredient;

public class BurgerTest {

    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBunsReturnSetBun() {
        Bun bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        Assert.assertEquals("The burger should have \"black bun\" which costs 100", bun, burger.bun);
    }

    @Test
    public void testAddIngredientReturnAddedIngredient() {
        Ingredient expected = getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(expected);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("The burger should have \"hot sauce\" which costs 100", expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNonExistentIngredientThrowsException() {
        burger.removeIngredient(0);
    }

    @Test
    public void testRemoveIngredientFromBurgerWithOneIngredientResultsInBurgerWithNoIngredients() {
        Ingredient ingredient = getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);
        Assert.assertTrue("The burger should be empty after the only ingredient removal", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredientResultsInCorrectRearrangement() {
        Ingredient ingredient1 = getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredient2 = getMockedIngredient(IngredientType.SAUCE, "sour cream", 200);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);
        Assert.assertEquals("The second ingredient in the burger should be hot sauce", ingredient1.name, burger.ingredients.get(1).name);
    }
}