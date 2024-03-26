import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class BunTest {

    public String name;
    public float price;


    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters

    public static Object[][] checkDoesBunTest() {
        Database database = new Database();
        return new Object [][] {

                {database.availableBuns().get(0).getName(), database.availableBuns().get(0).getPrice()},
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Test
    public void checkName() {
        Bun bun = new Bun(name, price);
        assertEquals (name, bun.getName());
    }

    @Test
    public void checkPrice() {
        Bun bun = new Bun(name, price);
        assertEquals (price, bun.getPrice(),0);
    }
}
