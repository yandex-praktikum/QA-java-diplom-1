import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][] {
                { "",-1000},
                { "jgjhghgkjhgkjhgkjhgkjhguyftyddrtrsklllllllllllllhghdgfsd",67/9},
                { null,1000000000},
                { "black bun",100},
                { ".,.,.,.,;'",0},
                { "870",-0},
        };
    }

    @Test
    public void getBunNameTest(){
        Bun bun=new Bun(name,100);
    Assert.assertEquals(name,bun.getName());

    }

    @Test
    public void getPriceBunTest() {
        Bun bun=new Bun("black bun",price);
        Assert.assertEquals(price,bun.getPrice(),0);
    }
}
