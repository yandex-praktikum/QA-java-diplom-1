import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;


    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunParameters() {
        return new Object[][] {
                {"Булочка с маком", 30},
                {"Крендель", 0},
                {"Расстегай", 1000000},
                {null, -1},
        };
    }

    @Test // Создаем новую булочку и проверяем корректность нааименования
    public void getNameAndCheckCorrectName() {
        Bun bun = new Bun(name, price);
        assertEquals("Наименование булочки некорректно!", name, bun.getName());
    }

    @Test // Создаем новую булочку и проверяем корректность цены
    public void getPriceAndCheckCorrectPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Введено недопустимое значение цены!", price, bun.getPrice(), 0);
    }
}
