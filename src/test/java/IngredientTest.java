import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    public static IngredientType type;
    public static String name;
    public static float price;

    public IngredientTest(IngredientType type, String name, float price) {
        IngredientTest.type = type;
        IngredientTest.name = name;
        IngredientTest.price = price;
    }

    @Parameterized.Parameters
    public static Object [][] getIngredientParameters() {
        return new Object[][] {
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "poppy", -1},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {SAUCE, "pesto", 0},
        };
    }

    @Test // Создаем ингредиент. Проверяем корректность цены.
    public void getPriceAndCheckIsCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float expectedResult = ingredient.getPrice();
        Assert.assertEquals("Цена ингредиента некорректна!", expectedResult, price, 0);
    }

    @Test // Создаем ингредиент. Проверяем корректность названия.
    public void getNameAndCheckIsCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String expectedResult = ingredient.getName();
        Assert.assertEquals("Название ингредиента некорректно!", expectedResult, name);
    }

    @Test // Создаем ингредиент. Проверяем корректность типа.
    public void getTypeAndCheckIsCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expectedResult = ingredient.getType();
        Assert.assertEquals("Тип ингредиента некорректен!", expectedResult, type);
    }
}
