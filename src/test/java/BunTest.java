import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private String bunName = "Пшеничная булочка";
    private float bunPrice = 3.57f;

    @Before
    public void createBun(){
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getNameIsCorrect(){
        assertEquals("Поле name объекта bun не совпадает с ожидаемым", bunName, bun.getName());
    }

    @Test
    public void getPriceIsCorrect(){
        assertEquals( bunPrice, bun.getPrice(), 0);
    }

    @Test
    public void setBunNewNameIsSuccesfull(){
        String newBunName = "Ржаная";
        bun.name = newBunName;
        assertEquals("Поле name объекта bun не совпадает с ожидаемым", newBunName, bun.getName());
    }

    @Test
    public void setBunNewPriceIsSuccesfull(){
        float newBunPrice = 4.01f;
        bun.price = newBunPrice;
        assertEquals(newBunPrice, bun.getPrice(), 0);
    }



}
