package practikumTests;

import praktikum.Bun;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static testData.TestConstants.DELTA;

public class BunTest {

    private Bun bunNull;
    private Bun bunNotNull;

    @Before
    public void init(){
        bunNotNull = new Bun("Булка", 96.25f);
        bunNull = new Bun(null, 0);
    }

    @Test
    public void getNotNullNameTest(){
        Assert.assertEquals("Булка", bunNotNull.getName());
    }

    @Test
    public void getNotNullPriceTest(){
        Assert.assertEquals(96.25f, bunNotNull.getPrice(), DELTA);
    }

    @Test
    public void getNullNameTest(){
        Assert.assertNull("Булка с названием", bunNull.getName());
    }

    @Test
    public void getNullPriceTest(){
        Assert.assertEquals(0, bunNull.getPrice(), DELTA);
    }

}
