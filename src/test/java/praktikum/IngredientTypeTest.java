package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void valuesReturnExpectedEnumLength() {
        IngredientType[] ingredientTypesValues = IngredientType.values();

        assertEquals(
                "Количество ингредиентов отличается от ожидаемого",
                2,
                ingredientTypesValues.length);
    }
}