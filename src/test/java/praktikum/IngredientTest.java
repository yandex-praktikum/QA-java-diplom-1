package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class IngredientTest {

    private IngredientType getRandomIngredientType() {
        IngredientType[] values = IngredientType.values();
        return values[random.nextInt(values.length)];
    }

    Faker faker = Faker.instance();
    Random random = new Random();

    final private IngredientType type = getRandomIngredientType();
    final private String name = faker.name().toString();
    final private float price = random.nextFloat();


    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void getPriceCheck() {
        String actual = ingredient.getName();
        assertEquals(name, actual);
    }

    @Test
    public void getNameCheck() {
        float actual = ingredient.getPrice();
        assertEquals(price, actual, 0);
    }

    @Test
    public void getTypeCheck() {
        IngredientType actual = ingredient.getType();
        assertEquals(type, actual);
    }

}