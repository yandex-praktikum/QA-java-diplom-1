package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;


public class IngredientTypeTest {

    @Test
    public void ShouldBeLenghtIngredientType(){
        int actualResult= IngredientType.values().length;
        assertEquals(2,actualResult);

    }

    @Test
    public void ShouldBeTypeSause(){
        assertEquals(IngredientType.valueOf("SAUCE"),IngredientType.SAUCE);

    }
    @Test
    public void ShouldBeTypeFilling(){
        assertEquals(IngredientType.valueOf("FILLING"),IngredientType.FILLING);

    }

}