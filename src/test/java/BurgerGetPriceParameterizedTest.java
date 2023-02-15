import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class BurgerGetPriceParameterizedTest {

    private final float expected;
    private final String bunName;
    private final float bunPrice;
    private final Object[][] ingredientData;


    public BurgerGetPriceParameterizedTest(float expected, String bunName, float bunPrice, Object[][] ingredientData) {
        this.expected = expected;
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientData = ingredientData;

    }

    private Burger getBurger() {
        Bun bun = new Bun(bunName, bunPrice);
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Object[] row : ingredientData) {
            Ingredient ingredient = new Ingredient((IngredientType) row[0], (String) row[1], (Float) row[2]);
            burger.addIngredient(ingredient);
        }
        return burger;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {20F, "Bun1", 10F, new Object[][]{}},
                {40F, "Bun2", 20F, new Object[][]{}},
                {55F, "Bun2", 20F, new Object[][]{
                        {IngredientType.SAUCE, "ingredientName1", 15F},
                }},
                {60F, "Bun2", 20F, new Object[][]{
                        {IngredientType.SAUCE, "ingredientName1", 15F},
                        {IngredientType.FILLING, "ingredientName1", 5F},
                }},

        };
    }


    @Test
    public void getPriceReturnValidPrice() {
        Burger burger = getBurger();
        float actual = burger.getPrice();
        Assert.assertEquals(expected, actual, 0);

    }
}
