import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expextedName;
    private final float expectedPrice;

    public BunTest(String expextedName, float expectedPrice) {
        this.expextedName = expextedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][] {
                {"Классическая", -1},
                {"Super", 1},
                {"", 0},
                {"@#$", },
                {"             ", 9999999f},
                {"24242", -9999999f},
                {"Сааааамаааая длинннннннная бУУУУУлука", 23,5},
        };
    }

    @Test
    public void getBunNameTest(){
        Bun bun=new Bun(expextedName,100);
        Assert.assertEquals(expextedName,bun.getName());

    }
    
    @Test
    public void getPriceBunTest() {
        Bun bun=new Bun("black bun",expectedPrice);
        Assert.assertEquals(expectedPrice,bun.getPrice(),0);
    }
}
