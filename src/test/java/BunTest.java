import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameBurgerTest(){
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        Assert.assertEquals("Некорректное название булки","Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void getPriceBurgerTest(){
        Bun bun = new Bun("Краторная булка N-200i", 1255.5f);
        Assert.assertEquals("Некорректная цена булки", 1255.5, bun.getPrice(), 0.01);
    }
}
