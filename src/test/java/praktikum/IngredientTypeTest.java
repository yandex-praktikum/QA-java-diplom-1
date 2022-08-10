package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class IngredientTypeTest {

    List<IngredientType> ingredientTypeList;

    @Before
    public void setUp(){
        IngredientType[] ingredientTypes = IngredientType.values();
        ingredientTypeList = new ArrayList<>(Arrays.asList(ingredientTypes));
    }

    @Test
    public void ingredientTypeShouldContainsValueFilling() {
        assertTrue(ingredientTypeList.contains(IngredientType.FILLING));
    }

    @Test
    public void ingredientTypeShouldContainsValue() {
        assertTrue(ingredientTypeList.contains(IngredientType.SAUCE));
    }

    @Test
    public void ingredientTypeShouldHaveTwoValues(){
        assertEquals(ingredientTypeList.size(), 2);
    }
}