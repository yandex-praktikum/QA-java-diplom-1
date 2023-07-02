package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    //Проверка, что метод getName() возвращает введенное значение
    @Test
    public void checkGetName() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        String actualGetName = bun.getName();
        String expectedGetName = "Флюоресцентная булка R2-D3";
        Assert.assertEquals(expectedGetName, actualGetName);

    }

    //Проверка, что метод getPrice() возвращает введенное значение
    @Test
    public void checkGetPrice() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        float actualGetPrice = bun.getPrice();
        float expectedGetPrice = 988;
        Assert.assertEquals(expectedGetPrice, actualGetPrice, 0);
    }
}
