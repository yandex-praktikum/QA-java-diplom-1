import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private Bun bun;
    private float actualPrice;
    private float expectedPrice;
    private float delta;

    @Before
    public void setUp(){
        bun = new Bun("булочка", actualPrice);
    }


    public BunTest(float actualPrice, float expectedPrice, float delta ) {
        this.actualPrice = actualPrice;
        this.expectedPrice = expectedPrice;
        this.delta = delta;
    }

    @Parameterized.Parameters
    public static Object[][] getPrice()
    {
        return new Object[][] {
                {55.00f, 55.01f, 0.01f},
                {57.00f, 57.00f, 0.00f}
        };
    }

    @Test
    public void getNameBunReturnString(){

        String expectedNameBun = "булочка";

        assertEquals("Name bun should be String", expectedNameBun, bun.getName());
    }

    @Test
    public void getNameBunReturnFloat(){

        assertEquals("Price bun should be float", expectedPrice, bun.getPrice(), delta);
    }

    }

