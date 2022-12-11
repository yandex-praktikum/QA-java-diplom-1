import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)

public class BunTest {
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameters
    public static Object[][] getData(){
        return  new Object[][]{
                {"Флюоресцентная булка R2-D3",636},
                {"Краторная булка N-200i", 300.6f},
                {null,6766},
                {"uhfuhuhvhvdvjk", 3557856556556584f},
                {"",0}
        };
    }

    private  Bun bun;
    @Before
    public void startTest(){
        bun = new Bun(name,price);

    }
    @Test
    public void checkGetName_shouldBeName(){
        String actual =  bun.getName();
        assertEquals("Имя должно совпадать",name,actual);
    }
    @Test
    public void  checkGetPrice_shouldBePrice(){
        Float actual = bun.getPrice();
        Assert.assertEquals("Цена дожна совпадать",price,actual, 0.01);


    }
}
