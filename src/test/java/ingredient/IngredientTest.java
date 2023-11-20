package ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private Float price;
    public IngredientTest(IngredientType type, String name, float price){
        this.name = name;
        this.price = price;
        this.type = type;
    }
    @Parameterized.Parameters(name = "ingredients: {0},{1},{2}")
    public static Object[] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 50},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.SAUCE,"",0},
                {IngredientType.SAUCE,"",-100},
        };
    }
    @Test
    public void getCorrectIngredientTypeTest(){
        Ingredient ingredient1 = new Ingredient(type,name,100F);
        Ingredient ingredient = Mockito.spy(ingredient1);
        assertEquals("Fail",type,ingredient.getType());
    }
    @Test
    public void getCorrectNameTest(){
        Ingredient ingredient1 = new Ingredient(type,name,price);
        Ingredient ingredient = Mockito.spy(ingredient1);
        String actualName = ingredient.getName();
        assertEquals("Fail",name,actualName);
    }
    @Test
    public void getCorrectPriceTest(){
        Ingredient ingredient1 = new Ingredient(type,name,price);
        Ingredient ingredient = Mockito.spy(ingredient1);
        Float actualPrice = ingredient.getPrice();
        assertEquals("Fail", price,actualPrice);
    }
}
