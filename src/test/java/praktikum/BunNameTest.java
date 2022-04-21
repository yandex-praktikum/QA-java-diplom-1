package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunNameTest {

    private final String name;
    private final String expected;

    public BunNameTest(String name, String expected) {
        this.name = name;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Object[][] getNameTest() {
        Database database = new Database();
        return new Object[][] {
                { database.availableBuns().get(2).getName(), "red bun"},
                { "sOme_new bun :)", "sOme_new bun :)"},
                { "shameful bun 2022", "shameful bun 2022"},
                {null,null},
                {"",""},
        };
    }

    @Test
    public void shouldGetABunName()  {

        String actual = new Bun(name,20f).getName();
        assertEquals(expected, actual);

    }

}
