import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedBunTest {
    private final String name;
    private final float price;
        public ParametrizedBunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},

        };
    }
        @Test
        public void getBunNameTest() {
            Bun bun = new Bun(name,price);
            String actualBunName = bun.getName();
            assertEquals(name, actualBunName);
            System.out.println ("Bun name is: " + bun.getName());
        }
    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(name,price);
        Float actualBunPrice = bun.getPrice();
        assertEquals(price, (double) actualBunPrice,0);
        System.out.println ("Price of " +  bun.getName() + " is: " + bun.getPrice());
    }
    }