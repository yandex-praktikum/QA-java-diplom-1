import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BumParametersTest {

    private final int index;
    private final String expectedName;
    private final float expectedPrice;

    public BumParametersTest(int index, String expectedName, float expectedPrice) {
        this.index = index;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[] getString() {
        return new Object[][] {
                { 0, "black bun", 100},
                { 1, "white bun", 200},
                { 2, "red bun", 300},
        };
    }

    @Test
    public void getNameAndPrice(){
        /*
        Получим данные по наименованию и цене из БД и сравним с шаблоном
         */
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        Bun bun = new Bun(buns.get(index).name, buns.get(index).price);
        String name = bun.getName();
        float price = bun.getPrice();
        assertEquals(name, expectedName);
        assertEquals(price, expectedPrice, 0);

    }

}
