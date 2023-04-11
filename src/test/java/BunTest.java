import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {"Briosh", 2},
                {"Bread", 10},
        };
    }
    @Test
    public void bunGetNameReturnsName(){
        Bun bun = new Bun(name, price);
        String expectedName = name;
        float expectedPrice = price;

        assertEquals("Имя булки не совпадает!", expectedName, bun.getName());
        assertEquals("Цена булки не совпадает!", expectedPrice, bun.getPrice(), 0);
    }
}
