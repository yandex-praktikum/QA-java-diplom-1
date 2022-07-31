package practikumtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {
    private Bun bun;
    String name = "Флюоресцентная булка R2-D3";
    float price = 988.55f;

    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    //Проверяем что метод возвращает имя созданного бургера верно
    @Test
    public void getName() {
        Assert.assertEquals(name, bun.getName());
    }

    //Проверяем что метод возвращает цену созданного бургера с точностью до 0
    @Test
    public void getPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}