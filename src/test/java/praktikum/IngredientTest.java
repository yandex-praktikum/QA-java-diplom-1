package praktikum;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void getTypeFillingReturnFilling() {
        IngredientType typeExpected = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(typeExpected, "Котлета", 100);

        IngredientType actual = ingredient.getType();

        String message = String.format("Фактическое значение типа ингредиента не соответсвует ожидаемому значению. \nОжидаемое значение:\"%s\";\nФактическое значение:\"%s\";\n", typeExpected, actual);
        Assert.assertEquals(message, typeExpected, actual);
    }

    @Test
    public void getTypeSauceReturnSauce() {
        IngredientType typeExpected = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(typeExpected, "Барбекю", 50);

        IngredientType actual = ingredient.getType();

        String message = String.format("Фактическое значение типа ингредиента не соответсвует ожидаемому значению. \nОжидаемое значение:\"%s\";\nФактическое значение:\"%s\";\n", typeExpected, actual);
        Assert.assertEquals(message, typeExpected, actual);
    }

    @Test
    public void getNameReturnExpectedName() {
        String nameExpected = "Сырный";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, nameExpected, 150);

        String actual = ingredient.getName();

        String message = String.format("Фактическое значение названия не соответсвует ожидаемому значению. \nОжидаемое значение:\"%s\";\nФактическое значение:\"%s\";\n", nameExpected, actual);
        Assert.assertEquals(message, nameExpected, actual);
    }

    @Test
    public void getPriceReturnExpectedPrice() {
        float priceExpected = 150;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сырный", priceExpected);

        float actual = ingredient.getPrice();

        String message = String.format("Фактическое значение цены не соответсвует ожидаемому значению. \nОжидаемое значение:\"%s\";\nФактическое значение:\"%s\";\n", priceExpected, actual);
        Assert.assertEquals(message, priceExpected, actual, 0.00f);
    }

    @Ignore
    @Test
    public void constructorIngredientTypeNullExpectedException() {
        Assert.assertThrows("Тип отсутствует. Объект класса Bun создан.Ожидаемая ошибка отсутствует.", Exception.class, () -> new Ingredient(null, "Сыр", 100));
    }

    @Ignore
    @Test
    public void constructorIngredientNameEmptyExpectedException() {
        Assert.assertThrows("Название пустое. Объект класса Bun создан.Ожидаемая ошибка отсутствует.", Exception.class, () -> new Ingredient(IngredientType.SAUCE, "", 150));
    }

    @Ignore
    @Test
    public void constructorIngredientNameNullExpectedException() {
        Assert.assertThrows("Название отсутствует. Объект класса Bun создан.Ожидаемая ошибка отсутствует.", Exception.class, () -> new Ingredient(IngredientType.FILLING, null, 100));
    }

    @Ignore
    @Test
    public void constructorIngredientPriceNegativeNumberExpectedException() {
        Assert.assertThrows("Цена отрицательная. Объект класса Bun создан. Ожидаемая ошибка отсутствует.", Exception.class, () -> new Ingredient(IngredientType.SAUCE, "Сырный соус", -100));
    }
}
