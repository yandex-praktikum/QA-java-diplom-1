package praktikum;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import static praktikum.IngredientType.*;

class IngredientTest {

    Ingredient ingredient = new Ingredient(SAUCE, "Соус Spicy-X", 90);

    @Test
    public void getPrice() {
        assertEquals("Неправильная цена", 90, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        assertEquals("Неправильное имя", "Соус Spicy-X", ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals("Неправильный тип", SAUCE, ingredient.getType());
    }
}