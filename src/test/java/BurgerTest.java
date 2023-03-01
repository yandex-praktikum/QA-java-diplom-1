import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    public Burger burger;
    public float test_price;
    private final float BUN_PRICE = 18.4f;
    private final float INGREDIENT_PRICE = 7.6f;

    @Mock
    Bun bun1;

    @Mock
    Ingredient ingredient1;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun1);
        burger.addIngredient(ingredient1);
        test_price = (BUN_PRICE * 2) + INGREDIENT_PRICE;
        Mockito.when(bun1.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient1.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(bun1.getName()).thenReturn("Булочка");
        Mockito.when(ingredient1.getName()).thenReturn("Жидкость");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void getPriceTest() {
        assertEquals(test_price, burger.getPrice(), 0.0001);
    }

    @Test
    public void getReceiptTest() {
        StringBuilder test_receipt = new StringBuilder(String.format("(==== %s ====)%n", bun1.getName()));
        test_receipt.append(String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(),
                ingredient1.getName()));
        test_receipt.append(String.format("(==== %s ====)%n", bun1.getName()));
        test_receipt.append(String.format("%nPrice: %f%n", test_price));
        assertEquals(test_receipt.toString(), burger.getReceipt());
    }
}
