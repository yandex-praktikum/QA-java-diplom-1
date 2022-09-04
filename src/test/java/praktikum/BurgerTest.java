package praktikum;

import net.bytebuddy.utility.RandomString;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientMove;

    Random random = new Random();
    static RandomString randomAlphabetic = new RandomString();

    String name = randomAlphabetic.nextString();
    float price = random.nextFloat();

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void setBuns() {
        assertEquals("Ожидаемое и фактическое значение булочки не совпадают", bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        assertNotNull("Ингредиенты не добавились", burger.ingredients);
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(0);
        assertTrue("Ингредиенты не удалились", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredientMove);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient, burger.ingredients.get(1));
        assertEquals("Ингредиенты не поменялись местами", ingredientMove, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        when(bun.getPrice()).thenReturn(price);
        when(ingredient.getPrice()).thenReturn(price);
        assertEquals("Ожидаемая и фактическая цена не совпадают", price * 2 + price, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        when(bun.getName()).thenReturn(name);
        when(ingredient.getType()).thenReturn(SAUCE);
        when(ingredient.getName()).thenReturn(name);
        String expected = String.format("(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                name, SAUCE.toString().toLowerCase(), name, name, ingredient.getPrice());
        assertEquals("Ожидаемый и фактический чек не совпадают", expected, burger.getReceipt());
    }
}