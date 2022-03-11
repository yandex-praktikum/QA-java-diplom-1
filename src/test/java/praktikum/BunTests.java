package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class BunTests {

    Database database;
    List<Bun> buns;

    @Before
    public void initObjects() {
        database = new Database();
        buns = database.availableBuns();
    }


    @Test
    @DisplayName("Тест на получение название булки")
    public void getBunNameTest() {
        assertEquals("white bun", buns.get(1).getName());
    }

    @Test
    @DisplayName("Тест на получение цены булки")
    public void getBunPriceTest() {
        assertEquals(200, buns.get(1).getPrice(), 0);
    }

}
