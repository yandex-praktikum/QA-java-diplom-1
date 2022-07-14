package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BunTest {

    private Bun bun;
    private String expectedName;
    private float expectedPrice;

    @Before
    public void setUp(){
        expectedName = "white";
        expectedPrice = 300;
        bun = new Bun(expectedName,expectedPrice);
    }

    @Test
    public void constructorBunTest(){
        assertThat(bun, notNullValue());
    }

    @Test
    public void getNameTest(){
        String actualName = bun.getName();
        assertThat(expectedName, equalTo(actualName));
    }

    @Test
    public void getPriceTest(){
        float actualPrice = bun.getPrice();
        assertThat(expectedPrice, equalTo(actualPrice));
    }

}
