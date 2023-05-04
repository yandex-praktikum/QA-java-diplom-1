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
public class BurgerTest {
    Burger burger = new Burger();
    private final IngredientType type;
    public BurgerTest(IngredientType type) {
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
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertThat(burger.bun, notNullValue());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertThat(burger.ingredients, notNullValue());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int result = 0;
        int size = burger.ingredients.size();
        Assert.assertEquals(result, size);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(1, 0);
        int size = burger.ingredients.size();
        int result = 2;
        Assert.assertEquals(result, size);
    }

    @Test
    public void getPriceTest() {
        float priceResult = (float) 5;
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn((float) 2);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 1);
        float burgerPrice = burger.getPrice();
        Assert.assertEquals(priceResult, burgerPrice, 0.001);
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