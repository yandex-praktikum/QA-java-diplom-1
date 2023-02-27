import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    protected final static String BUN_NAME = "Флюоресцентная булка R2-D3";
    protected final static float BUN_PRICE = 988.5f;
    private Bun bun;

    @Before
    public void objectPrepare(){
        bun =new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void checkBunName(){
        assertEquals("Неверное наименование булки!", BUN_NAME, bun.getName());
    }

    @Test
    public void checkBunPrice(){
        assertThat("Неверная стоимость булки!", bun.getPrice(), is(BUN_PRICE));
    }
}

