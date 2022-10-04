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
    }

    @Test
    public void addOneIngredient() {
        ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337F);
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void addTwoIngredients() {
        ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337F);
        burger.addIngredient(ingredient);
        ingredient = new Ingredient(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400F);
        burger.addIngredient(ingredient);

        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337F);
        burger.addIngredient(ingredient);
        ingredient = new Ingredient(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400F);
        burger.addIngredient(ingredient);

        assertEquals("Мясо бессмертных моллюсков Protostomia", burger.ingredients.get(0).getName());

        burger.moveIngredient(0, 1);

        assertEquals("Мясо бессмертных моллюсков Protostomia", burger.ingredients.get(1).getName());
    }

    @Test
    public void removeIngredient() {
        ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337F);
        burger.addIngredient(ingredient);
        ingredient = new Ingredient(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400F);
        burger.addIngredient(ingredient);

        assertEquals(2, burger.ingredients.size());

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertEquals("Мини-салат Экзо-Плантаго", burger.ingredients.get(0).getName());
    }

    @Test
    public void getPrice() {
        ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337F);
        burger.addIngredient(ingredient);
        ingredient = new Ingredient(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400F);
        burger.addIngredient(ingredient);

        assertEquals(8247, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337F);
        burger.addIngredient(ingredient);
        ingredient = new Ingredient(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400F);
        burger.addIngredient(ingredient);

        System.out.println(burger.getReceipt());
    }
}
