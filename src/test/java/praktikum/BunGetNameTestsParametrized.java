package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunGetNameTestsParametrized {
    Bun bun;
    private String name;
    private String expectedName;

    public BunGetNameTestsParametrized(String name, String expectedName) {
        this.name = name;
        this.expectedName = expectedName;

    }

    @Parameterized.Parameters(name = "name : {0}, expectedName : {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", "black bun"},
                {"white bun", "white bun"},
                {"red bun", "red bun"},
                {"RED", "RED"},
                {".!)(*&^%$#", ".!)(*&^%$#"},
        };
    }


    @Before
    public void setUp() {
        bun = new Bun(name, 20.0F);
    }

    @Test
    public void testBun() {
        assertEquals(expectedName, bun.getName());
    }

}
