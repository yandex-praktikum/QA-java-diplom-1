package praktikum.bun.test.suit;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class GetNameBunTest {
    @Test
    public void bunGetNameTest() {
        String name = "umwelt";
        Bun testBun = new Bun(name, 770);
        assertEquals(name, testBun.getName());
    }
}
