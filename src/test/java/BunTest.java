import org.junit.Test;
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
    public void TestGetSymbolsName() {
        Bun bun = new Bun("Спцсимволы№%:,.?@#$%^&*", price);
        assert bun.getName().equals("Спцсимволы№%:,.?@#$%^&*");
    }

    @Test
    public void TestGetEmptyName() {
        Bun bun = new Bun("", price);
        assert bun.getName().equals("");

    }

    @Test
    public void TestGetNullName() {
        Bun bun = new Bun(null, price);
        assert bun.getName() == null;

    }

    @Test
    public void TestGetPrice() {
        Bun bun = new Bun(name, price);
        assert bun.getPrice() == price;
    }
    @Test
    public void TestGetNegativePrice() {
        Bun bun = new Bun(name, -7);
        assert bun.getPrice() == -7;
    }
    @Test
    public void TestGetZeroPrice() {
        Bun bun = new Bun(name, 0);
        assert bun.getPrice() == 0;
    }

    @Test
    public void TestGetDoublePrice() {
        Bun bun = new Bun(name, (float) 7.6511);
        assert bun.getPrice() ==(float) 7.6511;
    }
}