import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import praktikum.Bun;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(JUnit4.class)
public class BunTest {

    private Bun bun;


    @Before
    public void prepareData() {
        bun = new Bun(TestData.BUN_NAME, TestData.BUN_PRICE);
    }

    @Test
    public void testGetBunName() {
        assertThat("Имя для Bun неверное.", bun.getName(), equalTo(TestData.BUN_NAME));
    }

    @Test
    public void testGetBunPrice() {
        assertThat("Цена для Bun неверная.", bun.getPrice(), equalTo(TestData.BUN_PRICE));
    }
}
