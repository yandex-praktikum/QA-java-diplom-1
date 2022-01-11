package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class IngredientTests {

    @ParameterizedTest
    @EnumSource(IngredientType.class)
    void getIngredientParams(IngredientType type) {
        String name = "testName";
        Float price = 99F;
        Ingredient ingredient = new Ingredient(type, name, price);
        Assertions.assertAll(
                () -> Assertions.assertEquals(type, ingredient.getType(), "полученный тип не соответствует"),
                () -> Assertions.assertEquals(name, ingredient.getName(), "полученное имя не соответствует"),
                () -> Assertions.assertEquals(price, ingredient.getPrice(), "полученная цена не соответствует")
        );
    }
}
