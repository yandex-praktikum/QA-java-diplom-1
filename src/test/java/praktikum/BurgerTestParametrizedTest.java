package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerTestParametrizedTest {

    private final float price;
    Burger burger;
    private static int ingredientIndex;
    Database database;
    private static int bunIndex;

    @Before
    public void initObjects() {
        burger = new Burger();
        database = new Database();
    }

    public BurgerTestParametrizedTest(int bunIndex, int ingredientIndex, float price) {
        this.bunIndex = bunIndex;
        this.ingredientIndex = ingredientIndex;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getDataForBurger() {
        return new Object[][]{
                {1, 1, 600},
                {0, 0, 300},
                {2, 3, 700},
        };
    }

    @Test
    public void BurgerTestParametrized() {
        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(bunIndex));
        burger.addIngredient(ingredients.get(ingredientIndex));
        Assert.assertEquals(price, burger.getPrice(), 0);
    }
}
