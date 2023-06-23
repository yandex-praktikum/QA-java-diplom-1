import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {
    private Burger burger;
    private static Bun bun;
    private static Ingredient sauce;
    private static Ingredient filling;

    private float totalPrice;

    public BurgerParametrizedTest(Bun bun, Ingredient sauce, Ingredient filling, float totalPrice) {
        this.bun = bun;
        this.sauce = sauce;
        this.filling = filling;
        this.totalPrice = totalPrice;
    }

    @Before
    public void createInstance(){
        bun = new Bun("softBun", 60.0f);
        sauce = new Ingredient(IngredientType.SAUCE, "sweet-chili", 45.0f);
        filling = new Ingredient(IngredientType.FILLING, "chicken", 35.0f);
        burger = new Burger();
    }

    @Parameterized.Parameters(name = "{index} : price = {3}")
    public static Object[][] getTestData() {
        return new Object[][]{
            {bun, sauce, filling, 200.0f},
            {null, sauce, filling, 80.0f},
            {bun, null, filling, 155.0f},
            {bun, sauce, null, 165.0f},
            {bun, null, null, 120.0f},
            {null, sauce, null, 45.0f},
            {null, null, filling, 35.0f},
            {null, null, null, 0.0f}
        };
    }

    @Test
    public void getPrice(){
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expected = bun.price * 2 + sauce.price + filling.price;
        float actual = burger.getPrice();

        assertEquals(expected, actual, 0.0f);
    }

}