import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BunDataBaseTest {
    private final String name = "Cosmo bun";
    private final int price = 10;

    Database database;
    List<Bun> buns ;

    @Before
    public void initObjects(){
        database = new Database();
        buns = database.availableBuns();
    }
}
