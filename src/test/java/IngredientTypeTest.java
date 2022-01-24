
import org.junit.Test;
import praktikum.*;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void IngredientTypeTest(){

      String expectedSauce = "SAUCE";
      String expectedFilling = "FILLING";
      String actualSauce = IngredientType.SAUCE.name();
      String actualFilling = IngredientType.FILLING.name();

      assertEquals(expectedSauce, actualSauce);

      assertEquals(expectedFilling, actualFilling);

    }


}
