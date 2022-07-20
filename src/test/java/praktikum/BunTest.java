package praktikum;
import org.junit.Assert;
import org.junit.Test;


public class BunTest {
//Проверяем метод получения названия булочки
    @Test
    public void getName() {
        Bun bun =new Bun("black bun", 100);
        Assert.assertEquals("black bun", bun.getName());
    }
    //Проверяем метод получения цены булочки
    @Test
    public void getPrice() {
        Bun bun = new Bun("white bun", 200);
        Assert.assertEquals(200, bun.getPrice(), 0.0f);
    }
}