package praktikum.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String name;
    private final IngredientType type;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index}: ingredientType={0}, name={1}, price={2}")
    public static Object[] getIngredientData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Test
    public void checkIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Сравнение типов ингредиентов",type, ingredient.getType());
    }

    @Test
    public void checkName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Сравнение названий ингредиентов",name, ingredient.getName());
    }

    @Test
    public void checkPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Сравнение цен ингредиентов",price, ingredient.getPrice(), 0.01);
    }
}
