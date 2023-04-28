package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    Ingredient ingredient;
    private String VALID_NAME_OF_INGREDIENT = "ValidName";
    private Float VALID_PRICE = 100F;

    @Test
    public void getNameValidDataPositiveResult(){
        ingredient = new Ingredient(IngredientType.SAUCE, VALID_NAME_OF_INGREDIENT, VALID_PRICE);
        Assert.assertEquals("Метод getName класса Ingredient, возвращает не корректное значение", VALID_NAME_OF_INGREDIENT, ingredient.getName());
    }
    @Test
    public void getPriceValidDataPositiveResult(){
        ingredient = new Ingredient(IngredientType.SAUCE, VALID_NAME_OF_INGREDIENT, VALID_PRICE);
        Assert.assertEquals("Метод getPrice класса Ingredient, возвращает не корректное значение",VALID_PRICE, ingredient.getPrice(), 0);
    }
    @Test
    public void getTypeSauseValidDataPositiveResult(){
        ingredient = new Ingredient(IngredientType.SAUCE, VALID_NAME_OF_INGREDIENT, VALID_PRICE);
        Assert.assertEquals("Метод getType класса Ingredient, возвращает не корректное значение", IngredientType.SAUCE,ingredient.getType());
    }
    @Test
    public void getTypeFillingValidDataPositiveResult(){
        ingredient = new Ingredient(IngredientType.FILLING, VALID_NAME_OF_INGREDIENT, VALID_PRICE);
        Assert.assertEquals("Метод getType класса Ingredient, возвращает не корректное значение", IngredientType.FILLING,ingredient.getType());
    }

}
