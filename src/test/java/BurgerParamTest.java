import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.*;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerParamTest {
    private final IngredientType type;
    private final String ingredientName;
    private final float priceIngredient;
    Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    public BurgerParamTest(IngredientType type, String ingredientName, float priceIngredient) {
        this.type = type;
        this.ingredientName = ingredientName;
        this.priceIngredient = priceIngredient;
    }

    @Parameterized.Parameters(name = "Тестовые данные:{0},{1}")
    public static Object[][] nameIngredient() {
        return new Object[][]{
                {SAUCE, "sour cream", 200f},
                {FILLING, "dinosaur", 200f}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getReceiptParameterized() {
        burger = new Burger();
        burger.bun = bun;
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(priceIngredient);
        Mockito.when(ingredient.getType()).thenReturn(type);
        String result = burger.getReceipt();
        Assert.assertEquals("(==== red bun ====)\r\n" +
                "(==== red bun ====)\r\n" +
                "\r\n" +
                "Price: 0,000000\r\n", result);
    }
}