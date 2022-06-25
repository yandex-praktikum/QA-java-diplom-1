import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Test
    public void testBunGetName(){
        String name = "name";
        Bun bun = new Bun(name, 0);
        String actual = bun.getName();
        String message = "Метод getName вернул некорректное значение: " + actual + ". Ожидаемый результат: " + name;
        Assert.assertEquals(message, name, bun.getName());
    }

    @Test
    public void testBunGetPrice(){
        float price = 100.0F;
        Bun bun = new Bun("", price);
        float actual = bun.getPrice();

        String message = "Метод getPrice вернул некорректное значение: " + actual + ". Ожидаемый результат: " + price;
        Assert.assertEquals(message, price, actual, 0);
    }

}
