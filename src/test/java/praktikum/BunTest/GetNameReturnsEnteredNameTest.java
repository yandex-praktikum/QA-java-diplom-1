package praktikum.BunTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class GetNameReturnsEnteredNameTest {
    private final String name = RandomStringUtils.randomAlphabetic(5);
    private final Float price = Float.valueOf(RandomStringUtils.randomNumeric(5));


    @Test
    public void testGetNameReturnsEnteredName() {
        Bun bun = new Bun(name, price);
        String returnValue = bun.getName();
        assertEquals(name, returnValue);
    }

}
