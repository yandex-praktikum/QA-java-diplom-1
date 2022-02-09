import org.junit.Test;
import praktikum.Bun;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class BunTests {
    String name = "Булка белая";
    float price = 25.05f;

    @Test
    public void getNameTest(){
        Bun bun = new Bun(name, price);
        String bunName = bun.getName();
        assertThat("Метод getName возвращает неверное значение поля name",bunName.equals(name));
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun(name, price);
        float bunPrice = bun.getPrice();
        assertThat("Метод getPrice вовзращает неверное значение поля price",bunPrice,equalTo(price));
    }
}
