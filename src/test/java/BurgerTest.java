import org.junit.Before;
import org.junit.Test;
import praktikum.*;
import java.util.List;
import static org.junit.Assert.*;


public class BurgerTest {

    public Database database = new Database();
    List<Bun> bunsData = database.availableBuns();
    List<Ingredient> ingredientsData = database.availableIngredients();

    @Before
    public void commonCheck() {
        if (bunsData.size() == 0) {
            bunsData.add(new Bun("black bun", 100));
        }
        if (ingredientsData.size() <= 2) {
            ingredientsData.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
            ingredientsData.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        }
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bunsData.get(0));
        assertEquals(bunsData.get(0).name, burger.bun.name);
        assertEquals(bunsData.get(0).price, burger.bun.price, 0);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientsData.get(0));
        assertTrue(burger.ingredients.contains(ingredientsData.get(0)));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.addAll(ingredientsData);
        Ingredient removeIngredient = burger.ingredients.get(0);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(removeIngredient));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.addAll(ingredientsData);
        Ingredient moveIngredient = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        Ingredient actualIngredient = burger.ingredients.get(1);
        assertEquals(moveIngredient, actualIngredient);
    }
}
