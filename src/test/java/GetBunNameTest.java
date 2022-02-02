import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class GetBunNameTest {
    @Test
    public void canGetBunName(){
        String name = RandomString.make(10);
        Bun bun = new Bun(name, 123);
        Assert.assertEquals(name, bun.getName());
    }
}