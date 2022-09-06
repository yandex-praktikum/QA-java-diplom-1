import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BurgerTest {
    private final Bun bun = new Bun("black bun", 100);
    private final Ingredient ingredient_1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    private final Ingredient ingredient_2 = new Ingredient(IngredientType.FILLING, "cutlet", 200);

    @Test
    public void setBunsChangesBun() {
        Burger burger = new Burger();
        Bun expected = bun;
        burger.setBuns(expected);

        Bun actual = burger.bun;

        assertEquals("Bun is not equals expected bun", expected, actual);
    }

    @Test
    public void addIngredientAddCorrectIngredient() {
        Burger burger = new Burger();
        Ingredient expected = ingredient_1;
        burger.addIngredient(expected);

        Ingredient actual = burger.ingredients.get(0);

        assertEquals("Added ingredient is not expected ingredient", expected, actual);
    }


    @Test
    public void removeIngredientDeleteSelectedIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient_1);
        burger.ingredients.add(ingredient_2);
        burger.removeIngredient(1);

        List<Ingredient> actual = burger.ingredients;

        assertTrue("Ingredient is not removed", !actual.contains(ingredient_2));
    }

    @Test
    public void moveIngredientDeleteSelectedIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient_1);
        burger.ingredients.add(ingredient_2);
        burger.moveIngredient(1, 0);

        List<Ingredient> actual = burger.ingredients;

        assertTrue("Ingredient moved incorrect", actual.get(0).equals(ingredient_2));
    }
}
