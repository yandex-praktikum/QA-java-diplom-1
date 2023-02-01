import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestIngridient {
    private final String name;
    private final float price;
    private final IngredientType type;
    private Ingredient ingredient;
    public TestIngridient(String name, IngredientType type, float price){
        this.name = name;
        this.type = type;
        this.price = price;
    }
@Parameterized.Parameters()
public static Object[][] DataIngredients(){
        return new Object[][]{
                {"Сырный", IngredientType.SAUCE, 100.2f},
                {"Сладкий чили", IngredientType.SAUCE, 200.2f},
                {"Говядина", IngredientType.FILLING, 350.2f},
                {"Свинина", IngredientType.FILLING, 250.2f},
        };
}

    @Test
    public void typeTest(){
        ingredient = new Ingredient( type, name ,  price);
        Assert.assertEquals(ingredient.type, ingredient.getType());
    }

    @Test
    public void nameTest(){
        ingredient = new Ingredient( type, name ,  price);
        Assert.assertEquals(ingredient.name, ingredient.getName());
    }

    @Test
    public void priceTest(){
        ingredient = new Ingredient( type, name ,  price);
        Assert.assertTrue(ingredient.price == ingredient.getPrice());
    }
}
