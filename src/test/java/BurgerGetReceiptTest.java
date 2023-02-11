import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerGetReceiptTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public BurgerGetReceiptTest(IngredientType expectedType, String expectedName, float expectedPrice){
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters
    public static Object[][] setupData() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    @Test
    public void getReceiptPositiveTest(){
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Burger burger = Mockito.spy(Burger.class);
        burger.setBuns(new Bun(expectedName, expectedPrice));
        burger.addIngredient(new Ingredient(expectedType, expectedName, expectedPrice));
        burger.addIngredient(new Ingredient(expectedType, expectedName, expectedPrice));
        Mockito.doReturn(expectedName).when(bun).getName();
        Mockito.doReturn(expectedName).when(ingredient).getName();
        Mockito.doReturn(expectedType).when(ingredient).getType();
        Mockito.doReturn(expectedPrice * 4).when(burger).getPrice();
        String actual = burger.getReceipt();
        String expected = "(==== " + expectedName + " ====)\r\n"
                + "= " + expectedType.toString().toLowerCase() + " " + expectedName + " =\r\n"
                + "= " + expectedType.toString().toLowerCase() + " " + expectedName + " =\r\n"
                + "(==== " + expectedName + " ====)\r\n"
                + String.format("\r\nPrice: %f\r\n", expectedPrice * 4);
        assertEquals(expected, actual);
    }
}