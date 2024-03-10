package Paket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] dataIngredientType() {
        return new Object[][]
                {
                        {IngredientType.SAUCE},
                        {IngredientType.FILLING},
                };
    }

    @Test
    public void checkIngredientType() {
        IngredientType expected = ingredientType;
        assertEquals("Ошибка в типе ингредиеннта", expected, IngredientType.valueOf(String.valueOf(ingredientType)));
    }
}