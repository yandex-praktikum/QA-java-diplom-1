package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Bun bun = new Bun("black bun", 100);
    Burger burger = new Burger();
    Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals("Ошибка при выборе булки", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFilling);
        Assert.assertTrue("Ошибка при добавлении ингредиентов", burger.ingredients.contains(ingredientFilling));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFilling);
        burger.removeIngredient(0);
        Assert.assertFalse("Ошибка при удалении ингредиентов", burger.ingredients.contains(ingredientFilling));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ошибка при перемещение ингредиентов", 1, burger.ingredients.indexOf(ingredientFilling));
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        float expected = 600;
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        Assert.assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        String expected = "(==== black bun ====)\n" +
                "= filling cutlet =\n" +
                "= sauce chili sauce =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 600,000000\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }


}
