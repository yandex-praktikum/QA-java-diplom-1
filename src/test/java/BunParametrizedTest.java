import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParametrizedTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] bunsData(){
        return new Object[][]{
                {"Булка",1},
                {"Bulka", 100},
                {"Булка с сыром", Float.MIN_VALUE},
                {" ", 100},
                {"", 0},
                {null, 0},
                {"Ух ты моя булочка с корицей", -1},
                {"С сырком", Float.MAX_VALUE},
                {"База", 153.03f},
                {"Не база", -153.33f},
                {"@$#%%^#$@#$#$#@#$", 1},
                {"я посвятил тебе тысячи букв, десятки бессонных ночей, я был молод, дурак, просто глуп", 400}
        };
    }
    @Before
    public void setUp(){
        bun = new Bun(name,price);
    }

    @Test
    public void testBunName(){
        Bun bun = new Bun(name,price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testCheckBunPrice(){
        Bun bun = new Bun(name,price);
        Assert.assertEquals(price,bun.getPrice(),0.001F);
    }




}
