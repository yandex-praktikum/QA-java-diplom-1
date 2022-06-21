package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest {

    int expectedNumberOfBuns = 3;
    int expectedNumberOfIngredients = 6;
    Database database = new Database();

    @Test
    public void testAvailableBun(){
        int actualNumberOfBuns = database.availableBuns().size();
        Assert.assertEquals(
                "Number of buns is incorrect" ,expectedNumberOfBuns, actualNumberOfBuns);
    }

    @Test
    public void testAvailableIngredients(){
        int actualNumberOfIngredients = database.availableIngredients().size();
        Assert.assertEquals("Number of ingredients is incorrect" ,expectedNumberOfIngredients, actualNumberOfIngredients);
    }


}