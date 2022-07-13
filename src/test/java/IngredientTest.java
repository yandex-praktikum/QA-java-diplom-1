import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
     IngredientType type;
     String name;
     float price;


    public IngredientTest(IngredientType type, String name,float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { FILLING, "Начинка", 200f},
                { SAUCE, "Соус", 100f},
        };
    }

    @Test
    public void getPriceIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        assertEquals(actual, price, 0 );
    }

    @Test
    public void getNameIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        assertEquals(actual, name);
    }

    @Test
    public void getTypeIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        assertEquals(actual, type);
    }
}
