import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    public String name;
    public float price;

    public void BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }
        @Test
        public void getNameTest() {
            Bun bun = new Bun(name, price);
            String name = bun.getName();
            Assert.assertEquals(name, "black bun");
        }
;
        @Test
        public void getPriceTest() {
            Bun bun = new Bun("black bun", 100);
            float price = bun.getPrice();
            Assert.assertEquals(price, 100, 0.0001);
        }
    }

