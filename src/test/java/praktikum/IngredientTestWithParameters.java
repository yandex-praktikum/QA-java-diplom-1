package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTestWithParameters {
    IngredientType type;
    String name;
    float price;
    public IngredientTestWithParameters(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус Spicy-X", 90},
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337},
                {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988},
                {IngredientType.FILLING, "Сыр с астероидной плесенью", 4142}
        };
    }
    //получить название ингридиента
    @Test
    public void getIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        System.out.println(ingredient.getName());
    }
    //получить стоимость ингридиентов
    @Test
    public void getIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        System.out.println(ingredient.getPrice());
    }
    //сравнение ингридиентов
    @Test
    public void shouldBeTwoIngredientTypesEquals() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }
    //сравнение названий ингридиентов
    @Test
    public void shouldBeTwoIngredientNamesEquals() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.name);
    }
    //сравнение стоимости ингридиентов
    @Test
    public void shouldBeTwoIngredientPricesEquals() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.price, 0);
    }
}
