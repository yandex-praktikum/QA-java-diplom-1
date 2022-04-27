import org.junit.Test;
import praktikum.*;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(SAUCE, "Соус Spicy-X", 90);

    @Test
    public void getPriceTest() {
        assertEquals("Неправильная цена",90, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        assertEquals( "Неправильное имя","Соус Spicy-X", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Неправильный тип",SAUCE, ingredient.getType());
    }
}