import org.junit.Test;
import org.mockito.Mock;
import praktikum.IngredientType;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class BurgerTest {

    private String name;
    private String ingregiants;
    private float price;
    @Mock
    Burger burger = new Burger();
    Bun bun = new Bun(name, price);
    @Test
    public void testAddIngredient() {
        Ingredient lettuce = new Ingredient(IngredientType.SAUCE,"Lettuce", 0.5f);
        burger.addIngredient(lettuce);
        List<Ingredient> ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(lettuce));
    }

    @Test
    public void testRemoveIngredientByIndex() {
        Ingredient lettuce = new Ingredient(IngredientType.SAUCE,"Lettuce", 200.0f);
        Ingredient tomato = new Ingredient(IngredientType.FILLING,"sausage", 300.0f);
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
    }
    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "sausage", 300.0f);
        Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "sour cream", 100.0f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient2, burger.getIngredients().get(0));
        assertEquals(ingredient1, burger.getIngredients().get(1));
        assertEquals(ingredient3, burger.getIngredients().get(2));
        burger.moveIngredient(2, 1);
        assertEquals(ingredient2, burger.getIngredients().get(0));
        assertEquals(ingredient3, burger.getIngredients().get(1));
        assertEquals(ingredient1, burger.getIngredients().get(2));
    }

    @Test
    public void testGetPrice() {
        // Burger burger = new Burger();
        Bun bun = new Bun("red bun", 300.0f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE,"chili sauce", 300.0f);
        Ingredient sausage = new Ingredient(IngredientType.FILLING,"sausage",  300.0f);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(sausage);
        float price = burger.getPrice();
        assertEquals(1200.0f, price, 1.0f);
    }
     @Test
    public void testGetReceipt() {
      Bun bun = new Bun("black bun", 100);
      Ingredient sauce = new Ingredient(IngredientType.SAUCE,"hot sauce",  100);
      Ingredient dinosaur = new Ingredient(IngredientType.FILLING,"dinosaur", 200);
      Burger burger = new Burger();
       burger.addIngredient(sauce);
        burger.addIngredient(dinosaur);
        String expectedReceipt = "(==== black bun ====)\r\n" +
            "= sauce hot sauce =\r\n" +
            "= filling dinosaur =\r\n" +
          "(==== black bun ====)\r\n" +
         "\r\n" +
         "Price: 500,000000\r\n";
         assertEquals(expectedReceipt, burger.getReceipt());
     }

    @Test
    public void testSetIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100.0f );
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "dinosaur", 100.0f);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        Burger recipe = new Burger();
        recipe.setIngredients(ingredients);
        assertEquals(ingredients, recipe.getIngredients());
    }

}

