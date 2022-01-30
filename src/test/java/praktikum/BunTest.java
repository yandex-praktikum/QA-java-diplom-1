package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BunTest {
     private Bun bun;

     @Before
     public void prepareData() {
          bun = new Bun("Космобулка", 38.5f);
     }

     @Test
     public void getBunNameReturnCorrectName() {
          String expectedNameReturn = "Космобулка";
          String actualNameReturn = bun.getName();
          Assert.assertEquals(expectedNameReturn, actualNameReturn);
     }

     @Test
     public void getBunPriceReturnCorrectPrice() {
          float expectedPriceReturn = 38.5f;
          float actualPriceReturn = bun.getPrice();
          Assert.assertEquals(expectedPriceReturn, actualPriceReturn, 0.0);
     }
}
