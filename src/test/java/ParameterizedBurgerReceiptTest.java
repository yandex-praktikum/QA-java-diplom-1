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
public class ParameterizedBurgerReceiptTest {
    private final String bunName;
    private final IngredientType type;
    private final String fillingName;
    private final float price;
    Bun bun = Mockito.mock(Bun.class);
    Ingredient ingredient = Mockito.mock(Ingredient.class);


    public ParameterizedBurgerReceiptTest(String bunName, IngredientType type, String fillingName, float price) {
        this.bunName = bunName;
        this.type = type;
        this.fillingName = fillingName;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBurger() {
        return new Object[][]{
                {"black bun", IngredientType.SAUCE, "hot sauce", 300},
                {"white bun", IngredientType.FILLING, "cutlet", 500},
                {"red bun", IngredientType.FILLING, "sausage", 900},
        };
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        Burger spyBurger = Mockito.spy(burger);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getName()).thenReturn(fillingName);
        Mockito.when(burger.getPrice()).thenReturn(price);
        String actualReceipt = burger.getReceipt();
        String formatBunName = String.format("(==== %s ====)%n", bunName);
        String formatFillingName = String.format("= %s %s =%n", type.toString().toLowerCase(), fillingName);
        String formatPrice = String.format("%nPrice: %f%n", price);
        String expectedReceipt = formatBunName + formatFillingName + formatBunName + formatPrice;
        assertEquals(expectedReceipt, actualReceipt);
    }
}
