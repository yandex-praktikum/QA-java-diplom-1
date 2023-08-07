package praktikum.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunGetNameParameterizedTest {
    private final String actualName;
    private final String expectedName;

    public BunGetNameParameterizedTest(String actualName, String expectedName) {
        this.actualName = actualName;
        this.expectedName = expectedName;
    }
    @Parameterized.Parameters (name = "Bun's name. Test data: {0} {1}")
    public static Object[][] getTestData() {
        Bun bun1 = new Bun("black bun", 100);
        Bun bun2 = new Bun("white bun", 200);

        return new Object[][] {

                { bun1.getName(), "black bun"},
                { bun2.getName(), "white bun"},
                };
    }
    @Test
    public void checkDataBaseReturn() {
        Assert.assertEquals("The getName method returns bun's name from DB",expectedName, actualName);
    }

}
