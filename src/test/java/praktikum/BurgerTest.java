package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private
    Ingredient ingredient2;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
    burger.setBuns(bun);
    Assert.assertEquals(bun, burger.bun);
    }

   @Test
    public void addIngredientTest() {
    burger.addIngredient(ingredient1);
    burger.addIngredient(ingredient2);
    Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
     burger.addIngredient(ingredient1);
     burger.addIngredient(ingredient2);
     burger.removeIngredient(1);
     Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
     burger.addIngredient(ingredient1);
     burger.addIngredient(ingredient2);
     burger.moveIngredient(1, 0);
     Assert.assertEquals(2, burger.ingredients.size());
      }
        @Test
    public void getPriceTest () {
      when(bun.getPrice()).thenReturn(200f);
      when(ingredient1.getPrice()).thenReturn(300f);
      when(ingredient2.getPrice()).thenReturn(100f);
      float price = bun.getPrice() * 2;
      price += ingredient1.getPrice() + ingredient2.getPrice();
      Assert.assertEquals(800f, price, 0);
       }
        @Test
    public void getReceiptTest() {
      String bunName = "red bun"; //300
      String ingredient1Type = "sauce";
      String ingredient1Name = "chili sauce";//300
      String ingredient2Type = "filling";
      String ingredient2Name = "dinosaur";//200
      float price = 1100f;

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.getPrice() ;

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn(ingredient1Name);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn(ingredient2Name);
        Mockito.when(burger.getPrice()).thenReturn(price);


      StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
      receipt.append(String.format("= %s %s =%n", ingredient1Type, ingredient1Name));
      receipt.append(String.format("= %s %s =%n", ingredient2Type, ingredient2Name));
      receipt.append(String.format("(==== %s ====)%n", bunName));
      receipt.append(String.format("%nPrice: %f%n", price));

      Assert.assertEquals(receipt.toString(), burger.getReceipt());

          }

}