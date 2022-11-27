import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTests {
    private Bun bun;

    @Before
    public void init() {
        bun = new Bun("Флюоресцентная булка R2-D3", 86.50f);
    }

    @Test
    public void getNameShouldReturnsBunName(){
        Assert.assertEquals("Ошибка! Неверная модель булочки для бургера.", "Флюоресцентная булка R2-D3" , bun.getName());
    }

    @Test
    public void getPriceShouldReturnsBunPrice(){
        Assert.assertEquals("Ошибка! Неверная цена модели булочки для бургера.", 86.50f, bun.getPrice(), 0);
    }
}
