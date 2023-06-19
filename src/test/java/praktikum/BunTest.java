package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String NAME;
    private final float PRICE;

    public BunTest(String NAME, float PRICE) {
        this.NAME = NAME;
        this.PRICE = PRICE;
    }
    @Parameterized.Parameters
    public static Object[][]getTestData(){
        return new Object[][]{
                {"white bun",200},
                {"black bun",100},
                {"red bun",300},
        };
    }
    @Before
    public void setUp(){
        bun=new Bun(NAME,PRICE);
    }

    @Test
    public void getNameTest() {
        assertEquals(NAME,bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(PRICE,bun.getPrice(),0);
    }
}