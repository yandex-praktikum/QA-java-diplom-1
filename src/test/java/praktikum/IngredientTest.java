package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class IngredientTest {

    public final IngredientType type;
    public final String name;
    public final float price;

    public IngredientTest (IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][] {
                {FILLING,"Плюшка",8},
                {FILLING,"Круассан",7},
                {SAUCE, "Рогалик",10},
        };
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type,ingredient.getType());
    }
    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }
}
