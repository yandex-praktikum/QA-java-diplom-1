package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {


    @Test
    public void ingredientCanGetName(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        String expected = "dinosaur";
        String actual = ingredient.getName();

        assertEquals(expected, actual);

    }

    @Test
    public void ingredientCanGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        float expectedPrice = 200;
        float actualPrice = ingredient.getPrice();

        assertEquals(expectedPrice, actualPrice, 200);
    }


    @Test
    public void ingredientCanGetType() {
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    IngredientType expectedType = IngredientType.FILLING;
    IngredientType actualType = ingredient.getType();

    assertEquals(expectedType, actualType);

    }
}
