package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Перебор булок: {0} {1}")
    public static Object[] getLionParameters() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988.0E0f},
                {"Краторная булка N-200i", 1255.0E0f},
        };
    }

    @Test
    public void testGetName(){
        Bun bun = new Bun(name, price);
        MatcherAssert.assertThat("Я не твоя светящаяся булочка", name, is (bun.getName()));
    }

    @Test
    public void testGetPrice(){
        Bun bun = new Bun(name, price);
        MatcherAssert.assertThat("Я не твоя драгоценная булочка", price, is (bun.getPrice()));
    }

}