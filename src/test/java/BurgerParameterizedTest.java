import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    Database database = new Database();
    List<Bun> buns = database.availableBuns();
    List<Ingredient> ingredients = database.availableIngredients();


    private final int bunIndex;
    private final int sauceIndex;
    private final int fillingIndex;
    private final String bunColor;
    private final String sauceType;
    private final String fillingType;

    public BurgerParameterizedTest(int bunIndex, int sauceIndex, int fillingIndex,
                                   String bunColor, String sauceType, String fillingType) {
        this.bunIndex = bunIndex;
        this.sauceIndex = sauceIndex;
        this.fillingIndex = fillingIndex;
        this.bunColor = bunColor;
        this.sauceType = sauceType;
        this.fillingType = fillingType;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][]{
                {0, 0, 3, "black", "hot sauce", "cutlet"},
                {1, 1, 4, "white", "sour cream", "dinosaur"},
                {2, 2, 5, "red", "chili sauce", "sausage"}
        };
    }

    @Test
    public void getBurgerRecipe() {
        Burger burger = new Burger();
        burger.setBuns(buns.get(bunIndex));
        burger.addIngredient(ingredients.get(sauceIndex));
        burger.addIngredient(ingredients.get(fillingIndex));
        String burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== " + bunColor + " bun ====)\n= sauce " +
                sauceType + " =\n= filling " + fillingType + " =\n(==== " +
                bunColor + " bun ====)\n\nPrice: " + burgerPrice + "\n", burger.getReceipt());
    }
}