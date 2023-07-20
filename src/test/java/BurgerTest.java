import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final String bunName = "Corn";
    private final String sauceName = "Tobasko";
    private final String fillingName = "Chicken";
    private final float bunPrice = 1.5f;
    private final float saucePrice = 0.3f;
    private final float fillingPrice = 2.99f;
    private final float burgerPrice = (bunPrice * 2) + saucePrice + fillingPrice;
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;

    @Before
    public void start() {
        MockitoAnnotations.initMocks(this);
        when(bun.getName()).thenReturn(bunName);
        when(bun.getPrice()).thenReturn(bunPrice);
        when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        when(sauce.getName()).thenReturn(sauceName);
        when(sauce.getPrice()).thenReturn(saucePrice);
        when(filling.getType()).thenReturn(IngredientType.FILLING);
        when(filling.getName()).thenReturn(fillingName);
        when(filling.getPrice()).thenReturn(fillingPrice);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Test
    public void getPriceTest() {
        assertEquals(burgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void getRecipeTest() {
        String receiptText = String.format(
                "(==== %s ====)%n" +
                "= sauce %s =%n" +
                "= filling %s =%n" +
                "(==== %s ====)%n" +
                "%nPrice: %f%n",bunName,sauceName,fillingName,bunName, burgerPrice);

        assertEquals(receiptText, burger.getReceipt());
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String receiptText = String.format(
                "(==== %s ====)%n" +
                "= sauce %s =%n" +
                "= filling %s =%n" +
                "= sauce %s =%n" +
                "= filling %s =%n" +
                "(==== %s ====)%n" +
                "%n" +
                "Price: %f%n",bunName,sauceName,fillingName,sauceName,fillingName,bunName, burgerPrice + saucePrice + fillingPrice);

        assertEquals(receiptText, burger.getReceipt());
    }
    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(0, 1);

        String receiptText = String.format(
                "(==== %s ====)%n" +
                "= filling %s =%n" +
                "= sauce %s =%n" +
                "(==== %s ====)%n" +
                "%n" +
                "Price: %f%n",bunName,fillingName,sauceName,bunName, burgerPrice);

        assertEquals(receiptText, burger.getReceipt());
    }
    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(1);
        burger.removeIngredient(0);

        String receiptText = String.format(
                "(==== %s ====)%n" +
                "(==== %s ====)%n" +
                "%n" +
                "Price: %f%n",bunName,bunName, burgerPrice - saucePrice - fillingPrice);

        assertEquals(receiptText, burger.getReceipt());
    }
}