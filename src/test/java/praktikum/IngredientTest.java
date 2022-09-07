package praktikum;

import net.bytebuddy.description.field.FieldDescription;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    private final IngredientType type = IngredientType.SAUCE;
    private final String name = "Space ingredient";
    private final float price = 10F;

    @Test
    public void getPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualResult = ingredient.getPrice();

        assertEquals(price, actualResult, 0.00001);
    }

    @Test
    public void getNameReturnsName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualResult = ingredient.getName();

        assertEquals("The ingredient name is not equals", name, actualResult);
    }

    @Test
    public void getTypeReturnsType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualResult = ingredient.getType();

        assertEquals(type, actualResult);
    }

}