package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataBaseTests {

    Database dataBase = new Database();

    @Test
    public void availableBunsTest() {
        assertEquals("Wrong list size", 3, dataBase.availableBuns().size());
    }

    @Test
    public void availableIngredientsTest() {
        assertEquals("Wrong list size", 6, dataBase.availableIngredients().size());
    }
}
