import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.*;

public class BurgerTest {
    private final Bun bun = new Bun("black bun", 100);
    private final Ingredient ingredient_1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    private final Ingredient ingredient_2 = new Ingredient(IngredientType.FILLING, "cutlet", 200);

    @Test
    public void setBunsChangesBun() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        Bun actual = burger.bun;

        assertEquals("Bun is not equal to expected value", bun, actual);
    }

    @Test
    public void addIngredientAddCorrectIngredient() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient_1);
        Ingredient actual = burger.ingredients.get(0);

        assertEquals("Added ingredient is not expected ingredient", ingredient_1, actual);
    }


    @Test
    public void removeIngredientDeleteSelectedIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient_1);
        burger.ingredients.add(ingredient_2);

        burger.removeIngredient(1);
        List<Ingredient> actual = burger.ingredients;

        assertFalse("Ingredient is not removed", actual.contains(ingredient_2));
        assertTrue("Wrong ingredient is removed", actual.contains(ingredient_1));
    }

    @Test
    public void moveIngredientDeleteSelectedIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient_1);
        burger.ingredients.add(ingredient_2);
        burger.moveIngredient(1, 0);

        List<Ingredient> actual = burger.ingredients;

        assertEquals("Ingredient moved incorrect", ingredient_2, actual.get(0));
        assertEquals("Ingredient moved incorrect", ingredient_1, actual.get(1));
    }
}
