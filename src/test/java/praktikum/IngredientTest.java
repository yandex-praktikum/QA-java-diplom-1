package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Mock
    IngredientType ingredientType;

    @Test
    public void getIngredientNameTest() {
        Faker faker = new Faker();
        float price = faker.number().randomDigit(); //
        Ingredient ingredient = new Ingredient(SAUCE, "sour cream", price);
        String actual = ingredient.getName();
        String expected = "sour cream";
        assertEquals("ingredient name is correct", expected, actual);
    }

    @Test
    public void getIngredientPriceTest() {
        Faker faker = new Faker();
        String name = faker.name().firstName(); //Karyn
        Ingredient ingredient = new Ingredient(SAUCE, name, 455);
        float actual = ingredient.getPrice();
        float expected = 455;
        assertEquals("ingredient price is correct", expected, actual, 0);
    }


    @Test
    public void getIngredientTypeTest() {
        Faker faker = new Faker();
        float price = faker.number().randomDigit(); //
        String name = faker.name().firstName(); //Karyn
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actual = ingredient.getType();
        IngredientType expected = ingredientType;
        assertEquals("ingredient type is correct", expected, actual);
    }
}
