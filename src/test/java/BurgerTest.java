import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Database database = new Database();
    List<Ingredient> ingredients = database.availableIngredients();
    List<Bun> buns = database.availableBuns();

    @Test
    public void setBunsTest() {
        burger.setBuns(buns.get(1));
        Mockito.verify(burger, Mockito.times(1)).setBuns(buns.get(1));
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredients.get(1));
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredients.get(1));
    }
    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(0);
    }
    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(0,1);
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(0,1);
    }
    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(400F);
        assertEquals("Метод должен возвращать цену 1000",1000, burger.getPrice(), 0);
    }
}