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

import static org.bouncycastle.util.Strings.toLowerCase;
import static org.hamcrest.core.IsNull.notNullValue;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerTest2 {
    Burger burger = new Burger();
    private final IngredientType type;
    public BurgerTest2(IngredientType type) {
        this.type = type;
    }
    @Parameterized.Parameters
    public static Object[][] setType() {
        return new Object[][] {
                {SAUCE},
                {FILLING},
        };
    }
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn((float) 2);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 1);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        String receipt = burger.getReceipt();
        System.out.println(receipt);
        Assert.assertTrue(receipt.contains("white bun"));
        Assert.assertTrue(receipt.contains(toLowerCase(type.name())));
        Assert.assertTrue(receipt.contains("dinosaur"));
    }
}