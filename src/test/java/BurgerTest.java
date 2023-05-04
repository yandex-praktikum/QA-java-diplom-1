import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    @Mock
    Bun bun;
     Burger burger;
    Ingredient firstIngredient = (Ingredient) Mockito.mock(Ingredient.class);
    Ingredient secondIngredient = (Ingredient)Mockito.mock(Ingredient.class);

    @Before
    public void setUp(){
        this.burger= new Burger();}


    @Test
    public void checkSetBuns(){
        this.burger.setBuns(this.bun);
        Mockito.when(this.bun.getName()).thenReturn("black bun");
        String actual = this.bun.getName();
        Assert.assertEquals("Возвращается неверное имя булочки","black bun",actual);}

    @Test
    public void addIngredientTest(){
        this.burger.addIngredient(this.firstIngredient);
        Assert.assertEquals("Неверное количество ингридиентов в бургере",1,this.burger.ingredients.size());
    }
    @Test
    public void RemoveIngredientTest(){
        this.burger.addIngredient(this.firstIngredient);
        this.burger.removeIngredient(0);
        Assert.assertTrue("Ингридиент не удален", this.burger.ingredients.isEmpty());
    }
    @Test
    public void moveIngredientTest(){
        this.burger.addIngredient(this.firstIngredient);
        this.burger.addIngredient(this.secondIngredient);
        this.burger.moveIngredient(0,1);
        Assert.assertEquals("Ингридиенты не поменялись местами", "secondIngredient",this.burger.ingredients.get(0).toString());
    }
    @Test
    public void getReceiptTest(){
        Bun bun = new Bun("Bun", 120.0F);
    Ingredient sauce=new Ingredient(IngredientType.SAUCE,"Red",50);
    Ingredient filling= new Ingredient(IngredientType.FILLING,"cutlet",10);
     Burger burger = new Burger();
    burger.setBuns(bun);
    burger.addIngredient(sauce);
    burger.addIngredient(filling);
    String expectedString = "(==== Bun ====)\n= sauce Red =\n= filling cutlet =\n(==== Bun ====)\n\nPrice: 300,000000\n";
    String actualReceipt = burger.getReceipt();
    Assert.assertEquals("Ошибка",expectedString,actualReceipt);
    }
}
