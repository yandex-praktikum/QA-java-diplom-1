import org.junit.Assert;
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

    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    private final String nameSauce = "Сырный";
    private final String nameFilling = "Лук";
    private final String nameBun = "Толстяк";
    private final float priceBun = 0.021f;
    private final float priceFilling = 3.1f;
    private final float priceSauce = 2.4f;

    @Test
    public void addIngredientTest(){
        int expectedResult = 1;
        burger.addIngredient(ingredient);
        Assert.assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        int expectedResult = 4;
        int i = 0;
        while (i < 5){
            burger.addIngredient(ingredient);
            i++;
        }
        burger.removeIngredient(1);
        Assert.assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        for(int i = 0; i < 2; i++){
            if(burger.ingredients.size() % 2 == 0){
                burger.addIngredient(new Ingredient(IngredientType.FILLING, nameFilling, priceFilling));
            } else {
                burger.addIngredient(new Ingredient(IngredientType.SAUCE, nameSauce, priceSauce));
            }
        }
        burger.moveIngredient(1, 0);

        Assert.assertEquals(nameSauce, burger.ingredients.get(0).getName());
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient.getPrice()).thenReturn(priceFilling);

        Assert.assertEquals((priceBun * 2) + priceFilling, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(nameSauce);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient.getPrice()).thenReturn(priceSauce);

        String expectedResult = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                nameBun, IngredientType.SAUCE.toString().toLowerCase(),
                nameSauce, nameBun, ((priceBun * 2) + priceSauce));

        Assert.assertEquals("Неверный чек", expectedResult, burger.getReceipt());
    }

}