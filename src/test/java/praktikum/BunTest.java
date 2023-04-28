package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    Bun bun;
    private String VALID_NAME_OF_BUN = "ValidName";
    private Float VALID_PRICE = 100F;
    @Test
    public void getNameValidDataPositiveResult(){
        bun = new Bun(VALID_NAME_OF_BUN, VALID_PRICE);
        Assert.assertEquals("Метод getName класса Bun, возвращает не корректное значение",VALID_NAME_OF_BUN, bun.getName());
    }
    @Test
    public void getPriceValidDataPositiveResult(){
        bun = new Bun(VALID_NAME_OF_BUN, VALID_PRICE);
        Assert.assertEquals("Метод getPrice класса Bun, возвращает не корректное значение", VALID_PRICE, bun.getPrice(), 0);
    }
}
