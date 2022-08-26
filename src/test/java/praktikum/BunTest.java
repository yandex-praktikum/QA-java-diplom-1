package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BunTest {

    Bun bun;

    @Before
    public void setUp() {
       Database database = new Database();
       final List<Bun> buns = database.availableBuns();
       bun = buns.get(0);
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        String expectedValue = "black bun";
        assertEquals(expectedValue, bun.getName());
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        float expectedValue = 100;
        assertEquals(expectedValue, bun.getPrice(), 0.0);
    }

    @Test
    public void getNameShouldReturnErrorIfNameIsNotCorrect() {
        String expectedValue = "UnknownName";
        assertNotEquals(expectedValue, bun.getName());
    }

    @Test
    public void getPriceShouldReturnErrorIfPriceIsNotCorrect() {
        float expectedValue = 999;
        assertNotEquals(expectedValue, bun.getPrice());
    }

}