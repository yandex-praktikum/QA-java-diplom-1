import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;


public class IngredientTypeTest {
    @Test
    public void fillingNotNull(){
        assertNotNull("Такого соуса неn", IngredientType.valueOf("SAUCE"));
    }
    @Test
    public void sauceNotNull(){
        assertNotNull("Такой начинки нет", IngredientType.valueOf("FILLING"));
    }

}


