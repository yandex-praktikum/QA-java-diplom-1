package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class IngredientTest {


    IngredientType type;
    Faker faker = Faker.instance();
    Random random = new Random();

    final private String name = faker.name().toString();
    final private float price = random.nextFloat();


    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void getPriceCheck() {
        String expected = name;
        String actual = ingredient.getName();
        assertEquals(expected,actual);
    }

    @Test
    public void getNameCheck() {
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals(expected,actual,0);
    }

    @Test
    public void getTypeCheck() {
        IngredientType actual = ingredient.getType();
        assertEquals(type, actual);
    }
}