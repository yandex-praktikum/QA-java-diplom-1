import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;

public class BunTest {

    final String name = "Test name";
    final float price = (float) 1.1;

    @Test
    public void TestGetName() {
        Bun bun = new Bun(name, price);
        assert bun.getName().equals(name);
    }

    @Test
    public void TestGetPrice() {
        Bun bun = new Bun(name, price);
        assert bun.getPrice() == price;
    }

    @Test
    public void TestGetNullName() {
        Bun bun = new Bun(null, price);
        assert bun.getName() == null;
    }

}