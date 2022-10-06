package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    List<Ingredient> ingredients = new ArrayList<>();
    Burger burger  = new Burger();
    @Mock
       Bun bun;

    @Before
    public void setUp(){
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));

    }

    @Test
    public void setBuns() {
          burger.setBuns(bun);
          assertNull(burger.bun.name);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredients.get(0));
        assertEquals(1,burger.ingredients.size());
        burger.removeIngredient(0);
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredients.get(0));
        burger.removeIngredient(0);
        assertEquals(0,burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(0,1);
        assertEquals(burger.ingredients.get(1),ingredients.get(0));
        burger.removeIngredient(0);
        burger.removeIngredient(0);
    }

    @Test
   public void getReceipt() {
        burger.addIngredient(ingredients.get(0));
        burger.setBuns(bun);
        burger.getReceipt();
        assertTrue(true);
    }
}