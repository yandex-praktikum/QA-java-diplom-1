import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametersTest {

    private final int index;
    private final String expectedName;
    private final float expectedPrice;
    IngredientType expectedType;

    public IngredientParametersTest(int index,IngredientType expectedType,  String expectedName, float expectedPrice) {
        this.index = index;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[] getString() {
        return new Object[][] {
                { 0, IngredientType.SAUCE, "hot sauce", 100},
                { 1, IngredientType.SAUCE, "sour cream", 200},
                { 2, IngredientType.SAUCE, "chili sauce", 300},
                { 3, IngredientType.FILLING, "cutlet", 100},
                { 4, IngredientType.FILLING, "dinosaur", 200},
                { 5, IngredientType.FILLING, "sausage", 300},
        };
    }

    @Test
    public void getNameAndPrice(){
    /*
    Получим данные по типу, наименованию и цене из БД и сравним с шаблоном
     */
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = new Ingredient(
                ingredients.get(index).type,
                ingredients.get(index).name,
                ingredients.get(index).price);
        IngredientType type = ingredient.getType();
        String name = ingredient.getName();
        float price = ingredient.getPrice();

        assertEquals(type, expectedType);
        assertEquals(name, expectedName);
        assertEquals(price, expectedPrice, 0);

    }
}
