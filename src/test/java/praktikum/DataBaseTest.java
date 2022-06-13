package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class DataBaseTest {

    @Test
    public void availableBuns() {
        Database database = new Database();
        Bun bunExpected = new Bun("Ты не плач, я куплю тебе Калач", 10);
        database.availableBuns().add(0,bunExpected);

        Bun actual = database.availableBuns().get(0);
        Bun expected = bunExpected;
        assertEquals(expected, actual);
    }


    @Test
    public void availableIngredients() {
        Database database = new Database();
        Ingredient ingredientExpected = new Ingredient(IngredientType.FILLING,"Мухоморы свежесобранные из угодий Бабы-Яги",100_000_000F);;
        database.availableIngredients().add(0,ingredientExpected);

        Ingredient actual = database.availableIngredients().get(0);
        Ingredient expected = ingredientExpected;
        assertEquals(expected, actual);
    }
}
