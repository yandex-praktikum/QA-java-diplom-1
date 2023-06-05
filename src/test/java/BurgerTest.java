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
    Bun bunNew = new Bun("Обыкновенная булочка", 10.00f);
    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Огуречный", 5.00f);
    Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Помидор", 10.00f);
    Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "Курица", 15.00f);
    double expectedPrice = bunNew.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice() + ingredient3.getPrice();
    String expectedReceipt =
            "(==== Обыкновенная булочка ====)\r\n" +
                    "= sauce Огуречный =\r\n" +
                    "= sauce Помидор =\r\n" +
                    "= sauce Курица =\r\n" +
                    "(==== Обыкновенная булочка ====)\r\n" +
                    "\r\n" +
                    "Price: 50,000000" +
                    "\r\n";

    @Mock
    Bun bun;

    @Test
    public void setNewBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bunNew);
        Bun expected = new Bun("Обыкновенная булочка", 15.00f);
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
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Mockito.when(bun.getPrice()).thenReturn(50.00f);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.00);
    }

    @Test
    public void getBurgerReceiptTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Mockito.when(bun.getName()).thenReturn("Обыкновенная булочка");
        Mockito.verify(bun, Mockito.times(2)).getName();
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
