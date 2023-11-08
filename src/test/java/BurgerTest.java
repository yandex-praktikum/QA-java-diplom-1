import org.junit.Test;
import org.mockito.Mock;
import praktikum.IngredientType;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.List;
import static org.junit.Assert.assertEquals;



public class BurgerTest {

    @Mock
    Burger burger = new Burger();
    Bun bun = new Bun("black bun", 100);
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "sasusage", 300);
    Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
    List<Ingredient> ingredients = new ArrayList<>();

    @Test
   public void testAddIngredient() {
        burger.addIngredient(ingredient);
        List<Ingredient> ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(ingredient));
    }


    @Test
    public void testRemoveIngredientByIndex() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        List<Ingredient> ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(ingredient));
        assertTrue(ingredients.contains(ingredient2));
        int indexToRemove = 1;
        burger.removeIngredient(indexToRemove);
        ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(ingredient));
        assertFalse(ingredients.contains(ingredient2));
    }
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient2, burger.getIngredients().get(0));
        assertEquals(ingredient, burger.getIngredients().get(1));
        assertEquals(ingredient3, burger.getIngredients().get(2));
        burger.moveIngredient(2, 1);
        assertEquals(ingredient2, burger.getIngredients().get(0));
        assertEquals(ingredient3, burger.getIngredients().get(1));
        assertEquals(ingredient, burger.getIngredients().get(2));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient2);
        float price = burger.getPrice();
        assertEquals(800.0f, price, 1.0f);
    }
     @Test
    public void testGetReceipt() {
       burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        String expectedReceipt = "(==== black bun ====)\r\n" +
            "= sauce hot sauce =\r\n" +
            "= filling sasusage =\r\n" +
          "(==== black bun ====)\r\n" +
         "\r\n" +
         "Price: 600,000000\r\n";
         assertEquals(expectedReceipt, burger.getReceipt());
     }

    @Test
    public void testSetIngredients() {
        ingredients.add(ingredient);
        ingredients.add(ingredient2);
        burger.setIngredients(ingredients);
        assertEquals(ingredients, burger.getIngredients());
    }

    @Test
    public void testSetPrice() {
        float price = 200;
        burger.setPrice(price);
        assertEquals(price,200, 0.01);
    }
    @Test
    public void testSetName() {
        String name = "hamburger";
        burger.setName(name);
        assertEquals(name,"hamburger", "hamburger");
    }

}

