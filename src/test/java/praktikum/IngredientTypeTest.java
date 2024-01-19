package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

public class  IngredientTypeTest {

    @Test
    public void valueOfSauce(){
        TestCase.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void valueOfFilling(){
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}