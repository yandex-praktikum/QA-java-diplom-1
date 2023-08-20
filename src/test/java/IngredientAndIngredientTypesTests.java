import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientAndIngredientTypesTests {

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Котлета", 90.9F);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Цена ингридиента должно соотествовать парметрам обьекта",
                90.9F, actualPrice, 0.0);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Помидор", 20.8F);
        String actualName = ingredient.getName();
        Assert.assertEquals("Название ингридиента должно соответсоввать параметрам обьекта",
                "Помидор", actualName);
    }

    @Test
    public void getIngredientTypeFillingTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Салат", 15.6F);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Тип ингридиента должен быть FILLING",
                IngredientType.FILLING, actualType);

    }

    @Test
    public void getIngredientTypeSauceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Огурчики", 18.0F);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Тип ингридиента должен быть SAUCE",
                IngredientType.SAUCE, actualType);
    }
}
