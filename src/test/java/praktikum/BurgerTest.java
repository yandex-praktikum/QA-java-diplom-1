package praktikum;
import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;


public class BurgerTest {
    @Mock
    Bun mocBun;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>();
        Ingredient ingredient1 = new Ingredient(praktikum.IngredientType.FILLING, "Котлета", 10);
        burger.addIngredient(ingredient1);
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>();
        Ingredient ingredient1 = new Ingredient(praktikum.IngredientType.FILLING, "Котлета", 10);
        Ingredient ingredient2 = new Ingredient(praktikum.IngredientType.FILLING, "Сыр", 5);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>();
        Ingredient ingredient1 = new Ingredient(praktikum.IngredientType.FILLING, "Котлета", 10);
        Ingredient ingredient2 = new Ingredient(praktikum.IngredientType.FILLING, "Сыр", 5);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
    }
    @Test
    public void getPriceTest(){
Burger burger = new Burger();
burger.setBuns(mocBun);
        Mockito.when(mocBun.getPrice()).thenReturn(10.00f);
        float actual = burger.getPrice();
        float expected = 20.00f;
        assertEquals(expected, actual, 0.001);
    }
    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
Mockito.when(mocBun.getName()).thenReturn("классическая");
Mockito.when(mocBun.getPrice()).thenReturn(10.00f);
burger.setBuns(mocBun);
        burger.ingredients = new ArrayList<>();
        Ingredient ingredient1 = new Ingredient(praktikum.IngredientType.FILLING, "котлета", 10);
        burger.addIngredient(ingredient1);
String expected = "(==== классическая ====)\n" +
        "= filling котлета =\n" +
        "(==== классическая ====)\n" +
        "\n" +
        "Price: 30,000000" +
        "\n";
String actual = burger.getReceipt();
assertEquals(expected, actual);
    }
}
