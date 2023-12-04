package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BunTest
{
    private static final String TEST_BUN_NAME = "test bun name";
    private static final float TEST_BUN_PRICE = 42f;

    @Test
    public void bunReturnCorrectName()
    {
        Bun bun = new Bun(TEST_BUN_NAME, TEST_BUN_PRICE);

        assertThat(bun.getName(), is(TEST_BUN_NAME));
    }

    @Test
    public void bunChangeNameSuccessful()
    {
        String newName = "changed bun name";
        Bun bun = new Bun(TEST_BUN_NAME, TEST_BUN_PRICE);
        bun.name = newName;

        assertThat(bun.getName(), is(newName));
    }

    @Test
    public void bunReturnCorrectPrice()
    {
        Bun bun = new Bun(TEST_BUN_NAME, TEST_BUN_PRICE);

        assertThat(bun.getPrice(), is(TEST_BUN_PRICE));
    }

    @Test
    public void bunChangePriceSuccessful()
    {
        float newPrice = 1234f;
        Bun bun = new Bun(TEST_BUN_NAME, TEST_BUN_PRICE);
        bun.price = newPrice;

        assertThat(bun.getPrice(), is(newPrice));
    }
}
