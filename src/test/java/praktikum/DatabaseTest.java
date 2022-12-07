package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    Database database = new Database();

    //Проверяем метод availableBuns()
    @Test
    public void availableBunsCheck() {
        int expectedResult = 3;
        int actualResult = database.availableBuns().size();
        assertEquals("List of buns is incorrect", expectedResult, actualResult);
    }

    //Проверяем метод availableIngredients()
    @Test
    public void availableIngredientsCheck() {
        int expectedResult = 6;
        int actualResult = database.availableIngredients().size();
        assertEquals("List of buns is incorrect", expectedResult, actualResult);
    }
}