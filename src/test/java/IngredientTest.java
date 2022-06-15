import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    public IngredientType sauceType = IngredientType.SAUCE;
    public String sauceName = "Соус";
    public float saucePrice = 234.4f;
    Ingredient sauceIngredient = new Ingredient(sauceType, sauceName, saucePrice);

    public IngredientType fillingType = IngredientType.FILLING;
    public String fillingName = "Начинка";
    public float fillingPrice = 123.8f;
    Ingredient fillingIngredient = new Ingredient(fillingType, fillingName, fillingPrice);

    @Test
    public void getSauceIngredientTest(){
        assertEquals(sauceType, sauceIngredient.getType());
    }

    @Test public void getSauceNameTest(){
        assertEquals(sauceName, sauceIngredient.getName());
    }

    @Test
    public void getSaucePriceTest(){
        assertEquals(saucePrice, sauceIngredient.getPrice(), 0);
    }

    @Test
    public void getFillingIngredientTest(){
        assertEquals(fillingType, fillingIngredient.getType());
    }

    @Test public void getFillingNameTest(){
        assertEquals(fillingName, fillingIngredient.getName());
    }

    @Test
    public void getSauceFillingTest(){
        assertEquals(fillingPrice, fillingIngredient.getPrice(), 0);
    }


}