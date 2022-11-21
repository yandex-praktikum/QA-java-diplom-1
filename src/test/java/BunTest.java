import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String name = "Cosmo bun";
    private final int price = 10;

    Database database;
    List<Bun> buns ;

    @Before
    public void initObjects(){
        database = new Database();
        buns = database.availableBuns();
    }


    @Test // проверка,что при назначении вернулось корректное название булочки
    public void getBunNameTest(){
        Bun bun = new Bun(name, price);
        String actualResult = bun.getName();
        assertEquals(name, actualResult);
    }

    @Test // проверка,что при назначении вернулась корректная цена булочки
    public void getBunPriceTest(){
        Bun bun = new Bun(name,price);
        int actualResult = (int) bun.getPrice();
        assertEquals( price, actualResult);
    }


}
