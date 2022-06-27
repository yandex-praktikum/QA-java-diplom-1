import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    public IngredientType sauceType = IngredientType.SAUCE;
    public String sauceName = "Соус";
    public float soucePrice = 234f;
    Ingredient sauceIngridient = new Ingredient(sauceType, sauceName, soucePrice);

    public IngredientType fillingType = IngredientType.FILLING;
    public String fillingName = "Начинка";
    public float fillingPrice = 120f;
    Ingredient fillingIngridient = new Ingredient(fillingType, fillingName, fillingPrice);

    @Test
    public void souceIngridientTest() {
        assertEquals(sauceType, sauceIngridient.getType());
    }
    @Test
    public void sauceNameTest() {
        assertEquals(sauceName, sauceIngridient.getName());
    }
    @Test
    public void saucePriceTest() {
        assertEquals(soucePrice, sauceIngridient.getPrice(), 0);
    }
    @Test
    public void fillingIngridientTest() {
        assertEquals(fillingType, fillingIngridient.getType());
    }
    @Test
    public void fillingNameTest() {
        assertEquals(fillingName, fillingIngridient.getName());
    }
    @Test
    public void fillingPriceTest() {
        assertEquals(fillingPrice, fillingIngridient.getPrice(), 0);
    }
}
