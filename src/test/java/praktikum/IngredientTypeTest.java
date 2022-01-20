package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class IngredientTypeTest {


    @Test
    public void getIngredientTypeTest(){
        //Arrange
        IngredientType sauce = IngredientType.SAUCE;
        IngredientType filling = IngredientType.FILLING;
        //Act
        String expectedSauces = "SAUCE\n"+"FILLING";
        String actualSauce = sauce.name().toString()+"\n"+filling.name().toString();
        //Assert
        assertEquals("Типы ингредиентов не совпадают!", actualSauce, expectedSauces);


    }


}
