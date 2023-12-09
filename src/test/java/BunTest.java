

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
//Class Bun does not have dependencies or complex logic, Therefor, no mocks or stubs are required here.
    @Test
    public void testGetName() {
        // Arrange
        Bun bun = new Bun("White Bun", 50f);
        String expectedResult = "White Bun";

        // Act
        String actualResult = bun.getName();

        // Assert
        assertEquals("The name of the bun should match the expected result.", expectedResult, actualResult);
    }

    @Test
    public void testGetPrice() {
        // Arrange
        Bun bun = new Bun("White Bun", 50f);
        float expectedResult = 50f;

        // Act
        float actualResult = bun.getPrice();

        // Assert
        assertEquals("The price of the bun should match the expected result.", expectedResult, actualResult, 0.01);
    }
}
