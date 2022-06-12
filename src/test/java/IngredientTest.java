import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private final IngredientType type = IngredientType.SAUCE;
    private final String name = "hot sauce";
    private final float price = 100;

    @Test
    public void getPriceTest() {
        //Arrange
        Ingredient ingredient = new Ingredient(type, name, price);
        //Act
        float actualPrice = ingredient.getPrice();
        //Assert
        assertEquals(price, actualPrice, 1e-8);
    }

    @Test
    public void getNameTest() {
        //Arrange
        Ingredient ingredient = new Ingredient(type, name, price);
        //Act
        String actualName = ingredient.getName();
        //Assert
        assertEquals(name, actualName);
    }

    @Test
    public void getTypeTest() {
        //Arrange
        Ingredient ingredient = new Ingredient(type, name, price);
        //Act
        IngredientType actualType = ingredient.getType();
        //Assert
        assertEquals(type, actualType);
    }
}
