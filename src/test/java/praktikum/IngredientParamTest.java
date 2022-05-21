package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType type;

    public IngredientParamTest(IngredientType type) {
        this.type = type;
    }


    @Parameterized.Parameters(name = "IngredientType:{0}")
    public static IngredientType[][] getTestData() {
        return new IngredientType[][]{
            {IngredientType.FILLING},
            {IngredientType.SAUCE}
    };
}



    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type,"nameOfIngredient",4.00F);
        ingredient.getPrice();
        Assert.assertEquals(ingredient.getPrice(), 4.00F, 0);
        Assert.assertEquals(ingredient.price,4.00F,0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, "nameOfIngredient", 3.00F);
        ingredient.getName();
        Assert.assertEquals(ingredient.getName(), "nameOfIngredient");
        Assert.assertEquals(ingredient.name,"nameOfIngredient");
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type,"nameOfIngredient", 3.00F);
        Assert.assertEquals(ingredient.getType(),type);
        Assert.assertEquals(ingredient.type, type);

    }
}