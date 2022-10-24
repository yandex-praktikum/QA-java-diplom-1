import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String name = "Флюоресцентная булка R2-D3";
    private final float price = 988;

    Bun bun = new Bun(name, price);

    @Test
    public void bunGetRightName(){
        assertEquals(name, bun.getName());
    }

    @Test
    public void bunGetRightPrice(){
        float delta = 0;
        assertEquals(price, bun.getPrice(), delta);
    }
}
