import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTestParam {
    private String name;
    private float price;
    private IngredientType type;
    private Ingredient ingredient;

    public IngredientTestParam(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {IngredientType.FILLING, "Bun", 10F},
                {IngredientType.FILLING, "Bun", -10F},
                {null, null, 0},
        };
    }

    @Before
    public void createIngredient() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0f);
    }

    @Test
    public void getTypeTest() {
        assertEquals(type, ingredient.getType());
    }

}