import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestForBunUsingDatabase {
    public static final String BLACK_BUN = "black bun";
    public static final String WHITE_BUN = "white bun";
    public static final String RED_BUN = "red bun";
    public static final float BLACK_BUN_PRICE = 100;
    public static final float WHITE_BUN_PRICE = 200;
    public static final float RED_BUN_PRICE = 300;
    Database database = new Database();
    @Test
    public void checkTheName() {
        List<Bun> buns = database.availableBuns();
        assertEquals(BLACK_BUN, buns.get(0).name);
        assertEquals(WHITE_BUN, buns.get(1).name);
        assertEquals(RED_BUN, buns.get(2).name);
    }
    @Test
    public void checkThePrice() {
        List<Bun> buns = database.availableBuns();
        assertEquals(BLACK_BUN_PRICE, buns.get(0).price,0);
        assertEquals(WHITE_BUN_PRICE, buns.get(1).price,0);
        assertEquals(RED_BUN_PRICE, buns.get(2).price,0);
    }
}
