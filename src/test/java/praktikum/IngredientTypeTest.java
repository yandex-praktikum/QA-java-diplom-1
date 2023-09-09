package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testTypesVariantsIs2() {

        assertEquals("wrong number of ingredients types", 2, IngredientType.values().length);
    }
    @Test
    public void testSauceValue() {

        assertEquals("Wrong value of ingredient's type", IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }
    @Test
    public void testFillingValue(){
        assertEquals("Wrong value of ingredient's type", IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

}