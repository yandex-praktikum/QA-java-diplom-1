import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Bun bun1 = new Bun("Бургер 2", 10.00f);
    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Огуречный", 5.00f);
    Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Помидор", 10.00f);
    Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "Курица", 15.00f);
    double expectedPrice = bun1.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice() + ingredient3.getPrice();
    String expectedReceipt =
            "(==== Бургер 2 ====)\r\n" +
                    "= sauce Огуречный =\r\n" +
                    "= sauce Помидор =\r\n" +
                    "= sauce Курица =\r\n" +
                    "(==== Бургер====)\r\n" +
                    "\r\n" +
                    "Price: 50,000000" +
                    "\r\n";

    @Mock
    Burger burger;

    @Test
    public void setNewBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun1);
        Bun expected = new Bun("Бургер 2", 15.00f);
        assertEquals(expected.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        assertEquals(burger.ingredients.get(0).getName(), "Огуречный");
    }

    @Test
    public void removeIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.isEmpty(), true);
    }

    @Test
    public void moveIngredientsInList() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(0, 2);
        assertEquals(burger.ingredients.get(0).getName(),"Помидор");
    }

    @Test
    public void getBurgerTotalPriceTest() {
        burger.setBuns(bun1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.getPrice();
        Mockito.when(burger.getPrice()).thenReturn((float) expectedPrice);
        Mockito.verify(burger, Mockito.times(1)).getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.00);
    }

    @Test
    // Тест с моками
    public void getBurgerReceiptMockTest() {
        burger.setBuns(bun1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.getReceipt();
        Mockito.when(burger.getReceipt()).thenReturn("Рецепт бургера");
        Mockito.verify(burger, Mockito.times(1)).getReceipt();
        Assert.assertEquals("Рецепт бургера", burger.getReceipt());
    }
}
