package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class BunTest {

    private String name;
    private float price;

    @Test
    public void getNameReturnsName() {
        Bun bun = new Bun(name, price);
        String expected = name;
        MatcherAssert.assertThat("Incorrect name was provided", bun.getName(), equalTo(expected));
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        Bun bun = new Bun(name, price);
        float expected = price;
        MatcherAssert.assertThat("Incorrect price or empty value is provided", bun.getPrice(), equalTo(expected));
    }
}