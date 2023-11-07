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
    @Mock
    Burger burger = new Burger();


    @Test
    public void testAddIngredient() {
        Ingredient lettuce = new Ingredient(IngredientType.SAUCE,"Lettuce", 100);
        burger.addIngredient(lettuce);
        List<Ingredient> ingredients = burger.getIngredients();
        assertFalse(ingredients.isEmpty());
    }

    @Test
    public void testRemoveIngredientByIndex() {
        Ingredient lettuce = new Ingredient(IngredientType.SAUCE,"Lettuce", 200);
        Ingredient tomato = new Ingredient(IngredientType.FILLING,"sausage", 300);
        burger.addIngredient(lettuce);
        burger.addIngredient(tomato);
        List<Ingredient> ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(lettuce));
        assertTrue(ingredients.contains(tomato));
        int indexToRemove = 1; // remove sausage
        burger.removeIngredient(indexToRemove);
        ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(lettuce));
        assertFalse(ingredients.contains(tomato));
        assertFalse(ingredients.contains(new Ingredient(IngredientType.FILLING,"sausage", 300))); // Negative test case to check if the removed ingredient is still present in the list
    }

    @Test
    public void testGetPriceNegative() {
        Burger burger = new Burger();
        Bun bun = new Bun("red bun", 300.0f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE,"chili sauce", 300);
        Ingredient sausage = new Ingredient(IngredientType.FILLING,"sausage",  300);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(sausage);
        float price = burger.getPrice();
        assertNotEquals(1000, price, 1.0);
    }
}
