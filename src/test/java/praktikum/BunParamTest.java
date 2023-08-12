package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String name;
    private final float price;
    private Bun bun;

    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"red bun", 10000f},
                {"BUN RED_WHITE", -100f},
                {"Test", -22f},
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255},
                {null, null},
                {"", 500}

        };
    }

    @Test
    public  void bunTestName() {
  //      Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        System.out.println(bun.getName());
    }

        @Test
        public  void bunTestPrice() {
       //     Bun bun = new Bun(name, price);
            assertEquals(price, bun.getPrice(), 0);
            System.out.println(bun.getPrice());
    }

}