import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.Bun;
import praktikum.Burger;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;

    @Test
    public void addIngredientTest() {
        int expected = 2;
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("red bun",300));
        assertEquals(600, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest() {
        Database database=new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        List<Bun> buns = database.availableBuns();
        Burger burger = new Burger(bun,ingredients);
        Mockito.when(bun.getName()).thenReturn(buns.get(2).getName());
        burger.getReceipt();
        Mockito.verify(bun,Mockito.times(2)).getName();
        System.out.println(burger.getReceipt().toString());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.removeIngredient(1);
        assertEquals(List.of(sauce), burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, 0);
        assertEquals(List.of(filling, sauce), burger.ingredients);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
}

