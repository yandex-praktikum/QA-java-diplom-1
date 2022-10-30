import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Ingredient ingredient;

    @Mock
    private Bun bun;


    @Test
    public void getPriceTest() {
   //     Mockito.when(database.availableBuns()).thenReturn("black bun", 100");
   //     Mockito.when(bun.getPrice()).thenReturn(20F);

        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
  //      Database database = new Database();
   //     List<Ingredient> ingredients = database.availableIngredients();
  //      List<Bun> buns = database.availableBuns();
  //      burger.setBuns("black bun", 100);
//        burger.addIngredient(IngredientType.SAUCE, "hot sauce", 100);
        int actual = (int) burger.getPrice();
        int expected = 300;
        Assert.assertEquals(expected, actual);

    }
}
