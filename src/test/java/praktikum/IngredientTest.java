package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.constants.Constants.*;

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


    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {SAUCE, SAUCE_SPACY_X, 100},
                {SAUCE, SAUCE_SPECIAL_SPACE_SAUCE, 0},
                {SAUCE, SAUCE_ANTARIAN_PLANEWALKER_SPIKED, -100},
                {SAUCE, EMPTY_STRING, 200},
                {SAUCE, SPECIAL_CHARACTER_STRING, 200},
                {SAUCE, null, 200},
                {FILLING, FILLING_MEAT_IMMORTAL_MOLLUSKS, 100},
                {FILLING, FILLING_BEEF_METEORITE, 0},
                {FILLING, FILLING_MINI_SALAD_EXO_PLANTAGO, -100}
        };
    }

    @Test
    public void getNameSuccess() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(
                name,
                ingredient.getName());
    }

    @Test
    public void getPriceSuccess()  {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(
                price,
                ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeSuccess()  {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(
                type,
                ingredient.getType());
    }

}

