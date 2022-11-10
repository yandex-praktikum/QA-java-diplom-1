package praktikum.bun;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetNameTest {
    private final String NAME;
    private static Faker faker = new Faker();

    public GetNameTest(String name) {
        this.NAME = name;
    }

    @Parameterized.Parameters
    public static Object[][] typeValues() {
        return new Object[][] {
                { faker.regexify("[A-Za-z]{6}")}, //only letters
                { faker.regexify("[0-9]{6}")}, //only numbers
                { faker.internet().password(6,20,true, true)}, //with special characters
                { ""},
                { null},
                { faker.regexify("[A-Za-z]{100}")}, //long string
        };
    }

    @Test
    public void getNameReturnsCorrectValues() {
        String expectedName = NAME;
        float expectedPrice = faker.number().numberBetween(1,10000);

        Bun bun = new Bun(expectedName, expectedPrice);

        String actualName = bun.getName();
        assertEquals("Name is not correct: ", expectedName, actualName);
    }
}
