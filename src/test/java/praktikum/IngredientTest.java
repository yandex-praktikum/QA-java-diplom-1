package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    // Инициализируем базу данных для тестов
    Database database = new Database();

    // Считаем список доступных ингредиентов из базы данных
    List<Ingredient> ingredient = database.availableIngredients();


    //Проверяем метод getPrice()
    @Test
    public void getPriceCheck() {
        float expectedResult = 100;
        float actualResult = ingredient.get(0).getPrice();
        assertEquals("Price is incorrect", expectedResult, actualResult, 0);
    }

    //Проверяем метод getName()
    @Test
    public void getNameCheck() {
        String expectedResult = "hot sauce";
        String actualResult = ingredient.get(0).getName();
        assertEquals("String is incorrect", expectedResult, actualResult);
    }

    //Проверяем метод getType()
    @Test
    public void getTypeCheck() {
        IngredientType expectedResult = IngredientType.SAUCE;
        IngredientType actualResult = ingredient.get(0).getType();
        assertEquals("IngredientType is incorrect", expectedResult, actualResult);
    }
}