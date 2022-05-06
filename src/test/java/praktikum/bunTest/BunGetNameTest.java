package praktikum.bunTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunGetNameTest {

    private final String name;
    private final String expectedName;

    public BunGetNameTest(String name, String expectedName) {
        this.name = name;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", "black bun"},
                {"", ""},
                {"black", "black"},
                {"black big bun", "black big bun"}
        };
    }

    @Test
    public void shouldCheckGetNameReturnExactName() {
        Bun bun = new Bun(name, 100.f);
        String actualName = bun.getName();
        assertEquals("return invalid name", expectedName, actualName);
    }

}