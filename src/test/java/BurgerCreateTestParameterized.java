import config.TestConfig;
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

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerCreateTestParameterized extends TestConfig {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private String ingredientName;

    private float ingredientPrice;

    private IngredientType type;

    private String expected;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;


    public BurgerCreateTestParameterized(IngredientType type, String ingredientName, float ingredientPrice, String expected) {
        this.type = type;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData() {
        return new Object[][]{
                { SAUCE, "hot sauce", 100f, GET_RECEIPT_PARAM_1_EXPECTED },
                { FILLING, "cutlet", 100f, GET_RECEIPT_PARAM_2_EXPECTED }
        };
    }

    @Test
    public void getReceiptParameterized() {
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(50f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(expected, burger.getReceipt());
    }
}
