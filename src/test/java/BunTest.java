import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"black bun", 0},
                {"black bun", -1000},
                {"      ", 400},
                {"", 0},
                {null, -0},
                {"Очень очень очень очень очень очень очень очень очень очень очень очень очень длиннное название булочки", 1000},
                {"!@#$%^&*()", 100},
                {"black bun", 0.10f},
                {"black bun", 224*10^104},
        };
    }

    @Test
    public void returnsCorrectName() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Что-то не так с булкой", name, bun.getName());
        System.out.println("Название булочки: " + bun.getName() + ".");
    }

    @Test
    public void returnsCorrectPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Что-то не так с ценой", price, bun.getPrice(), 0.0f);
        System.out.println("Цена: " + bun.getPrice() + " рублей.");
    }
}
