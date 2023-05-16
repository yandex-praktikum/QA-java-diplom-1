import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private final IngredientType type;
    private Ingredient ingredient;
    private final String name;
    private final float price;


    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData(){
        return new Object[][]{
                {SAUCE, "Перечный ад", 1000},
                {SAUCE, "майонез", Float.MIN_VALUE},
                {SAUCE, "ЧЕСНОЧНЫЙ", -2},
                {SAUCE, " ", 0},
                {FILLING,"салатик", Float.MAX_VALUE},
                {null,"котлетка",10.333f},
                {FILLING,null,-10.333333f},
                {FILLING,"", 22}
        };
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(type,name,price);
    }

    @Test
    public void testCheckIngredientPrice(){
        Assert.assertEquals(price,ingredient.getPrice(),0.001F);
    }
    @Test
    public void testCheckIngredientName(){
        Assert.assertEquals(name,ingredient.getName());
    }
    @Test
    public void testCheckIngredientType(){
        Assert.assertEquals(type,ingredient.getType());
    }

}
