import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Collection;

@RunWith(Parameterized.class)

public class BunTest {
    private Bun bun;

    private String nameBun;
    private float priceBun;


    public BunTest(String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{{"black bun",100.0F}, {"white bun", 200.0F}};
    }
    @Test
    public void getNameTest(){
        Bun bun=new Bun(this.nameBun,this.priceBun);
        String expected= this.nameBun;
        String actual= bun.getName();
        Assert.assertEquals("Ошибка",expected,actual);
    }
    @Test
    public void getPriceTest(){
        Bun bun= new Bun(this.nameBun,this.priceBun);
        float expected=this.priceBun;
        float actual = bun.getPrice();
        Assert.assertEquals("Ошибка",expected,actual,0.0);
    }
}
