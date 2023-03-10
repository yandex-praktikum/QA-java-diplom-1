package practicumTest;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

@RunWith(Parameterized.class)
public class IngredientTest {


    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Проверка работы конструктора со значениями: {0}, {1}, {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.FILLING, new Faker().space().galaxy(), new Random().nextFloat()},
                {IngredientType.SAUCE, new Faker().space().galaxy(), new Random().nextFloat()},
        };
    }


    @Test
    public void setIngredientTypeTest() {
        Ingredient integer = new Ingredient(type, name, price);
        Assert.assertEquals("Set a ingredient type is not correct", type, integer.getType());
    }

    @Test
    public void setNameTest() {
        Ingredient integer = new Ingredient(type, name, price);
        Assert.assertEquals("Set a name is not correct", name, integer.getName());
    }

    @Test
    public void setPriceTest() {
        Ingredient integer = new Ingredient(type, name, price);
        Assert.assertTrue("Set a price is not correct", price == integer.getPrice());
    }
}
