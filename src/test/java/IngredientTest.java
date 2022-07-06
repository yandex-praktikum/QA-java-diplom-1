import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    public String name = "sour cream";
    public float price = 200f;
    public IngredientType type;

    @Test
    public void shouldReturnName() {
        Ingredient ingredient = new Ingredient(type.SAUCE, name, price);
        String expectedName = "sour cream";
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void shouldReturnPrice() {
        Ingredient ingredient = new Ingredient(type.SAUCE, name, price);
        float expectedPrice = 200f;
        assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldReturnIngredientType() {
        Ingredient ingredient = new Ingredient(type.SAUCE, name, price);
        IngredientType expectedIngredientType = IngredientType.SAUCE;
        assertEquals(expectedIngredientType, ingredient.getType());
    }
}
