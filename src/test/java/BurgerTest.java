import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Database database = new Database();
    List<Ingredient> ingredients = database.availableIngredients();
    List<Bun> buns = database.availableBuns();
    Burger burger;
    @Spy
    Burger spyBurger = new Burger();

    @Test
    public void getPriceReturnCorrectCost(){
        burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(2));
        burger.addIngredient(ingredients.get(3));
        float expectedResult = 600.0F;
        float actualResult = burger.getPrice();
        assertEquals("Цены должны быть равны", expectedResult, actualResult, 0);
    }

    @Test
    public void getReceiptReturnCorrectString(){
        spyBurger.setBuns(buns.get(0));
        spyBurger.addIngredient(ingredients.get(0));
        Mockito.when(spyBurger.getPrice()).thenReturn(42.0F);
        String expectedResult = "(==== black bun ====)\n= sauce hot sauce =\n(==== black bun ====)\n\nPrice: 42,000000\n";
        String actualResult = spyBurger.getReceipt();
        assertEquals("Строки должны совппадать", expectedResult, actualResult);
    }

    @Test
    public void shouldAddIngredient(){
        burger = new Burger();
        int sizeBeforeAdd = burger.ingredients.size();
        burger.addIngredient(ingredients.get(1));
        int sizeAfterAdd = burger.ingredients.size();
        assertNotEquals("Размеры листа не должны совпадать", sizeBeforeAdd, sizeAfterAdd);
    }
    @Test
    public void shouldRemoveIngredient(){
        burger = new Burger();
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(5));
        int sizeBeforeRemove = burger.ingredients.size();
        burger.removeIngredient(0);
        int sizeAfterRemove = burger.ingredients.size();
        assertNotEquals("Размеры листа не должны совпадать", sizeBeforeRemove, sizeAfterRemove);
    }

    @Test
    public void shouldMovedIngredient(){
        burger = new Burger();
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(2));
        Ingredient elementBeforeMove = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        Ingredient elementAfterMove = burger.ingredients.get(1);
        assertEquals("Элементы должны совпадать", elementBeforeMove, elementAfterMove);
    }
}
