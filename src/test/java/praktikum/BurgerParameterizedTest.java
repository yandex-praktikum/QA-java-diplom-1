package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private final float bunPrice;
    private final float ingredientPrice;
    private final Float expectedSum;

    public BurgerParameterizedTest(float bunPrice, float ingredientPrice, float expectedSum) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedSum = expectedSum;
    }

    @Parameterized.Parameters
    public static Object[][] getPriceData() {
        return new Object[][]{
                {150f, 100f, 400f},
                {0, 100f, 100f},
                {150f, 0, 300f},
                {0, 0, 0},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Bun bun;

    @Test
    public void getPriceReturnsCorrectPriceValue() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        float actual = burger.getPrice();
        Assert.assertEquals("Некорректная цена бургера", expectedSum, actual, 0);
    }

    @Test
    public void getReceiptReturnsCorrectStringValue() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        String receipt = burger.getReceipt();
        String[] actual = receipt.split("[\\r\\n]+");
        Assert.assertEquals("В чеке неверная первая строка", "(==== red bun ====)", actual[0]);
        Assert.assertEquals("В чеке неверная вторая строка", "= sauce hot sauce =", actual[1]);
        Assert.assertEquals("В чеке неверная третья строка", "(==== red bun ====)", actual[2]);
        Assert.assertTrue("Чек не содержит корректную цену", actual[3].contains("Price: " + expectedSum.toString().replace(".", ",")));
    }
}
