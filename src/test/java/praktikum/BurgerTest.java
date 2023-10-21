package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Spy
    Ingredient ingredient_cutlet = new Ingredient(IngredientType.FILLING, "cutlet", 100);

    @Spy
    Ingredient ingredient_chili = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);

    @Spy
    Ingredient ingredient_sausage = new Ingredient(IngredientType.FILLING, "sausage", 300);

    @Spy
    private Bun bun = new Bun("white bun", 200);

    @Spy
    private Burger burger = new Burger();

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient_cutlet);
        assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient_chili);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 0);
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient_chili);
        burger.addIngredient(ingredient_sausage);
        burger.moveIngredient(burger.ingredients.indexOf(ingredient_chili), burger.ingredients.indexOf(ingredient_sausage));
        assertEquals(1, burger.ingredients.indexOf(ingredient_chili));
        assertEquals(0, burger.ingredients.indexOf(ingredient_sausage));
    }

    @Test
    public void testBurgerGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient_cutlet);
        assertEquals(500, burger.getPrice(), 0);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient_cutlet, Mockito.times(1)).getPrice();
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = "(==== white bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 500,000000\r\n";
        burger.setBuns(bun);
        burger.addIngredient(ingredient_cutlet);
        assertEquals(expectedReceipt, burger.getReceipt());
        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(ingredient_cutlet, Mockito.times(1)).getName();
        Mockito.verify(ingredient_cutlet, Mockito.times(1)).getType();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
    }
}