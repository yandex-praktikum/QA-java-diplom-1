package praktikum;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BurgerIngredientTest {

    Database database = new Database();
    Burger burger;
    List<Bun> buns = database.availableBuns();
    List<Ingredient> ingredients = database.availableIngredients();
    Bun bun;
    Ingredient ingredient;
    Ingredient anotherIngredient;

    @Before
    public void createBurger() {
        int bunIndex = new Random().nextInt(buns.size());
        int ingredientIndex = new Random().nextInt(ingredients.size());
        this.burger = new Burger();
        this.ingredient = ingredients.get(ingredientIndex);
        this.bun = buns.get(bunIndex);
        burger.setBuns(bun);
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        assertThat(burger.getReceipt(), containsString(ingredient.getName()));
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertThat(burger.getReceipt(), not(containsString((ingredient.getName()))));
    }

    @Test
    public void checkMoveIngredient() {
        this.anotherIngredient = ingredients.get(new Random().nextInt(ingredients.size()));
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(0,1);
        assertThat(burger.getReceipt(), containsString(String.format("%s =%n(", ingredient.getName())));
    }

    @Test
    public void checkGetPriceWithIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(bun.getPrice() *2 + ingredient.getPrice(), burger.getPrice(), 0);
    }

    @Test
    public void checkGetPriceWithoutIngredient() {
        assertEquals(bun.getPrice() *2, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceiptWithIngredient() {
        burger.addIngredient(ingredient);
        assertThat(burger.getReceipt(), endsWith(String.format("%.6f%n", bun.getPrice() * 2 + ingredient.getPrice())));
    }

    @Test
    public void checkGetReceiptWithoutIngredient() {
        assertThat(burger.getReceipt(), endsWith(String.format("%.6f%n", bun.getPrice() * 2)));
    }
}
