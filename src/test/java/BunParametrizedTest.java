import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {

private String name;
private float price;
private String expectedName;
private float expectedPrice;

public BunParametrizedTest(String name, float price,
                           String expectedName, float expectedPrice) {
    this.name = name;
    this.price = price;
    this.expectedName = expectedName;
    this.expectedPrice = expectedPrice;
}

    @Parameterized.Parameters
    public static Object [][] getTestData(){
        return new Object[][]{
                {"Булочка", 45f, "Булочка", 45f},
                {"", 45f, "", 45f},
                {"Очень длинное название булочки, которое будет невозможно напечатать ни на одном чеке разумной величины",
                45f, "Очень длинное название булочки, которое будет невозможно напечатать ни на одном чеке разумной величины", 45f},
                {null, 45f, null, 45f},
                {"*&^^%$##@##$#^&^&**!.,/*-+:;'", 45f, "*&^^%$##@##$#^&^&**!.,/*-+:;'", 45f},
                {"Булочка", -55f,"Булочка", -55f},
                {"Булочка", 0f, "Булочка", 0f},
                {"Булочка", 0.00000001f,
                        "Булочка", 0.00000001f},
                {"Булочка", -6546554654654646445465f, "Булочка", -6546554654654646445465f},
        };
    }

 @Test
public void getNameTest(){
     Bun bun = new Bun(name, price);
     assertEquals(expectedName, bun.getName());
 }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun(name, price);
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
