import org.junit.Test;
import  static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.Burger;
import java.util.List;
import praktikum.Bun;

public class NegativeBurgerTest {
    private static final float UNEXPECTED = 1000.0F;
    @Mock
    Burger burger = new Burger();
    Bun bun = new Bun("red bun", 300.0f);
    Ingredient sauce = new Ingredient(IngredientType.SAUCE,"chili sauce", 300);
    Ingredient sausage = new Ingredient(IngredientType.FILLING,"sausage",  300);


    @Test
    public void testAddIngredient() {
        burger.addIngredient(sauce);
        List<Ingredient> ingredients = burger.getIngredients();
        assertFalse(ingredients.isEmpty());
    }

    @Test
    public void testRemoveIngredientByIndex() {
        burger.addIngredient(sauce);
        burger.addIngredient(sausage);
        List<Ingredient> ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(sauce));
        assertTrue(ingredients.contains(sausage));
        int indexToRemove = 1;
        burger.removeIngredient(indexToRemove);
        ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(sauce));
        assertFalse(ingredients.contains(sausage));
        assertFalse(ingredients.contains(new Ingredient(IngredientType.FILLING,"sausage", 300))); // Negative test case to check if the removed ingredient is still present in the list
    }

    @Test
    public void testGetPriceNegative() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(sausage);
        float price = burger.getPrice();
        assertNotEquals(UNEXPECTED, price, 1.0);
    }
}
