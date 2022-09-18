package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    // Делаем параметризацию данных на случай использования констант в методах getName() и getPrice()
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Флюоресцентная булка R2-D3", 988 },
                { "Краторная булка N-200i", 1255 },
        };
    }

    @Test
    public void getNameStringSameStringValue() {
        Bun bun = new Bun(name, price);
        assertEquals("Название булки не должно изменяться в процессе готовки", name, bun.getName());
    }

    @Test
    public void getPriceFloatSameFloatValue() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена булки не должна изменяться в процессе готовки", price, bun.getPrice(), 0.0f);
    }
}