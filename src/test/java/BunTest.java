import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import praktikum.Bun;
import org.apache.commons.lang3.RandomStringUtils;

import static org.junit.Assert.*;

public class BunTest {
    String randomName = RandomStringUtils.randomAlphabetic(10);
    float randomPrice = RandomUtils.nextFloat();

    @Test
    @DisplayName("Можно назначить имя булочке")
    public void testGetName() {
        Bun bun = new Bun(randomName, randomPrice);
        assertEquals(randomName, bun.getName());
    }
    @Test
    @DisplayName("Можно назначить цену булочке")
    public void testGetPrice() {
        Bun bun = new Bun(randomName, randomPrice);
        assertEquals(randomPrice, bun.getPrice(), 0.01);
    }
}
