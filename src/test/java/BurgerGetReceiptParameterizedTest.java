import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParameterizedTest {
    private final String expected;
    private final String bunName;
    private final float bunPrice;
    private final Object[][] ingredientData;


    public BurgerGetReceiptParameterizedTest(String expected, String bunName, float bunPrice, Object[][] ingredientData) {
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
                {"(==== Bun1 ====)\n" +
                        "(==== Bun1 ====)\n" +
                        "\n" +
                        "Price: 20,000000\n", "Bun1", 10F, new Object[][]{}},
                {"(==== Bun2 ====)\n" +
                        "= sauce ingredientName1 =\n" +
                        "(==== Bun2 ====)\n" +
                        "\n" +
                        "Price: 55,000000\n", "Bun2", 20F, new Object[][]{
                        {IngredientType.SAUCE, "ingredientName1", 15F},
                }},


        };
    }


    @Test
    public void getReceiptReturnValidReceipt() {
        Burger burger = getBurger();
        String actual = burger.getReceipt();
        Assert.assertEquals(expected, actual);
    }
}

