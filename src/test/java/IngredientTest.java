import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private float price;
    private String name;
    private IngredientType type;
    private Ingredient ingredient;
    public IngredientTest(float price, String name, IngredientType type) {
        this.price = price;
        this.name = name;
        this.type = type;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {67,"dshgkslfh",SAUCE},
                {0,"hdlkhksehjejlkdlk;dlkjlk",FILLING},
                {7969679699f,null,SAUCE},
                {0.0f,null,null},
                {1,"",FILLING},
                {10.65f,"Цезарь",SAUCE}

        };
    }
    @Before
    public  void startTest(){
        ingredient = new Ingredient(type,name,price);
    }
    @Test
    public void checkGetPriceIngredient(){
        Float actual = ingredient.getPrice();
        Assert.assertEquals("Цена дожна совпадать",price,actual, 2);
    }
    @Test
    public void checkGetNameIngredient(){
       String actual = ingredient.getName();
        assertEquals("Имя должно совпадать",name,actual);
    }
    @Test
    public void checkGetTypeIngredient(){
        IngredientType actual = ingredient.getType();
        assertEquals("Тип должен совпадать",type,actual);
    }
}
