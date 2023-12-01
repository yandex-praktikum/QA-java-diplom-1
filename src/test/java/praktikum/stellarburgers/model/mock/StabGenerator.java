package praktikum.stellarburgers.model.mock;

import praktikum.stellarburgers.model.Bun;
import praktikum.stellarburgers.model.Ingredient;
import praktikum.stellarburgers.model.IngredientType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static praktikum.stellarburgers.model.IngredientType.FILLING;
import static praktikum.stellarburgers.model.IngredientType.SAUCE;

public class StabGenerator {

    public static Bun getBunStub(String name, float price) {
        Bun bunStub = mock(Bun.class);
        when(bunStub.getName()).thenReturn(name);
        when(bunStub.getPrice()).thenReturn(price);
        return bunStub;
    }

    private static Ingredient getIngredientStub(IngredientType type, String name, float price) {
        Ingredient ingredientStub = mock(Ingredient.class);
        when(ingredientStub.getType()).thenReturn(type);
        when(ingredientStub.getName()).thenReturn(name);
        when(ingredientStub.getPrice()).thenReturn(price);
        return ingredientStub;
    }

    public static Ingredient getSauceStub(String name, float price) {
        return getIngredientStub(SAUCE, name, price);
    }

    public static Ingredient getFillingStub(String name, float price) {
        return getIngredientStub(FILLING, name, price);
    }
}
