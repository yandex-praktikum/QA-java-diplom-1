import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {


    private final String bunName;
    private final int bunPrice;

    public BunTest(String bunName, int bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    /*
    Мы проверяем только класс Bun. У него нет никаких проверок, кроме того, что нужно вывести bunName или bunPrice.
    Null максимум я могу проверить. Граничные значения появляются, если мы подключаем сюда Database, но в классе Bun
    они никак не взаимодействуют
     */

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {null, 100},
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(bunName, bunPrice);
        if(bunName != null){
            assertEquals("Неверное название булки", bunName, bun.getName());
        } else {
            assertNull(bun.getName());
        }
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Неверная стоимость булки", bunPrice, bun.getPrice(), 0);
    }
}