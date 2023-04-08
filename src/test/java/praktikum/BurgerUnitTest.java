package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BurgerUnitTest {
    Burger burger;
    Ingredient ingredientHotSauce = (new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
    Ingredient ingredientCutlet = (new Ingredient(IngredientType.FILLING, "cutlet", 100));
    Ingredient ingredientSourCream = (new Ingredient(IngredientType.SAUCE, "sour cream", 200));
    Bun bun;

    @Before
    public void SetUp() {
        burger = new Burger();
        burger.addIngredient(ingredientCutlet);
        burger.addIngredient(ingredientSourCream);
        burger.addIngredient(ingredientHotSauce);
    }

    @Test
    public void addIngredientTest() {
        Assert.assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeAllIngredientTest() {
        for (int i = burger.ingredients.size(); i > 0; i--) {
            burger.removeIngredient(i - 1);
        }
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(1, 2);
        Assert.assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void getPriceTest() {
        bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        Assert.assertEquals(600, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest() {
        bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        for (int i = 0; i < burger.ingredients.size(); i++) {
            String expected = burger.ingredients.get(i).name;
            String actual = burger.getReceipt();
            Assert.assertTrue(actual.contains(expected));
        }
    }

    @Test
    public void getReceiptWithoutIngredientsBunTest() {
        for (int i = burger.ingredients.size(); i > 0; i--) {
            burger.removeIngredient(i - 1);
        }
        bun = new Bun("Red bun", 100);
        burger.setBuns(bun);
        Assert.assertTrue(burger.getReceipt().contains(burger.bun.getName()));
    }
}
