package burger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class BurgerMethodsTest {
    private IngredientType type;
    private String name;
    private Float price;
    public BurgerMethodsTest(IngredientType type, String name, float price){
        this.name = name;
        this.price = price;
        this.type = type;
    }
    Bun bun = mock(Bun.class);
    @Parameterized.Parameters(name = "ingredients: {0},{1},{2}")
    public static Object[] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.SAUCE,"",0},
                {IngredientType.SAUCE,"",-100},
        };
    }
    @Test
    public void addIngredientsTest(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(type, name, price));
        assertFalse("Что-то не так", burger.ingredients.isEmpty());
    }
    @Test
    public void removeIngredientTest(){
        Burger burger1 = new Burger();
        burger1.addIngredient(new Ingredient(type,name,price));
        burger1.removeIngredient(0);
        assertTrue("Fail",burger1.ingredients.isEmpty());
    }
    @Test
    public void moveIngredientTest(){
        Burger burger2 = new Burger();
        burger2.addIngredient(new Ingredient(type,name,price));
        burger2.addIngredient(new Ingredient(type,name,price));
        burger2.moveIngredient(0,1);
        Assert.assertNotNull("Fail",burger2.ingredients.get(0).toString());
    }
    @Test
    public void getReceiptTest(){
        Burger burger3 = new Burger();
        burger3.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(bun.getPrice()).thenReturn(1.0F);
        burger3.addIngredient(new Ingredient(type,name,price));
        Assert.assertNotNull("fail",burger3.getReceipt());
        System.out.print(burger3.getReceipt());
    }
    @Test
    public void getPriceTest(){
        Burger burger4 = new Burger();
        burger4.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(1F);
        burger4.addIngredient(new Ingredient(type,name,price));
        float expected = (1F*2)+price;
        assertEquals(expected,burger4.getPrice(),0.05);
    }
}
