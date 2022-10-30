import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {



    @Mock
    private Database database;

  //  @Mock
  //  private Bun bun;


    @Test
    public void getPriceTest() {
   //     Mockito.when(database.availableBuns()).thenReturn("black bun", 100");
   //     Mockito.when(bun.getPrice()).thenReturn(20F);
        Burger burger = new Burger();
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        List<Bun> buns = database.availableBuns();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        int actual = (int) burger.getPrice();
        int expected = 400;
        Assert.assertEquals(expected, actual);

    }
}
