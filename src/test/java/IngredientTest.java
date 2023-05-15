import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
   private Ingredient ingredient;

  private final String EXPECTED_NAME= "sauce";
  private final float EXPECTED_PRICE= 888.0F;


  @Before
      public void setUp(){
      this.ingredient=new Ingredient(IngredientType.SAUCE, "sauce",888.0F);}


  @Test
       public void getPriceTest(){
      Assert.assertEquals("Неверная цена ингридиента", EXPECTED_PRICE, this.ingredient.getPrice(),0.0);
  }
 @Test
    public void getNameTest(){
      Assert.assertEquals("Название ингридиента не совпадает",EXPECTED_NAME,this.ingredient.getName());
 }
 @Test
    public void getType(){
      Assert.assertEquals("Название ингридиента не совпадает",IngredientType.SAUCE,this.ingredient.getType());
  }
}
