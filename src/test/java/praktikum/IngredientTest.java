package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    СontainParam containParam = new СontainParam();
    Ingredient ingredient = new Ingredient(FILLING, containParam.getNameIngredient(),containParam.getPriceIngredient());

    @Test
    public void checkGetPriceIngredient() {
        assertEquals("Неверная цена ингридиента",containParam.getPriceIngredient(), ingredient.getPrice(), 0);
    }
    @Test
    public void checkGetNameIngredient() {
        assertEquals("Неверное название ингридиента",containParam.getNameIngredient(), ingredient.getName());
    }

    @Test
    public void checkGetTypeIngredient() {
        assertEquals("Неверный тип ингридиента",FILLING, ingredient.getType());
    }
}
