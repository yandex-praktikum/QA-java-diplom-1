import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

//@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private final String name = "Бургер";
    private final float price = 325;

//@Mock
    IngredientType type;


   @Test
    public void getPriceReturnPrice() {
       Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Бургер", ingredient.getName());
   }
   @Test
    public void getNameReturnName() {
       Ingredient ingredient = new Ingredient(type, name, price);
       assertEquals(325, ingredient.getPrice(), 0.01);
   }
   @Test
    public void getTypeReturnType() {
       Ingredient ingredient = new Ingredient(type, name, price);
       assertEquals(type, ingredient.getType());
   }
}
