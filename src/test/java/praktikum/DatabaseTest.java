package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

// 70% coverage of what? The whole app or the classes listed in the task?
@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    private static final List<Bun> EXPECTED_BUNS = Arrays.asList(new Bun("black bun", 100),
            new Bun("white bun", 200),
            new Bun("red bun", 300));

    @Test
    public void testAvailableBuns() {
        Database db = new Database();

        List<Bun> result = db.availableBuns();

        for (int i = 0; i < EXPECTED_BUNS.size(); i++) {
            assertEquals("Names should be the same!", EXPECTED_BUNS.get(0).name, result.get(0).name);
            assertEquals("Prices should be the same!", EXPECTED_BUNS.get(0).price, result.get(0).price, 0);
        }
    }
}