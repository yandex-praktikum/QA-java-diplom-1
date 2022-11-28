import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    Bun bun;
    Database database = new Database();
    @Before
    public void createBurger() {
        burger = new Burger();
        for(int i = 0; i <= 5; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
    }
    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Bun actual = burger.bun;
        assertEquals(bun, actual);
    }

    @Test
    public void addIngredientTest(){
        int actual = burger.ingredients.size();
        assertEquals("Quantity ingredients is incorrect",6, actual);
    }

    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        assertEquals("Removing ingredients is incorrect", 5, actual);
    }

    @Test
    public void moveIngredientTest(){
        Ingredient actual = burger.ingredients.get(2);
        burger.moveIngredient(2, 1);
        Ingredient expected = burger.ingredients.get(1);
        assertEquals("Moving ingredients is incorrect", expected, actual);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        burger.addIngredient(database.availableIngredients().get(1));
        float actual = burger.getPrice();
        assertEquals("Price is incorrect", 1800F, actual, 0.0001F);
    }

}
