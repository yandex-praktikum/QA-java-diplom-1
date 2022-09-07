import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

private final IngredientType type;
private final String name;
private final float price;

public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

@Parameterized.Parameters
 public static Object [][] ingredientParam() {
    return new Object[][]{
            {SAUCE,"Spicy-X",1},
            {FILLING,null,0},
            {SAUCE,"фирменный Space Sauce",-1},
            {FILLING,"",-0.3F}

    };
 }
@Test
public void nameTest(){
    Ingredient ingredient = new Ingredient(type,name,price);
    String actualName = ingredient.getName();
    Assert.assertEquals(actualName,name);
  }

@Test
public void priceTest(){
    Ingredient ingredient = new Ingredient(type,name,price);
    float actualPrice = ingredient.getPrice();
    Assert.assertTrue(actualPrice == price);

  }

}