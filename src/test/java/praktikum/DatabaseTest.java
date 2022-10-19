package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DatabaseTest {

    @Test
    public void testAvailableBuns() {
        assertEquals(3, (new Database()).availableBuns().size());
    }

    @Test
    public void testAvailableIngredients() {
        assertEquals(6, (new Database()).availableIngredients().size());
    }
}

