import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest extends BaseTest {
    Burger burger;
    private final String BUN_NAME = "Краторная булка N-200i";
    private final float BUN_PRICE = 1255F;

    @Before
    public void init() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
        burger = new Burger();
        burger.setBuns(bun);

        ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337F);
        secondIngredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90F);
        thirdIngredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142F);
    }

    @Test
    public void addOneIngredient() {
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void addThreeIngredients() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        assertEquals(ingredient.getName(), burger.ingredients.get(0).getName());

        burger.moveIngredient(0, 1);

        assertEquals(ingredient.getName(), burger.ingredients.get(1).getName());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        assertEquals(3, burger.ingredients.size());

        burger.removeIngredient(0);

        assertEquals(2, burger.ingredients.size());
        assertEquals(secondIngredient.getName(), burger.ingredients.get(0).getName());
    }

    @Test
    public void getPrice() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        float expectedPrice = BUN_PRICE * 2 + ingredient.getPrice() + secondIngredient.getPrice() + thirdIngredient.getPrice();

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {

        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        String result = "(==== " + BUN_NAME + " ====)\r\n" +
                "= filling " + burger.ingredients.get(0).getName() + " =\r\n" +
                "= sauce " + burger.ingredients.get(1).getName() + " =\r\n" +
                "= filling " + burger.ingredients.get(2).getName() + " =\r\n" +
                "(==== " + BUN_NAME + " ====)\r\n" +
                "\r\n" +
                "Price: " + String.format("%.6f", burger.getPrice()) + "\r\n";

        assertEquals(result, burger.getReceipt());
    }
}
