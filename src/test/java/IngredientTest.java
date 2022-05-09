import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

public class IngredientTest {
    private final IngredientType TYPE = IngredientType.SAUCE;
    private final String NAME = "tomatoes";
    private final float PRICE = new Random().nextFloat();

    private Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);

    @Test
    public void getName(){
        Assert.assertEquals("Название ингредиента не соответствует", NAME, ingredient.getName());
    }

    @Test
    public void getPrice(){
        Assert.assertEquals("Цена ингредиента не соответствует", PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void getType(){
        Assert.assertEquals("Тип ингредиента не соответствует", TYPE, ingredient.getType());
    }

}
