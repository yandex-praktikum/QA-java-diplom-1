package praktikum.ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Mock
    Database database;

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Сырный", 20);
        float actual = ingredient.getPrice();
        float expected = 20;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getPriceFromDB() {
        Database database = new Database();
        Ingredient ingredient = database.availableIngredients().get(1);
        float actual = ingredient.getPrice();
        float expected = database.availableIngredients().get(1).price;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Сыр", 25);
        String actual = ingredient.getName();
        String expected = "Сыр";
        assertEquals(expected, actual);
    }

    @Test
    public void getNameFromDb() {
        Database database = new Database();
        Ingredient ingredient = database.availableIngredients().get(2);
        String actual = ingredient.getName();
        String expected = database.availableIngredients().get(2).name;
        assertEquals(expected, actual);
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Кетчуп", 15);
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, actual);
    }

    @Test
    public void getTypeFromDB() {
        Database database = new Database();
        IngredientType actual = database.availableIngredients().get(1).getType();
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, actual);
    }
}