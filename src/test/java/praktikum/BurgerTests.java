package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BurgerTests {

    @Test
    void checkBurgerBun() {
        Burger burger = new Burger();
        Bun bun = new Bun("test", 1F);
        burger.setBuns(bun);
        Assertions.assertEquals(bun, burger.bun, "полученное значение не соответствует");
    }

    @Test
    void checkAddedIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sauce", 1F);
        burger.addIngredient(ingredient);
        Assertions.assertEquals(1, burger.ingredients.size(), "ингредиент не был добавлен");
    }

    @Test
    void checkIngredientRemoval() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "test", 1F));
        burger.removeIngredient(0);
        Assertions.assertTrue(burger.ingredients.isEmpty(), "ингредиент не был удален");
    }

    @Test
    void checkIngredientMovement() {
        Burger burger = new Burger();
        Ingredient expectedIngredient = new Ingredient(IngredientType.SAUCE, "ingredient2", 2F);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "ingredient1", 1F));
        burger.addIngredient(expectedIngredient);
        burger.moveIngredient(1, 0);
        Assertions.assertEquals(expectedIngredient, burger.ingredients.get(0), "ингредиент не был перемещен");
    }

    @Test
    void checkBurgerPrice() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("bun", 1F));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "ingredient", 2F));
        Assertions.assertEquals(4.0, burger.getPrice(), "полученная цена не соответствует");
    }

    @Test
    void checkReceipt() {
        Burger burger = new Burger();
        String bunName = "golden bun";
        String ingredientName = "ingredient";
        burger.setBuns(new Bun(bunName, 1F));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, ingredientName, 2F));
        String receipt = burger.getReceipt();
        Assertions.assertAll(
                () -> Assertions.assertTrue(receipt.contains(bunName), "рецепт не содержит имя булки"),
                () -> Assertions.assertTrue(receipt.contains(ingredientName), "рецепт не содержит ингредиент"),
                () -> Assertions.assertTrue(receipt.contains("Price: 4,00"), "указанная стоимость не соответствует")
        );
    }
}
