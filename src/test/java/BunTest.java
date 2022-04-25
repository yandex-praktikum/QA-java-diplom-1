import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        String startName = "CosmoBun";
        float startPrice = 15.25f;
        bun = new Bun(startName, startPrice);
    }

    //исхожу из того, что поля name и price класса Bun сделаны публичными сознательно, в соответсвии с требованиями
    @Test
    public void checkChangePriceOnValid() {
        float expectedPrice = 10.50f;
        bun.price = expectedPrice;
        float actualPrice = bun.getPrice();
        assertEquals("Значение поля Price НЕ верное", expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkChangeNameOnValid() {
        String expectedName = "New burger name";
        bun.name = expectedName;
        String actualName = bun.getName();
        assertEquals("Значение поля Price НЕ верное", expectedName, actualName);
    }

}