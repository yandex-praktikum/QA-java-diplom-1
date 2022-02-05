import org.junit.Before;
import org.junit.Test;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTest {
    List<Ingredient> ingredients_;
    Database database;
    Ingredient ingredient;

    @Before
    public void setUp(){
        database = new Database();
        ingredients_ = database.availableIngredients();
        ingredient = new Ingredient(ingredients_.get(0).type, ingredients_.get(0).name, ingredients_.get(0).price);
    }

    @Test
    public void getType() {
        assertEquals(ingredient.getType(), IngredientType.SAUCE);
    }

    @Test
    public void getName() {
        assertEquals(ingredient.getName(), "hot sauce");
    }

    @Test
    public void getPrice() {
        assertEquals(ingredient.getPrice(), 100, 0);
    }
}
