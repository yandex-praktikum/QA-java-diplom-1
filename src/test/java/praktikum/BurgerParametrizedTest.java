package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {

    private final int bunType;
    private final int ingredientType;
    private final int ingredientIterations;
    private final float expectedPrice;

    public BurgerParametrizedTest(int bunType, int ingredientType, int ingredientIterations, float expectedPrice) {
        this.bunType = bunType;
        this.ingredientType = ingredientType;
        this.ingredientIterations = ingredientIterations;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getPriceOptionsTest() {
        return new Object[][] {
                { 0, 0, 0, 200},        //100*2+0
                { 1, 2, 3, 1300},       //200*2+300*3
                { 2, 5, 333, 100500},   //300*2+300*333
        };
    }

    @Test
    public void getPriceTest(){
        Database database = new Database();
        Burger burger = new Burger();

        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();

        burger.setBuns(buns.get(bunType));

        for (int i = ingredientIterations; i > 0; i -= 1) {
            burger.addIngredient(ingredients.get(ingredientType));
        }

        float actualPrice = burger.getPrice();
        assertEquals("getPrice method (class Burger) counts incorrectly", expectedPrice, actualPrice, 0);

    }

}
