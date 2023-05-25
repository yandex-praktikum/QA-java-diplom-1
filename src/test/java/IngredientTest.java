import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingr = new Ingredient(IngredientType.SAUCE, "Сосиска", 700);

    @Test
    public void getTypeTest() {
        assertEquals(ingr.getType(), IngredientType.SAUCE);
    }

    @Test
    public void getNameTest() {
        assertEquals(ingr.getName(), "Сосиска");
    }

    @Test
    public void getPriceTest() {
        assertEquals(ingr.getPrice(), 700, 1);
    }
}
