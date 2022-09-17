import jdk.jfr.Description;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bun;

    @Test
    @DisplayName("Constructor test")
    @Description("Тестирование конструктора")
    public void constructorTest() {
        String name = "black bun";
        bun = new Bun(name, 100);
        assertEquals(name, bun.getName());
    }

    @Test
    @DisplayName("GetName test")
    @Description("Тестирование геттера, возвращающего имя")
    public void getNameTest() {
    bun = new Bun("black bun", 100);
    String expectedName = "black bun";
    String actualName = bun.getName();
    assertEquals(expectedName, actualName);
    }

    @Test
    @DisplayName("GetPrice test")
    @Description("Тестирование геттера, возвращающего цену")
    public void getPriceTest() {
    bun = new Bun("black bun", 100);
    float expectedPrice = 100;
    float actualPrice = bun.getPrice();
    assertEquals(expectedPrice, actualPrice, 0.1);
    }
}
