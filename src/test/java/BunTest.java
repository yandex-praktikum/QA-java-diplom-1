import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private String bun;
    private float price;

    public BunTest(String bun, float price){
        this.bun = bun;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][]getBun(){
        return new Object[][]{
                {"Булка с кунжутом", 120F},
                {"Острая булочка", 200F},
                {"Булка Премиум", 400F},
                {"простая булка", 70F},
        };
    }
    @Test
    public void priceBun(){
        Bun bun1 = new Bun(bun, price);
        float priceActual = bun1.getPrice();
        Assert.assertTrue(price == priceActual);
    }
    @Test
    public void nameBun(){
        Bun bun2 = new Bun(bun, price);
        String nameActual = bun2.getName();
        Assert.assertEquals(bun , nameActual);
    }
}
