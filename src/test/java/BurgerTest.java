import org.junit.Before;
import org.junit.Test;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BurgerTest {
    List<Bun> buns;
    List<Ingredient> ingredients_;
    Burger burger;
    Database database;

    @Before
    public void setUp(){
        burger = new Burger();
        database = new Database();
        buns = database.availableBuns();
        ingredients_ = database.availableIngredients();
        burger.addIngredient(ingredients_.get(1));
    }

    @Test
    public void getPrice() {
        burger.setBuns(buns.get(0));
        assertEquals(burger.getPrice(), 400, 0);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(buns.get(0));
        assertNotNull(burger.getReceipt());
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(),0);
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredients_.get(2));
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients.get(0).name,"chili sauce");
    }
}
