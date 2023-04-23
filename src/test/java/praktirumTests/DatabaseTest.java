package praktirumTests;

import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    @Test
    public void availableBunsTest() {
        assertEquals(3, (new Database())
                .availableBuns().size());
    }

    @Test
    public void availableIngredientsTest() {
        assertEquals(6, (new Database())
                .availableIngredients().size());
    }
}
