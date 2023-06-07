import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunMockTest {
    @Mock
    public Bun bun;

    @Test
    public void getZeroPriceBun() {
        Mockito.when(bun.getPrice()).thenReturn(0.0f);
        Assert.assertEquals(0.0f, bun.getPrice(), 0.1f);
    }

    @Test
    public void getMinusPriceBun() {
        Mockito.when(bun.getPrice()).thenReturn(-50.0f);
        Assert.assertTrue(bun.getPrice() < 0);
    }

    @Test
    public void getMaxPriceBun() {
        Mockito.when(bun.getPrice()).thenReturn(Float.MAX_VALUE);
        Assert.assertEquals(Float.MAX_VALUE, bun.getPrice(), 0.1f);
    }

    @Test
    public void getMinPriceBun() {
        Mockito.when(bun.getPrice()).thenReturn(Float.MIN_VALUE);
        Assert.assertEquals(Float.MIN_VALUE, bun.getPrice(), 0.1f);
    }

    @Test
    public void getEmptyNameBun() {
        Mockito.when(bun.getName()).thenReturn("");
        Assert.assertEquals("", bun.getName());
    }

    @Test
    public void getNullNameBun() {
        Mockito.when(bun.getName()).thenReturn(null);
        Assert.assertNull(bun.getName());
    }

    @Test
    public void getLongNameBun() {
        Mockito.when(bun.getName()).thenReturn(
                "QWERTYUIOPASDFGHJKLZXCDFGHJKLZXCVBNMQWERTYUIOPASDFGHJKL" +
                        "ZXCVBNMQWERKLZXCVBNMQWERTYUIOPASDFGHJKLZXCVBNMQWERTYU" +
                        "IOASDFGHJKLZXCVBNMQWERTYUIOPASDFGHJKLZXCVBNMQWERTYUIOASDFGHJKLZXC" +
                        "VBNMQWERTYUIOPASDFGHJKLZXCVBNMQWEKLZXCVBNMQWERTYUIOP" +
                        "ASDFGHJKLZXCVBNDFGHJKLZXCVBNMQWERTYUIOPASDFGHJKLZXCVB" +
                        "NMQWERTYUIOASDFGHJKLZXCVBNMQWERTYUIOPASDFGHJKLZXCVBNMQWERTYUIOASD" +
                        "FGHJKLZXCVBNMQWERTYUIOPALZXCVBNMQWERTYUIOASDFGHJKLZXCVBNMQ" +
                        "WERTYUIOPASDFGHJKLZXCVBNMQWERTYULZXCVBNMQWERTYUIOPASDFG" +
                        "HJKLZXCVBNMQWERTYUIOASDFGHJKLZXCVBNMQWERTFHKLHFGDYUIOPASDFGHJKLZXCVBNMQWE" +
                        "RTYSHJHJSHSHDGJLSALJFDKKKDSGJKGJHLHKHKLKLKQWERTYUIOASDFGHJK" +
                        "LZXCVBNMQWERTYUIOPASDFGHJKLZXCVBNMQWERTYUIOASDFGHJKLZXCVBNMQWERTY" +
                        "UIOPASDFTYUIOASDFGHJKLZXCVBNMQWERTYSFGJJJJJJJJJJJUIOPASDFGHJKLZ" +
                        "XCVBNMQWERTYUIOBUNBUNBUNCVBNMQWERTYUIOPASDFGHJKLZXCVBNMQWERTYUI" +
                        "SDFGHJKLZXCVBNMQWERTYUIOASDFGHJKLZXCVBNMQWERTYUIOPASDFGHJKLZXCVBN"
        );
        Assert.assertEquals(String.class, bun.getName().getClass());
    }
    @Test
    public void getSymbolsNameBun() {
        Mockito.when(bun.getName()).thenReturn(")(*&^%$#@?><");
        Assert.assertEquals(String.class, bun.getName().getClass());
    }

}
