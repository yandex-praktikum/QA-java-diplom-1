package ingredient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientGetNameTest {
    IngredientType type = IngredientType.SAUCE;

    private final String name;
    float price = 100;

    public IngredientGetNameTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getDataOfBun() {
        return new Object[][]{
                {"normal name"},
                {null},
                {"@$#"},
                {"      "},
                {""},
                {"really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string really long string "},
                {"русский текст"},

        };
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }
}
