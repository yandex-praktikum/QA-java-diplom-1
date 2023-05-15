import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Before
    public void setup(){
        bun = new Bun("Ржаная",15.5f);
    }

    @Test
    public void getFoodTest(){
        assertEquals("Имя булочки не Ржаная!","Ржаная",bun.getName());
    }

    @Test
    public void getPriceTest(){
        assertEquals("Стоимость булочки не 15.5!",15.5f,bun.getPrice(),Constant.DELTA);
    }

}
