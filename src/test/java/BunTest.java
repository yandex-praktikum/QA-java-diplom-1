import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)

public class BunTest {

    public String name;
    public float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }



    @Parameterized.Parameters

    public static Object[][] checkDoesBunTest() {
        return new Object [][] {
                {"Краторная булка N-200i", 1255},
                {"Флюоресцентная булка R2-D3", 988},

        };
    }

    @Test
    public void checkName() {
        Bun bun = new Bun(name, price);
        assertEquals (name, bun.getName());
    }

    @Test
    public void checkPrice() {
        Bun bun = new Bun(name, price);
        assertEquals (price, bun.getPrice(),0);
    }




}
