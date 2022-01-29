import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class GetBunNameTest {
    @Test
    public void canGetBunName(){
        String name = RandomString.make(10);
        Bun bun = new Bun(name, 123);
        assertEquals(name, bun.getName());
    }
}