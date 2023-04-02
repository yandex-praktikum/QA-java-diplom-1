import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;

    private final float price;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "Соус Spicy-X", 90},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 1337},
        };
    }

    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Некорректный тип ингредиента",type, ingredient.getType());
    }

    @Test
    public void getIngredientNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Некорректное имя ингредиента", name, ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Некорректная цена ингредиента", price, ingredient.getPrice(), 0.01);
    }
}
