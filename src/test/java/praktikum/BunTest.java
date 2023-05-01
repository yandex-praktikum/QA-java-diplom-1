package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    Bun bun = new Bun("Тестовая булочка", 100);

    @Test
    public void bunGetNameTest(){
        Assert.assertEquals("Имя булочки не соответствет ожидаемому результату" ,
                bun.getName(), "Тестовая булочка");
    }

    @Test
    public void bunGetPriceTest(){
        Assert.assertEquals("Цена булочки не соответствует ожидаемому результату",
                bun.getPrice(), 100.00, 0);
    }
}