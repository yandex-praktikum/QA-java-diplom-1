package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                {"black bun", 50F},
                {"булка", 15},
                {"@#$%^$", 89652.4028235F},
                {"", 1F},
                {" 41231", 3.5545982F},
                {null, 0},
                {"Очень довольная женщина пошла с действительно белой лопатой через шляпу моей маленькой хорошо упитанной свиньи", -51F},
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        assertThat(name, equalTo(bun.getName()));
    }
    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        assertTrue(price == bun.getPrice());
    }
}