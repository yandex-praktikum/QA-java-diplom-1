package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class BurgerReceiptTest {
    private static Database db = new Database();
    private static List<Bun> buns;
    private static List<Ingredient> ingredients;

    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();
        buns = db.availableBuns();
        ingredients = db.availableIngredients();
    }

    //Проверяем метод формирования рецепта бургера без ингредиентов
    @Test
    public void burgerWithoutIngredients() {
        Bun bun = buns.get(0);
        burger.setBuns(bun);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals(receipt.toString(), burger.getReceipt());
    }

    //Проверяем метод формирования рецепта бургера с одним ингредиентом
    @Test
    public void burgerOneIngredient() {
        Bun bun = buns.get(0);
        Ingredient ingredient = ingredients.get(3);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals(receipt.toString(), burger.getReceipt());
    }

    //Проверяем метод формирования рецепта бургера со всеми ингредиентами
    @Test
    public void burgerAllIngredients() {
        Bun bun = buns.get(2);
        burger.setBuns(bun);
        for (Ingredient ingredient : db.availableIngredients()) {
            burger.addIngredient(ingredient);
        }
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals(receipt.toString(), burger.getReceipt());
    }
}