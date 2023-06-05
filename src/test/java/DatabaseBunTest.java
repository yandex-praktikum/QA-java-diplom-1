import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class DatabaseBunTest {
    public  final  int index;
    private final String name;
    private final float price;

    public DatabaseBunTest(int index, String name, float price){
        this.index = index;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        Object[][] data = new Object[][]{
                {0,"black bun", 100f},
                {1,"white bun", 200f},
                {2,"red bun", 300f}
        };
        return Arrays.asList(data);
    }

      @Test
      public void    availableBunsReturnsCorrectValue(){
          Database database = new Database();
          Bun bun = database.availableBuns().get(index);
          String actualName = bun.getName();
          float actualPrice = bun.getPrice();
          Assert.assertEquals("Ожидалось другое имя", name, actualName);
          Assert.assertEquals("Ожидалсь другая цена", price, actualPrice, 0.001);
      }
}
