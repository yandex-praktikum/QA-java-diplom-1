package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    @Test
    public void getNameReturnNameIsEquals() {
        String expected = "Белая булочка";
        Bun bun = new Bun(expected, 12.50f);

        String actual = bun.getName();

        String message = String.format("Фактическое значение не соответсвует ожидаемому значению. \nОжидаемое значение:\"%s\";\nФактическое значение:\"%s\";\n",expected,actual);
        Assert.assertEquals(message,expected,actual);
    }

    @Test
    public void getPriceReturnPriceIsEquals() {
        float expected = 12.50f;
        Bun bun = new Bun("Белая булочка", expected);

        float actual = bun.getPrice();

        String message = String.format("Фактическое значение не соответсвует ожидаемому значению. \nОжидаемое значение:\"%s\";\nФактическое значение:\"%s\";\n",expected,actual);
        Assert.assertEquals(message,expected,actual, 0.0f);
    }

    @Test
    public void constructorBunCreatedBun() {
        String name = "Белая булочка";
        float price = 12;

        Bun bun = new Bun (name,price);

        Assert.assertNotNull(bun);
        Assert.assertEquals(name,bun.name);
        Assert.assertEquals(price,bun.price,0.0f);
    }

    @Test
    public void constructorBunNameNullCreatedBun() {
        String name = null;
        float price = 12;

        Bun bun = new Bun ( name,price);

        Assert.assertNotNull(bun);
        Assert.assertEquals(name,bun.name);
        Assert.assertEquals(price,bun.price,0.0f);
    }

    @Test
    public void constructorBunNull2IsCreateBun() {
        String name = "";
        long price = 1245001264454545451L;

        Bun bun = new Bun ( name, price);

        Assert.assertNotNull(bun);
        Assert.assertEquals(name,bun.name);
        Assert.assertEquals(price,bun.price,0.0f);
    }

    @Test
    public void constructorBunInt2IsCreateBun() {
        String name = "null";
        int price = 12;

        Bun bun = new Bun (name, price);

        Assert.assertNotNull(bun);
        Assert.assertEquals(name,bun.name);
        Assert.assertEquals(price,bun.price,0.0f);
    }

}
