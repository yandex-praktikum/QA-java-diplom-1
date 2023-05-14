import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    static Bun bun = new Bun("black bun", 100);

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {bun.getName(), bun.getPrice()},
        };
    }
        @Test
        public void getNameTest(){
            String expectedName = "black bun";
            assertEquals(expectedName, name);
        }
        @Test
        public void getPriceTest() {
            float expectedPrice = 100F;
            assertEquals(expectedPrice, price, 0F);
        }
    }

