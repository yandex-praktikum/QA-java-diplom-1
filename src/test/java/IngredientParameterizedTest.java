import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientParameters(){
        return new Object[][]{
                {IngredientType.FILLING, "Бекон", 2.5f},
                {IngredientType.SAUCE, "Шрирача", 3.0f},
        };
    }
    @Test
    public void getPriceIngredientParameterizedTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(price,ingredient.getPrice(),0);
    }

    @Test
    public void getNameIngredientParameterizedTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeIngredientParameterizedTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(type, ingredient.getType());
    }
}
