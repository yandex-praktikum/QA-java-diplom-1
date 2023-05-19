package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void fillingNotNull() {
        assertNotNull("В ингредиентах нет начинки", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void sauceNotNull() {
        assertNotNull("В ингредиентах нет соуса", IngredientType.valueOf("SAUCE"));
    }
}