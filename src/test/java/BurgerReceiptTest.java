import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgerReceiptTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private final String expectedResult;
    private final String ingredientType;
    private final String bunName;
    private final String ingredientName;
    private final float price;

    public BurgerReceiptTest(String expectedResult, String ingredientType, String bunName, String ingredientName, float price) {
        this.expectedResult = expectedResult;
        this.ingredientType = ingredientType;
        this.bunName = bunName;
        this.ingredientName = ingredientName;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getInputs() {
        return new Object[][]{
                {String.format("(==== Булка ====)%n" + "= sauce Кетчунез =%n" + "(==== Булка ====)%n" + "%n" + "Price: 50,000000%n"),
                        "SAUCE", "Булка", "Кетчунез", 50f},
                {String.format("(==== СуперБулка ====)%n" + "= filling Ранч =%n" + "(==== СуперБулка ====)%n" + "%n" + "Price: 70,000000%n"),
                        "FILLING", "СуперБулка", "Ранч", 70f},
        };

    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getReceiptReturnsValidValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf(ingredientType));
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(burger.getPrice()).thenReturn(price);

        String actualResult = burger.getReceipt();

        Assert.assertEquals("Неправильный рецепт", expectedResult, actualResult);
    }
}
