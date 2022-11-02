import org.junit.Test;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestForIngredientUsingDatabase {
    public static final String HOT_SAUCE = "hot sauce";
    public static final String SOUR_CREAM = "sour cream";
    public static final String CHILI_SAUCE = "chili sauce";
    public static final String CUTLET = "cutlet";
    public static final String DINOSAUR = "dinosaur";
    public static final String SAUSAGE = "sausage";

    public static final float HOT_SAUCE_PRICE = 100;
    public static final float SOUR_CREAM_PRICE = 200;
    public static final float CHILI_SAUCE_PRICE = 300;
    public static final float CUTLET_PRICE = 100;
    public static final float DINOSAUR_PRICE = 200;
    public static final float SAUSAGE_PRICE = 300;
    Database database = new Database();

    @Test
    public void checkTheName() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(HOT_SAUCE, ingredients.get(0).name);
        assertEquals(SOUR_CREAM, ingredients.get(1).name);
        assertEquals(CHILI_SAUCE, ingredients.get(2).name);
        assertEquals(CUTLET, ingredients.get(3).name);
        assertEquals(DINOSAUR, ingredients.get(4).name);
        assertEquals(SAUSAGE, ingredients.get(5).name);
    }

    @Test
    public void checkThePrice() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(HOT_SAUCE_PRICE, ingredients.get(0).price, 0);
        assertEquals(SOUR_CREAM_PRICE, ingredients.get(1).price, 0);
        assertEquals(CHILI_SAUCE_PRICE, ingredients.get(2).price, 0);
        assertEquals(CUTLET_PRICE, ingredients.get(3).price, 0);
        assertEquals(DINOSAUR_PRICE, ingredients.get(4).price, 0);
        assertEquals(SAUSAGE_PRICE, ingredients.get(5).price, 0);
    }
@Test
    public void checkTheIngredientType(){
    List<Ingredient> ingredients = database.availableIngredients();
    assertEquals(IngredientType.SAUCE, ingredients.get(0).type);
    assertEquals(IngredientType.FILLING, ingredients.get(3).type);

}

}
