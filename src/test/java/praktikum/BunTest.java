package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    Bun bun = new Bun("Краторная булка N-200i",1255.0f);

    @Test
    public void getNameReturnsCorrectBunName() {
        //Arrange
        String expectedBunName = "Краторная булка N-200i";
        //Act
        String actualBunName = bun.getName();
        //Assert
        Assert.assertEquals(expectedBunName, actualBunName);
    }

    @Test
    public void getPriceReturnsCorrectBunPrice() {
        //Arrange
        float expectedBunPrice = 1255.0f;
        //Act
        float actualBunPrice = bun.getPrice();
        //Assert
        Assert.assertEquals(expectedBunPrice, actualBunPrice, 0);
    }
}