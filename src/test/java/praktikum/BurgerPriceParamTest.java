package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.Сonstants.*;

@RunWith(Parameterized.class)
public class BurgerPriceParamTest {
    private Ingredient sauce;
    private Ingredient filling;
    private Burger burger;
    private String name;
    private float price;

    public BurgerPriceParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void createNewInstance() {
        sauce = new Ingredient(IngredientType.SAUCE, NAME_HOT_SAUCE, PRICE_100_0f);
        filling = new Ingredient(IngredientType.FILLING, NAME_FILLING_CUTLET, PRICE_100_0f);
        burger = new Burger();
    }

    @Parameterized.Parameters(name = "Название булочки - {0}, Цена булочки - {1}")
    public static Object[][] testDateGen() {
        return new Object[][]{
                {NAME_BLACK_BUN, PRICE_100_0f},
                {NAME_WHITE_BUN, PRICE_200_0f},
                {NAME_RED_BUN, PRICE_300_0f}
        };
    }

    @Test
    public void setBuns(){
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float expected = bun.price * 2 + sauce.price + filling.price;
        float actual = burger.getPrice();
        assertEquals("Проверяем итоговую сумму бургера", expected, actual, DELTA_0);
    }
}
