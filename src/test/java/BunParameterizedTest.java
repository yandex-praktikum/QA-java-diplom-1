import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public BunParameterizedTest(String name, float price, String expectedName, float expectedPrice){
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[] getNameBun() {
        return new Object[][]{
                {"Black bun", 10f, "Black bun", 10f},
                {"", 1/12f, "", 1/12f},
                {"White bun with white sesame, seeds, black sesame, cinnamon and yeast - free", 1.34344232f, "White bun with white sesame, seeds, black sesame, cinnamon and yeast - free", 1.34344232f},
                {"@#!%&", 0f, "@#!%&", 0f},
                {"Red bun!&1@#", -5f, "Red bun!&1@#", -5f}
        };
    }

    @Test // проверка,что при назначении вернулось корректное название булочки
    public void CorrectNameBunTest(){
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals(expectedName, actual);
    }

    @Test // проверка,что при назначении вернулась корректная цена булочки
    public void CorrectPriceBunTest(){
        Bun bun = new Bun(name, price);
        Float actual2 = bun.getPrice();
        assertEquals(expectedPrice, actual2,0);
    }
}
