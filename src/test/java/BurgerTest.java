import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private String bunName = "superbun";
    private float bunPrice = 1000;
    private String sauceName = "Szechuan";
    private float ingredientPrice = 1000;

    @Mock
    Bun bun;
    Ingredient ingredient;
    IngredientType type;

    @Test
    public void checkRemoveIngredient() {
        bun = new Bun(bunName, bunPrice);
        ingredient = new Ingredient(type.SAUCE, sauceName, ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        for (int i = 0; i <= 2; i++) {
            burger.addIngredient(ingredient);
        }

        burger.removeIngredient(1);

        float actual = burger.ingredients.size();
        float expected = 2;

        assertEquals(expected, actual, 0);
    }

    @Test
    public void checkBurgerGetPrice() {
        bun = new Bun(bunName, bunPrice);
        ingredient = new Ingredient(type.SAUCE, sauceName, ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actual = burger.getPrice();
        float expected = bun.getPrice() * 2 + ingredient.getPrice();

        System.out.println("Цена за бургер: " + actual + ", " + "Цена за ингредиенты: " + expected);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void checkBurgerGetReceipt() {
        bun = new Bun(bunName, bunPrice);
        ingredient = new Ingredient(type.SAUCE, sauceName, ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        System.out.println(burger.getReceipt());

        boolean bunAssert = burger.getReceipt().contains(bunName);
        boolean sauceAssert = burger.getReceipt().contains(sauceName);
        int notNull = burger.getReceipt().length();

        assertTrue(bunAssert);
        assertTrue(sauceAssert);
        assertNotNull(notNull);
    }
}
