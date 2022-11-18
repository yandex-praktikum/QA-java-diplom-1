package praktikum;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    private Bun bun;

    @Before
    public void createBun(){
    bun = new Bun("black bun", 100);
}
    @Test
    public void getNameTest(){
    Assert.assertEquals("black bun", bun.getName());
}
    @Test
    public void getPriceTest(){
        Assert.assertEquals(100, bun.getPrice(), 0.01);
    }

}