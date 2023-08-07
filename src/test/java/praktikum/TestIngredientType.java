package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestIngredientType {

    @Test
    public void SAUCEisNotNull() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void FILLINGisNotNull() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }

}