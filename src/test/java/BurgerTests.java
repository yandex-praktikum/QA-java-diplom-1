import org.junit.Test;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTests {
    @Test
    public void getPriceBurgerTest() {

        Database mockDatabase = mock(Database.class);

        List<Bun> buns = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();

        buns.add(new Bun("test_1 bun", 100));
        buns.add(new Bun("test_2 bun", 200));
        buns.add(new Bun("test_3 bun", 300));

        ingredients.add(new Ingredient(IngredientType.SAUCE, "test_1 ingredient", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "test_2 ingredient", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "test_3 ingredient", 300));
        ingredients.add(new Ingredient(IngredientType.FILLING, "test_4 ingredient", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "test_5 ingredient", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "test_6 ingredient", 300));

        when(mockDatabase.availableBuns()).thenReturn(buns);
        when(mockDatabase.availableIngredients()).thenReturn(ingredients);

        Burger burger = new Burger();

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(5));
        burger.moveIngredient(2, 1);
        burger.removeIngredient(3);

        float expectedPrice = 700.0f;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptBurgerTest() {
        Database mockDatabase = mock(Database.class);

        List<Bun> buns = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();

        buns.add(new Bun("test_1 bun", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "test_1 ingredient", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "test_5 ingredient", 200));

        when(mockDatabase.availableBuns()).thenReturn(buns);
        when(mockDatabase.availableIngredients()).thenReturn(ingredients);

        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));

        double expectedPrice = 500.0;

        double actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.1);

        String actualReceipt = burger.getReceipt();
        System.out.println("Фактический чек:");
        System.out.println(actualReceipt);

        assertEquals(expectedPrice, actualPrice, 0.1);
    }
}
