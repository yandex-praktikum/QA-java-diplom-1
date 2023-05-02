import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType type;
    private final String name;
    private final float price;


    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {SAUCE, "майонез", 10f},
                {SAUCE, null, 10f},
                {FILLING, "котлета", 200f},
                {null, "котлета", 200f},
                {FILLING, "огурчики", 0},
        };
    }


    @Test
    public void ingredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Название ингредиента некорректное", name, ingredient.getName());
    }

    @Test
    public void ingredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Стоимость ингредиента некорректная", price, ingredient.getPrice(), 0);
    }

    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Тип ингредиента некорректный", type, ingredient.getType());
    }

}
