package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

private final String name;
private final float price;

public BunTest(String name, float price) {
    this.name = name;
    this.price = price;
}

@Parameterized.Parameters
public static Object[][] getData(){
    return new  Object[][] {
            {"PositiveNameAndPrice", 170.000f},
            {"PositiveName but Price is negative", -187547.816482f},
            {"", 000000.1f},
            {null, 100000.0006f},
    };
}

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals(name, actual);

    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        assertEquals(price, actual, 0);
    }
}

//Неясны требования насчет пустого имени, имя = null, and negative price.
//Я как бы добавил такие данные в параметры как допустимые.