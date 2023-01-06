package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    СontainParam containParam = new СontainParam();
    Bun bun = new Bun(containParam.getNameBun(), containParam.getPriceBun());

    @Test
    public void checkGetNameBun() {
        assertEquals("Неверное название булочки",containParam.getNameBun(), bun.getName());
    }

    @Test
    public void checkPriceBun() {
        assertEquals("Неверная цена булочки", containParam.getPriceBun(), bun.getPrice(), 0);
    }

}

