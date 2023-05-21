import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    @Test
    public void testGetPrice() {
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(1.0f);

        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient1.getPrice()).thenReturn(1.2f);

        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient2.getPrice()).thenReturn(1.2f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(4.4f, burger.getPrice(), 0.01f);
    }

    @Test
    public void testGetReceipt() {
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn("Sesame");

        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("Beef");
        Mockito.when(ingredient1.getPrice()).thenReturn(2.0f);


        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("Ketchup");
        Mockito.when(ingredient2.getPrice()).thenReturn(0.2f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = "(==== Sesame ====)\n" +
                "= filling Beef =\n" +
                "= sauce Ketchup =\n" +
                "(==== Sesame ====)\n" +
                "\n" +
                "Price: 2,200000\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }


    @Test
    public void testAddIngredient() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        List<Ingredient> ingredients = new ArrayList<>();

        Burger burger = new Burger();
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        Burger burger = new Burger();
        burger.ingredients = ingredients;
        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Ingredient ingredient3 = Mockito.mock(Ingredient.class);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);

        Burger burger = new Burger();
        burger.ingredients = ingredients;
        burger.moveIngredient(0, 2);

        assertEquals(3, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient3, burger.ingredients.get(1));
        assertEquals(ingredient1, burger.ingredients.get(2));
    }
}