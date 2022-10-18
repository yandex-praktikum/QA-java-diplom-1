import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class TestForBun {
    private static final String BUN_NAME = "Флюоресцентная булка R2-D3";
    private static final float BUN_PRICE = 988;
    Bun bun = new Bun("Флюоресцентная булка R2-D3",988);

    @Test
    public void checkTheName(){
        assertEquals(BUN_NAME,bun.getName());
    }
    @Test
    public void checkThePrice(){
        assertEquals(BUN_PRICE, bun.getPrice(),0);
    }
}
